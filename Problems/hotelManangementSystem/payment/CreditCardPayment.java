package Problems.hotelManangementSystem.payment;

public class CreditCardPayment implements PaymentProcessor{


    @Override
    public boolean processPayment(double payment) {
        return true;
    }
}
