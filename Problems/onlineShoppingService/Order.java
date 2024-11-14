package Problems.onlineShoppingService;

import java.util.List;

public class Order {
    private String id;
    private User user;
    private List<OrderItem> orderItems;
    private OrderStatus status;
    private double totalPrice;

    Order(String id, User user, List<OrderItem> orderItems){
        this.id = id;
        this.user = user;
        this.orderItems = orderItems;
        this.status = OrderStatus.PENDING;
        this.totalPrice = calculateTotalPrice(orderItems);
    }
    private double calculateTotalPrice(List<OrderItem> orderItems){
        double res = 0;
        for(OrderItem orderItem: orderItems){
            res +=  orderItem.getProduct().getPrice();
        }

        return res;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

}
