package Problems.foodDeliveryService;


import Problems.foodDeliveryService.order.Order;
import Problems.foodDeliveryService.order.OrderItem;
import Problems.foodDeliveryService.order.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryDemo {
    public static void main(String[] args) {
        FoodDeliveryService foodDeliveryService = FoodDeliveryService.getInstance();

        // register Users
        Customer user = new Customer("C001", "Mukul Verma", "mukul@gmail.com","234234234" , "123");
        foodDeliveryService.registerCustomer(user);



        // register Delivery Agents
        DeliveryAgent deliveryAgent = new DeliveryAgent("D001", "bot", "12343244", true);
        foodDeliveryService.registerDeliveryAgent(deliveryAgent);


        // add Menu items
        List<MenuItem> menu1 = new ArrayList<>();
        menu1.add(new MenuItem("M001", "Dahi Jalebi", "diabetic friendly food", 30));
        menu1.add(new MenuItem("M002", "Lassi", "diabetic friendly food", 50));
        menu1.add(new MenuItem("M003", "French Fries", "obesity friendly food", 60));

        // register Restaurants
        Restaurant restaurant = new Restaurant("R001", "Diplomat Hotel", "Fatehpur", menu1);
        foodDeliveryService.registerRestaurant(restaurant);


        // list all restaurants
        System.out.println("Listing of all restaurants");
        for(Restaurant restaurant1: foodDeliveryService.getAvailableRestaurants()){
            System.out.println(restaurant1.getId() + ", " + restaurant1.getName() + ", " + restaurant1.getAddress());
        }


        // list the menu items for restaurants
        System.out.println("Listing of all menuitem for restaurant R001");

        for(MenuItem menuItem: foodDeliveryService.getMenuItems("R001")){
            System.out.println("Id: "+menuItem.getId() + ", name: " + menuItem.getName() + ", description: " + menuItem.getDescription() +", price: Rs " +menuItem.getPrice());
        }



        // place order
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(menu1.get(0), 1, 30));
        orderItems.add(new OrderItem(menu1.get(2), 2, 60));
        Order order = foodDeliveryService.placeOrder("C001","R001", orderItems);


        // update order status
        order.setOrderStatus(OrderStatus.CONFIRMED);
        System.out.println("Order Status changed: " + order.getOrderStatus());

        // cancel order
        foodDeliveryService.cancelOrder(order.getId());


    }
}
