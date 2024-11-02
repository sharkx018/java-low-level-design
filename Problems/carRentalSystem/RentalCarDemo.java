package Problems.carRentalSystem;

import java.time.LocalDate;
import java.util.List;

public class RentalCarDemo {
    public static void main(String[] args) {

        RentalSystem rentalSystem = RentalSystem.getInstance();



        // Cars
        Car car1 = new Car("Audi", "Q5", "2024", "LP-AUDI", 89);
        Car car2 = new Car("Kia", "K5", "2024", "LP-KIA", 90);
        Car car3 = new Car("BMW", "M5", "2024", "LP-BMW", 90);


        Customer customer = new Customer("DRIVING-LICENSE", "mukulv018", "8318183455", "aryanv018@gmail.com" );

        rentalSystem.addCars(car1);
        rentalSystem.addCars(car2);
        rentalSystem.addCars(car3);

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);

        List<Car> searchedCar = rentalSystem.searchCars("BMw", "m5", startDate, endDate);

        if(!searchedCar.isEmpty()){
            Car selectedCar = searchedCar.get(0);
            System.out.println("Searched Car: " + selectedCar.getMake() + "-" + selectedCar.getModel() );
            Reservation reservation = rentalSystem.makeReservation(customer, selectedCar, startDate, endDate);
            if(reservation!=null){
                System.out.println("Reservation Done, ReservationId: " + reservation.getReservationId());
                Boolean isPaymentSuccess = rentalSystem.processPayment(reservation);
                if(isPaymentSuccess){
                    System.out.println("Payment Successful for Reservation!");
                }else{
                    System.out.println("Payment Failed for Reservation!");
                    rentalSystem.cancelReservation(reservation.getReservationId());
                }
            }else{
                System.out.println("Reservation for selected car failed!");
            }
        }else{
            System.out.println("Searched Cars not found");
        }






    }
}
