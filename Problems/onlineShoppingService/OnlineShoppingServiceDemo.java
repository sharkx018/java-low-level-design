package Problems.onlineShoppingService;

import Problems.onlineShoppingService.payment.CreditCardPayment;
import Problems.onlineShoppingService.payment.Payment;

import java.util.List;

public class OnlineShoppingServiceDemo {

    public static void main(String[] args) {
        OnlineShoppingService onlineShoppingService = OnlineShoppingService.getInstance();

        Product p1 = new Product("p1", "product1", "desc1", 10, 5);
        Product p2 = new Product("p2", "product2", "desc2", 8, 13);
        Product p3 = new Product("p3", "product3", "desc3", 6, 104);
        Product p4 = new Product("p4", "product4", "desc4", 12, 19);

        onlineShoppingService.addProduct(p1);
        onlineShoppingService.addProduct(p2);
        onlineShoppingService.addProduct(p3);
        onlineShoppingService.addProduct(p4);

        User user1 = new User("U1", "Mukul", "mukul@gmal.com", "password");
        User user2 = new User("U2", "Aryan", "aryan@gmal.com", "password");
        onlineShoppingService.registerUser(user1);
        onlineShoppingService.registerUser(user2);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(p1, 3);
        cart.addItem(p2, 1);
        Payment payment1 = new CreditCardPayment();
        Order order1 = onlineShoppingService.placeOrder(cart, payment1, user1);
        System.out.println("Order Placed: " + order1.getId());

        List<Product> searchedProducts = onlineShoppingService.searchProducts("product3");
        System.out.println("Searched Product Result: " + searchedProducts.size());
        for(Product product : searchedProducts){
            System.out.println("- " + product.getName() + " " + product.getDescription());
        }

        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem(searchedProducts.get(0), 1);
        Order order2 = onlineShoppingService.placeOrder(cart2, payment1, user2);
        System.out.println("Order Placed: " + order2.getId());

        // see user order history
        for(Order order: user1.getOrders()){
            System.out.println("Order Id: " + order.getId());
            System.out.println("Order Status: " + order.getStatus());
            System.out.println("Order Total Price: " + order.getTotalPrice());
        }

    }
}
