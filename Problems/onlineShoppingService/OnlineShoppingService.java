package Problems.onlineShoppingService;

import Problems.onlineShoppingService.payment.Payment;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineShoppingService {

    private static OnlineShoppingService instance;
    private Map<String, User> userMap;
    private Map<String , Product> productMap;
    private Map<String , Order> orderMap;

    private OnlineShoppingService(){
        userMap = new ConcurrentHashMap<>();
        productMap = new ConcurrentHashMap<>();
        orderMap = new ConcurrentHashMap<>();
    }

    public static synchronized OnlineShoppingService getInstance(){
        if(instance == null){
            instance = new OnlineShoppingService();
        }
        return instance;
    }

    public void registerUser(User user){
        this.userMap.put(user.getId(), user);
    }


    public User getUser(String userId){
        User user = this.userMap.get(userId);
        return user;
    }


    public void addProduct(Product product){
        this.productMap.put(product.getId(), product);
    }

    public Product getProduct(String productId){
        return this.productMap.get(productId);
    }


    public List<Product> searchProducts(String keyword){
        List<Product> searchedProducts = new ArrayList<>();
        for(Product product: this.productMap.values()){
            if(product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    product.getDescription().toLowerCase().contains(keyword.toLowerCase())
            ){
                searchedProducts.add(product);
            }
        }

        return searchedProducts;
    }


    public Order placeOrder(ShoppingCart shoppingCart, Payment payment, User user){

        List<OrderItem> orderItems = new ArrayList<>();

        for(OrderItem orderItem: shoppingCart.getItems()){
            Product product = orderItem.getProduct();
            int orderedQty = orderItem.getQuantity();

            if(product.isAvailable(orderedQty)){
                product.updateQuantity(-orderedQty);
                orderItems.add(orderItem);
            }
        }


        if(orderItems.isEmpty()){
            throw new IllegalStateException("No product available for order");
        }


        Order order = new Order(generateOrderId(), user, orderItems);
        double amount = order.getTotalPrice();


        if(payment.processPayment(amount)){
            orderMap.put(order.getId(), order);
            user.addOrder(order);
            order.setStatus(OrderStatus.PROCESSING);
            shoppingCart.clear();

        }else{
            order.setStatus(OrderStatus.CANCELLED);

            for(OrderItem orderItem: orderItems){
                Product product = orderItem.getProduct();
                int orderedQty = orderItem.getQuantity();
                product.updateQuantity(orderedQty);
            }
        }

        return order;
    }

    public Order getOrder(String orderId){
        return this.orderMap.get(orderId);
    }


    private String generateOrderId(){
        return UUID.randomUUID().toString();
    }

}
