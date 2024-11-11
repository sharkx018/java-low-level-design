package Problems.foodDeliveryService;

import Problems.foodDeliveryService.order.Order;
import Problems.foodDeliveryService.order.OrderItem;
import Problems.foodDeliveryService.order.OrderStatus;

import java.util.*;

public class FoodDeliveryService {
    private static FoodDeliveryService instance;
    private Map<String, Restaurant> restaurants;
    private Map<String, Customer> customers;
    private Map<String, Order> orders;
    private Map<String, DeliveryAgent> deliveryAgentMap;

    private FoodDeliveryService(){
        this.restaurants = new HashMap<>();
        this.customers = new HashMap<>();
        this.orders = new HashMap<>();
        this.deliveryAgentMap = new HashMap<>();
    }

    public synchronized static FoodDeliveryService getInstance() {
        if(instance == null){
            instance = new FoodDeliveryService();
        }

        return instance;
    }


    public void registerRestaurant(Restaurant restaurant){
        this.restaurants.put(restaurant.getId(), restaurant);
    }

    public void registerCustomer(Customer customer){
        this.customers.put(customer.getId(), customer);
    }

    public void registerDeliveryAgent(DeliveryAgent deliveryAgent){
        this.deliveryAgentMap.put(deliveryAgent.getId(), deliveryAgent);
    }

    public List<Restaurant> getAvailableRestaurants(){
        return new ArrayList<>( this.restaurants.values());
    }

    public List<MenuItem> getMenuItems(String restaurantId){
        Restaurant restaurant = restaurants.get(restaurantId);
        if(restaurant != null){
            return restaurant.getMenuItems();
        }

        return new ArrayList<>();
    }

    public Order placeOrder(String customerId, String restaurantId, List<OrderItem> items){
        Customer customer = customers.get(customerId);
        if(customer == null){
            System.out.println("Customer not found");
            return null;
        }

        Restaurant restaurant = restaurants.get(restaurantId);
        if(restaurant == null){
            System.out.println("Restaurant not found");
            return null;
        }

        Order order = new Order(generateOrderId(), items);
        orders.put(order.getId(), order);
        //notify the restaurant
        notifyRestaurant();
        System.out.println("Order Placed with orderId: " + order.getId());
        return order;
    }

    private String generateOrderId(){
        return "Odr:" + UUID.randomUUID();
    }


    public void updateOrderStatus(String orderId, OrderStatus status){
        Order order = orders.get(orderId);
        if(order == null){
            System.out.println("[updateOrderStatus] Order not found");
            return;
        }

        order.setOrderStatus(status);
        notifyCustomer();
        if(status == OrderStatus.CONFIRMED){
            assignDeliveryAgent(order);
        }
    }

    public void cancelOrder(String orderId){
        Order order = orders.get(orderId);
        if(order == null){
            System.out.println("[cancelOrder] Order not found");
            return;
        }

        order.setOrderStatus(OrderStatus.CANCELLED);
        notifyCustomer();
        notifyRestaurant();
        System.out.println("Order cancelled:" + orderId);
    }

    public void notifyCustomer(){

    }

    private void notifyRestaurant(){

    }

    private void notifyDeliveryAgent(){

    }


    public void assignDeliveryAgent(Order order){

        for(Map.Entry<String, DeliveryAgent> deliveryAgent: deliveryAgentMap.entrySet()){
            DeliveryAgent deliveryAgent1 = deliveryAgent.getValue();
            if(deliveryAgent1.isAvailable()){
                deliveryAgent1.setAvailable(false);
                order.assignDeliveryAgent(deliveryAgent1);
                notifyDeliveryAgent();
                break;
            }
        }

    }

}