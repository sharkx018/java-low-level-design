package Problems.onlineStockBrokerageSystem;

public class StockBrokerageDemo {
    public static void main(String[] args) {
        StockBrokerService stockBrokerService = StockBrokerService.getInstance();


        User user = new User("U001", "John Doe", "john@gmail.com");
        stockBrokerService.createAccount(user, 10000);
        Account account = stockBrokerService.getAccount("A001");

        // add stocks to the stock broker
        Stock stock1 = new Stock("AAPL", "Apple Inc.", 150.0);
        Stock stock2 = new Stock("GOOGL", "Alphabet Inc.", 200.0);
        stockBrokerService.addStock(stock1);
        stockBrokerService.addStock(stock2);

        // place and buy order
        Order buyOrder1 = new BuyOrder("O001", account, stock1, 10, 150.0);
        Order buyOrder2 = new BuyOrder("O002", account, stock2, 5, 200.0);
        stockBrokerService.placeOrder(buyOrder1);
        stockBrokerService.placeOrder(buyOrder2);

        // place sell order
        Order sellOrder1 = new SellOrder("O003", account, stock1, 5, 160);
        stockBrokerService.placeOrder(sellOrder1);

        // show balance and portfolio
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Portfolio: " + account.getPortfolio().getHoldings());


    }
}
