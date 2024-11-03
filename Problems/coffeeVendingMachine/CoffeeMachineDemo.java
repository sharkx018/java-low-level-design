package Problems.coffeeVendingMachine;

import Problems.coffeeVendingMachine.Coffe.Coffee;

import java.util.Map;

public class CoffeeMachineDemo {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

        coffeeMachine.showCoffeeList();
        coffeeMachine.dispenseCoffee("Latte", 3);

        coffeeMachine.showCoffeeList();
        coffeeMachine.dispenseCoffee("Latte", 3);

        coffeeMachine.showCoffeeList();
        coffeeMachine.dispenseCoffee("Latte", 3);

    }
}