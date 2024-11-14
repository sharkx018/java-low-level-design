package Problems.onlineStockBrokerageSystem;

public class Stock {
    private String symbol;
    private String name;
    private double price;

    Stock(String symbol, String name, double price){
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void updatePrice(double price) {
        this.price = price;
    }

}
