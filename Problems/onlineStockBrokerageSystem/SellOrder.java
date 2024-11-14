package Problems.onlineStockBrokerageSystem;

public class SellOrder extends Order{
    SellOrder(String orderId, Account account, Stock stock, int quantity, double price) {
        super(orderId, account, stock, quantity, price);
    }

    @Override
    public void execute() {
        double totalCost = price * quantity;
        if(account.getPortfolio().canRemoveStock(stock, quantity)){
            account.deposit(totalCost);
            this.account.getPortfolio().removeStock(stock, quantity);
            this.orderStatus = OrderStatus.EXECUTED;
        }else{
            System.out.println("Stock are not sufficient to sell ");
            this.orderStatus = OrderStatus.REJECTED;
        }

    }
}
