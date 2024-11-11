package Problems.foodDeliveryService.order;

import Problems.foodDeliveryService.DeliveryAgent;

import java.util.List;

public class Order {
    private String id;
    private List<OrderItem> orderItems;
    private double totalPrice;
    private DeliveryAgent deliveryAgent;
    private OrderStatus orderStatus;

    public Order(String id, List<OrderItem> orderItems){
        this.id = id;
        this.orderItems = orderItems;
        this.orderStatus = OrderStatus.PENDING;
        this.totalPrice = calculateTotalPrice(orderItems);

    }

    private double calculateTotalPrice(List<OrderItem> orderItems){
        double totalPrice = 0;
        for(OrderItem orderItem: orderItems){
            totalPrice += orderItem.getPrice();
        }

        return totalPrice;
    }

    public String getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void assignDeliveryAgent(DeliveryAgent deliveryAgent){
        this.deliveryAgent = deliveryAgent;
    }

    public void setOrderStatus(OrderStatus status){
        this.orderStatus =status;
    }

}