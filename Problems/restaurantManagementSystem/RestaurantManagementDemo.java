package Problems.restaurantManagementSystem;

import Problems.restaurantManagementSystem.payment.Payment;
import Problems.restaurantManagementSystem.payment.PaymentMethod;
import Problems.restaurantManagementSystem.payment.PaymentStatus;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class RestaurantManagementDemo {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();

        MenuItem item1 = new MenuItem("m1", "menu1", "desc1", true, 100);
        MenuItem item2 = new MenuItem("m2", "menu2", "desc2", true, 150);
        MenuItem item3 = new MenuItem("m3", "menu3", "desc3", true, 130);

        restaurant.addMenuItems(item1);
        restaurant.addMenuItems(item2);
        restaurant.addMenuItems(item3);

        Order order1 = new Order("O1", Arrays.asList(item1), OrderStatus.PENDING, 100, new Timestamp(System.currentTimeMillis()));
        restaurant.placeOrder(order1);

        // process payment
        restaurant.processPayment(new Payment("1", 100, PaymentMethod.CASH, PaymentStatus.PENDING));

        // make reservation
        restaurant.makeReservation(new Reservation("1", "John", "1234324", 34, new Timestamp(System.currentTimeMillis())));

        // update order status
        order1.setStatus(OrderStatus.PREPARING);
        order1.setStatus(OrderStatus.READY);
        order1.setStatus(OrderStatus.COMPLETED);


        // add staff
        Staff s1 = new Staff("s1", "Suraj", "Chef", "2342342");
        Staff s2 = new Staff("s2", "Ravi", "Manager", "2342342");
        restaurant.addStaff(s1);
        restaurant.addStaff(s2);

        // list down menuitems
        List<MenuItem> menuItems = restaurant.getMenuItems();
        for(MenuItem menuItem: menuItems){
            System.out.println(menuItem.getName() + " - $ " + menuItem.getPrice());
        }
    }
}
