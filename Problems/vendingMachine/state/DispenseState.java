package Problems.vendingMachine.state;

import Problems.vendingMachine.Coin;
import Problems.vendingMachine.Note;
import Problems.vendingMachine.Product;
import Problems.vendingMachine.VendingMachine;

public class DispenseState implements VendingMachineState {

    private VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already made. Please collect the dispensed product.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already made. Please collect the dispensed product.");
    }

    @Override
    public void dispense() {
        Product product = vendingMachine.getSelectedProduct();
        int count = vendingMachine.getInventory().getQuantity(product);
        vendingMachine.getInventory().updateQuantity(product, count-1);
        System.out.println("Product dispensed: "+ product.getName());
        this.vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the dispensed product first.");
    }
}
