package Problems.vendingMachine.state;

import Problems.vendingMachine.Coin;
import Problems.vendingMachine.Note;
import Problems.vendingMachine.Product;
import Problems.vendingMachine.VendingMachine;

public class ReturnChangeState implements VendingMachineState{

    private VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void selectProduct(Product product) {

    }

    @Override
    public void insertCoin(Coin coin) {

    }

    @Override
    public void insertNote(Note note) {

    }

    @Override
    public void dispense() {

    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalAmount() - vendingMachine.getSelectedProduct().getPrice();
        if(change > 0){
            System.out.println("Change Returned: $"+change);
            vendingMachine.resetPayment();
        }else{
            System.out.println("No change to return");
        }

        vendingMachine.resetSelectedProduct();
        vendingMachine.setCurrentState(vendingMachine.getIdleState());


    }
}
