package Problems.onlineStockBrokerageSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Portfolio {
    private Account account;
    private Map<String , Integer> holdings;

    Portfolio(Account account){
        this.account = account;
        holdings = new ConcurrentHashMap<>();
    }

    public void addStocks(Stock stock, int quantity){
        this.holdings.put(stock.getSymbol(), this.holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
    }

    public void removeStock(Stock stock, int quantity){
        if(this.holdings.get(stock.getSymbol()) != null){
            int currentQty = this.holdings.get(stock.getSymbol());
            if(quantity < currentQty ){
                this.holdings.put(stock.getSymbol(), currentQty- quantity);
            }else if(quantity == currentQty){
                this.holdings.remove(stock.getSymbol());
            }else{
                throw new IllegalStateException("Insufficient stock in the portfolio");
            }
        }else{
            throw new IllegalStateException("Stock not found in the portfolio");
        }

    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public boolean canRemoveStock(Stock stock, int quantity){
        if(this.holdings.get(stock.getSymbol()) != null){
            int currentQty = this.holdings.get(stock.getSymbol());
            return currentQty >= quantity;
        }else{
            return false;
        }
    }
}
