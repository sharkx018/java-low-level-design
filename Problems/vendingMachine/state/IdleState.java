package Problems.vendingMachine.state;

import Problems.vendingMachine.Coin;
import Problems.vendingMachine.Note;
import Problems.vendingMachine.Product;
import Problems.vendingMachine.VendingMachine;

public class IdleState implements VendingMachineState{

    private VendingMachine vendingMachine;

    public IdleState(VendingMachine instance){
        this.vendingMachine = instance;
    }

    @Override
    public void selectProduct(Product product) {
        if(vendingMachine.getInventory().isAvailable(product)){
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setCurrentState(vendingMachine.getReadyState());
            System.out.println("Product selected: " + product.getName() + " - " + product.getDescription());
        }else{
            System.out.println("Product not available: "+ product.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select the product first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select the product first");
    }

    @Override
    public void dispense() {
        System.out.println("Please select a product and make payment");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return");
    }
}
