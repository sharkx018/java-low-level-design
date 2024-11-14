package Problems.onlineStockBrokerageSystem;

public class BuyOrder extends Order{

    BuyOrder(String orderId, Account account, Stock stock, int quantity, double price) {
        super(orderId, account, stock, quantity, price);
    }

    @Override
    public void execute() {
        double totalCost = price * quantity;
        if(account.getBalance() >= totalCost){
            account.withdraw(totalCost);
            account.getPortfolio().addStocks(stock, quantity);
            orderStatus = OrderStatus.EXECUTED;
        }else{
            orderStatus = OrderStatus.REJECTED;
            System.out.println("Insufficient funds to execute the buy order");
        }
    }
}
