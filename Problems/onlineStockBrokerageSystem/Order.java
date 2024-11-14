package Problems.onlineStockBrokerageSystem;

public abstract class Order {

    protected String orderId;
    protected Account account;
    protected Stock stock;
    protected int quantity;
    protected double price;
    protected OrderStatus orderStatus;

    Order(String orderId, Account account, Stock stock, int quantity, double price){
        this.orderId = orderId;
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.orderStatus = OrderStatus.PENDING;
    }

    public abstract void execute();

}

