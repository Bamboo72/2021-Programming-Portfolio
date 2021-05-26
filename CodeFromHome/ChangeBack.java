/**
 * This project directs a cashier on how much change they should give the customer.
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-10-20
 */

public class ChangeBack {

    private double price, paid, change;
    public int dollars, quarters, dimes, nickels, pennies;
    public static final double DOLLAR_VALUE = 100;
    public static final double QUARTER_VALUE = 25;
    public static final double DIME_VALUE = 10;
    public static final double NICKEL_VALUE = 05;
    public static final double PENNY_VALUE = 1;

    /**
     * This method sets the price and converts it to pennies
     * 
     * @param amount The amount that needs to be paid
     */
    public void setPrice(double amount) {
        price = amount * 100;
    }

    /**
     * This method adds to the amount paid and converts it to pennies
     * 
     * @param amount The amount that is being paid
     */
    public void addPay(double amount) {
        paid = amount * 100;
    }

    /**
     * This method calculates the initial value for how much change should be given
     */
    public void changeCalc() {
        change = (int) (paid - price);
    }

    /**
     * This method calculates how the change should be given back. Ex: 1 dollar, 3
     * quarters, 0 dimes, 0 nickels, 1 penny
     * 
     * @return feedback which is how many dollars, quarters, etc...
     */
    public String changeBack() {

        dollars = (int) (change / DOLLAR_VALUE);
        change -= dollars * 100;

        quarters = (int) (change / QUARTER_VALUE);
        change -= quarters * 25;

        dimes = (int) (change / DIME_VALUE);
        change -= dimes * 10;

        nickels = (int) (change / NICKEL_VALUE);
        change -= nickels * 5;

        pennies = (int) (change / PENNY_VALUE);
        change -= pennies;

        if(dollars < 0 || quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0){
            String feedback = "The customer hasn't paid enough!";
            return feedback;
        }

        String feedback = "You should give the customer " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickels
                + " nickels, and " + pennies + " pennies.";
        return feedback;
    }

}
