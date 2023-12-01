package machine;
import java.util.Scanner;

public class CoffeeMachine { 
    
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");   
            UseCoffeeMachine.chooseAction(sc.next()); 
        } 
    }
}     
    
class UseCoffeeMachine {
    
    enum Status {
    CHOOSEACTION, BUY, FILL, TAKE, REMAINING, EXIT
}
    
    static int waterInStock = 400;
    static int milkInStock = 540;
    static int coffeeInStock = 120;
    static int cupsInStock = 9;
    static int cash = 550;
    static Status status = Status.CHOOSEACTION;
    static Scanner sc = new Scanner(System.in);
    
    public static void chooseAction(String input) {               
        switch (input) {
            case "buy":
                status = Status.BUY;
                buy();               
                break;
            case "fill":
                status = Status.FILL;
                fill();              
                break;
            case "take":
                status = Status.TAKE;
                take();
                break;
            case "remaining":
                status = Status.REMAINING;
                printSupplies();               
                break;
            case "exit":
                status = Status.EXIT;
                System.exit(0);  
        } 
    }
    
    public static void printSupplies() {
        System.out.println("The coffee machine has:\n"
                + waterInStock + " ml of water\n"
                + milkInStock + " ml of milk\n"         
                + coffeeInStock + " g of coffee beans\n"
                + cupsInStock + " disposable cups\n"
                + "$" + cash + " of money"); 
        System.out.println();
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = sc.next();
        switch (input) {
            case "1":
                if (waterInStock >= 250 && coffeeInStock >= 15 && cupsInStock >= 1) {
                    waterInStock -= 250;             
                    coffeeInStock -= 16;
                    cupsInStock -= 1;
                    cash += 4; 
                    printPossible();
                } else if (waterInStock < 250) {
                    printNoWater();
                } else if (coffeeInStock < 15) {
                    printNoCoffee();
                } else if (cupsInStock < 1) {
                    printNoCups();
                }
                break;
            case "2":
                if (waterInStock >= 350 && milkInStock >= 75 && coffeeInStock >= 20 && cupsInStock >= 1) {
                    waterInStock -= 350;  
                    milkInStock -= 75;
                    coffeeInStock -= 20;
                    cupsInStock -= 1;
                    cash += 7;
                    printPossible();
                } else if (waterInStock < 350) {
                    printNoWater();
                } else if (milkInStock < 75) {
                    printNoMilk();
                } else if (coffeeInStock < 20) {
                    printNoCoffee();
                } else if (cupsInStock < 1) {
                    printNoCups();
                }
                break;
            case "3":
                if (waterInStock >= 200 && milkInStock >= 100 && coffeeInStock >= 12 && cupsInStock >= 1) {
                    waterInStock -= 200;  
                    milkInStock -= 100;
                    coffeeInStock -= 12;
                    cupsInStock -= 1;
                    cash += 6;
                    printPossible();
                } else if (waterInStock < 200) {
                    printNoWater();
                } else if (milkInStock < 100) {
                    printNoMilk();
                } else if (coffeeInStock < 12) {
                    printNoCoffee();
                } else if (cupsInStock < 1) {
                    printNoCups();
                }
                break;
            case "back":
                System.out.println();
                break;
        }
        System.out.println();
    }
    
    public static void printPossible() {
         System.out.println("I have enough resources, making you a coffee!");
    }
    
    public static void printNoWater() {
         System.out.println("Sorry, not enough water!");
    }
    
    public static void printNoMilk() {
         System.out.println("Sorry, not enough milk!");
    }
    
    public static void printNoCoffee() {
         System.out.println("Sorry, not enough coffee beans!");
    }
    
    public static void printNoCups() {
         System.out.println("Sorry, not enough cups!");
    }
    
    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        waterInStock += Integer.parseInt(sc.next());
        System.out.println("Write how many ml of milk you want to add:");
        milkInStock += Integer.parseInt(sc.next());
        System.out.println("Write how many ml of coffee beans you want to add:");
        coffeeInStock += Integer.parseInt(sc.next());
        System.out.println("Write how many disposable cups you want to add:");
        cupsInStock += Integer.parseInt(sc.next());
        System.out.println();
    }
    
    public static void take() {
        System.out.println("I gave you $" + cash);
        cash -= cash;
        System.out.println();
    }
}