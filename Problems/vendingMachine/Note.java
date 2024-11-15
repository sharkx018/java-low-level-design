package Problems.vendingMachine;

public enum Note {

    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20);

    private double value;

    Note(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
