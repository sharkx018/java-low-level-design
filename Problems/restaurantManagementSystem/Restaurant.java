package Problems.restaurantManagementSystem;

import Problems.restaurantManagementSystem.payment.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Restaurant {
    private static Restaurant instance;
    private List<MenuItem> menuItems;
    private Map<String, Order> orderMap;
    private Map<String, Payment> paymentMap;
    private List<Reservation> reservations;
    private List<Staff> staffs;


    private Restaurant(){
        this.menuItems = new CopyOnWriteArrayList<>();
        this.reservations = new CopyOnWriteArrayList<>();
        this.staffs = new CopyOnWriteArrayList<>();
        this.orderMap = new ConcurrentHashMap<>();
        this.paymentMap = new ConcurrentHashMap<>();
    }

    public synchronized static Restaurant getInstance(){
        if(instance == null){
            instance = new Restaurant();
        }
        return instance;
    }

    public void addStaff(Staff staff){
        this.staffs.add(staff);
    }

    public void removeStaff(Staff staff){
        this.staffs.remove(staff);
    }

    public void addMenuItems(MenuItem menuItem){
        this.menuItems.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem){
        this.menuItems.remove(menuItem);
    }

    public void placeOrder(Order order){
        this.orderMap.put(order.getId(), order);
        // notify kitchen
        notifyKitchen();

    }

    public void updateOrderStatus(String orderId, OrderStatus status){
        Order order = this.orderMap.get(orderId);
        if(order!= null){
            order.setStatus(status);
            notifyStaff();
        }
    }

    public void processPayment(Payment payment){
        this.paymentMap.put(payment.getId(), payment);
    }


    public void makeReservation(Reservation reservation){
        this.reservations.add(reservation);
    }

    public void cancelReservation(Reservation reservation){
        this.reservations.remove(reservation);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void notifyKitchen(){

    }

    public void notifyStaff(){

    }


}
