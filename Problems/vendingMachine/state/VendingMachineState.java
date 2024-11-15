package Problems.vendingMachine.state;

import Problems.vendingMachine.Coin;
import Problems.vendingMachine.Note;
import Problems.vendingMachine.Product;

public interface VendingMachineState {
    public void selectProduct(Product product);

    public void insertCoin(Coin coin);

    public void insertNote(Note note);

    public void dispense();

    public void returnChange();
}
