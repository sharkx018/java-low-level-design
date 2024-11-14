package Problems.onlineShoppingService;

public class OrderItem {

    private Product product;
    private int quantity;

    OrderItem(Product product, int quantity){
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

}
