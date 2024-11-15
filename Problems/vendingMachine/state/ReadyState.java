package Problems.vendingMachine.state;

import Problems.vendingMachine.Coin;
import Problems.vendingMachine.Note;
import Problems.vendingMachine.Product;
import Problems.vendingMachine.VendingMachine;

public class ReadyState implements VendingMachineState{

    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please make payment.");
    }

    @Override
    public void insertCoin(Coin coin) {
        this.vendingMachine.addCoin(coin);
        System.out.println("Coin Inserted: "+ coin);
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        this.vendingMachine.addNote(note);
        System.out.println("Note Inserted: "+ note);
        checkPaymentStatus();
    }

    @Override
    public void dispense() {
        System.out.println("Please make payment first.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment first.");
    }


    private void checkPaymentStatus(){
        if(vendingMachine.getTotalAmount() >= vendingMachine.getSelectedProduct().getPrice()){
            this.vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        }
    }
}
