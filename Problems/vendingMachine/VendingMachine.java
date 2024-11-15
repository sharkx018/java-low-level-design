package Problems.vendingMachine;

import Problems.vendingMachine.state.*;

public class VendingMachine {
    private static VendingMachine instance;
    private double totalAmount;
    private Product selectedProduct;
    private Inventory inventory;
    private VendingMachineState currentState;
    private IdleState idleState;
    private ReadyState readyState;
    private DispenseState dispenseState;
    private ReturnChangeState returnChangeState;

    private VendingMachine(){
        totalAmount = 0;
        selectedProduct = null;
        inventory = new Inventory();
        currentState = new IdleState(this);
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
    }

    public static synchronized VendingMachine getInstance(){
        if(instance == null){
            instance = new VendingMachine();
        }
        return instance;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public void selectProduct(Product product){
        this.currentState.selectProduct(product);;
    }

    public void insertCoin(Coin coin) {
        this.currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        this.currentState.insertNote(note);
    }

    public void dispense(){
        this.currentState.dispense();;
    }

    public void returnChange(){
        this.currentState.returnChange();;
    }



    public void resetSelectedProduct(){
        this.selectedProduct = selectedProduct;
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public ReadyState getReadyState() {
        return readyState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public ReturnChangeState getReturnChangeState() {
        return returnChangeState;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void resetPayment(){
        this.totalAmount = 0.0;
    }

    public void addCoin(Coin coin) {
        this.totalAmount += coin.getValue();
    }

    public void addNote(Note note) {
        this.totalAmount += note.getValue();
    }
}
