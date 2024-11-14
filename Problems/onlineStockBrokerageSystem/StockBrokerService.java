package Problems.onlineStockBrokerageSystem;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class StockBrokerService {

    private static StockBrokerService instance;
    private Map<String , Account> accountMap;
    private Map<String, Stock> stockMap;
    private Queue<Order> orderQueue;
    private AtomicInteger accountCounter;

    private StockBrokerService(){
        accountMap = new ConcurrentHashMap<>();
        stockMap = new ConcurrentHashMap<>();
        orderQueue = new ConcurrentLinkedQueue<>();
        accountCounter = new AtomicInteger(1);
    }


    public static  synchronized StockBrokerService getInstance(){
        if(instance == null){
            instance = new StockBrokerService();
        }

        return instance;
    }

    public void createAccount(User user, double initialBalance){
        Account account = new Account(generateAccountId(), user, initialBalance);
        this.accountMap.put(account.getId(), account);

    }

    public Account getAccount(String accountId){
        return accountMap.get(accountId);
    }

    public void addStock(Stock stock){
        this.stockMap.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol){
        return this.stockMap.get(symbol);
    }

    public void placeOrder(Order order){
        this.orderQueue.offer(order);
        processOrders();
    }

    public void processOrders(){
        while(this.orderQueue.isEmpty() == false){
            Order order = orderQueue.poll();
            try{
                order.execute();
            }catch (IllegalStateException e){
                System.out.println("Order failed: " + e.getMessage());
            }
        }
    }


    private String generateAccountId() {
        int accountId = accountCounter.getAndIncrement();
        return "A" + String.format("%03d", accountId);
    }


}
