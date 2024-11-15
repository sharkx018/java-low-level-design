package Problems.vendingMachine;

public class VendingMachineDemo {
    public static void main(String[] args) {

        VendingMachine vendingMachine = VendingMachine.getInstance();

        Product product1 = new Product("1","Coke", "d1" ,1.5);
        Product product2 = new Product("2","Pepsi", "d2",1.5);
        Product product3 = new Product("3", "Water", "d3",1.0);

        vendingMachine.getInventory().addProduct(product1, 5);
        vendingMachine.getInventory().addProduct(product2, 3);
        vendingMachine.getInventory().addProduct(product3, 2);

        vendingMachine.selectProduct(product1);

        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);

        vendingMachine.insertNote(Note.FIVE);

        vendingMachine.dispense();

        vendingMachine.returnChange();

        // Select another product
        vendingMachine.selectProduct(product2);

        vendingMachine.insertCoin(Coin.QUARTER);

        vendingMachine.dispense();

        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);

        vendingMachine.dispense();

        vendingMachine.returnChange();
    }
}
