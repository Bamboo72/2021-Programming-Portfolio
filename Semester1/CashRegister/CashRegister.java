/**
* This code was copied from the Big Java textbook, but modified by Jacob Schwartz for an assignment
* @author Jacob Schwartz
* @version 1.0
* @since 2020-10-14
*/

public class CashRegister{

  public static final double QUARTER_VALUE = 0.25;
  public static final double DIME_VALUE = 0.10;
  public static final double NICKEL_VALUE = 0.05;
  public static final double PENNY_VALUE = 0.01;

  private double purchase;
  private double payment;

  /**
     Constructs a cash register with no money in it.
  */
  public CashRegister()
  {
     purchase = 0;
     payment = 0;
  }

  /**
     Records the purchase price of an item.
     @param amount the price of the purchased item
  */
  public void recordPurchase(double amount)
  {
     purchase = purchase + amount;
  }

  /**
     Processes the payment received from the customer.
     @param dollars the number of dollars in the payment
     @param quarters the number of quarters in the payment
     @param dimes the number of dimes in the payment
     @param nickels the number of nickels in the payment
     @param pennies the number of pennies in the payment
  */
  public void receivePayment(int dollars, int quarters,
        int dimes, int nickels, int pennies)
  {
     payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE
           + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
  }

  /**
     Computes the change due .
     @return the change due to the customer
  */
  public double giveChange()
  {
     double change = payment - purchase;
     return change;
  }

  /**
  * Resets the machine for the next customer
  */
  public void reset(){
    purchase = 0;
    payment = 0;
  }

  /**
     Adds the parameter amount to the payment being made.
     @param amount the amount of dollars being paid
  */
  public void enterDollars(int amount){
    payment += amount;
  }

  /**
     Adds the parameter amount to the payment being made.
     @param amount the amount of quarters being paid
  */
  public void enterQuarters(int amount){
    payment += amount * QUARTER_VALUE;
  }

  /**
     Adds the parameter amount to the payment being made.
     @param amount the amount of dimes being paid
  */
  public void enterDimes(int amount){
    payment += amount * DIME_VALUE;
  }

  /**
     Adds the parameter amount to the payment being made.
     @param amount the amount of nickels being paid
  */
  public void enterNickels(int amount){
    payment += amount * NICKEL_VALUE;
  }

  /**
     Adds the parameter amount to the payment being made.
     @param amount the amount of pennies being paid
  */
  public void enterPennies(int amount){
    payment += amount * PENNY_VALUE;
  }

  public double dollarsBack(double change){
    if(change > 1){
      double num = change / 1;
      change = change % 1;
      return num;
    }
    return 0;
  }

  public double quartersBack(double change){
    if(change > QUARTER_VALUE){
    double num = change / QUARTER_VALUE;
    change = change % QUARTER_VALUE;
    return num ;
    }
    return 0;
  }

  public double dimesBack(double change){
    if(change > DIME_VALUE){
      double num = change / DIME_VALUE;
      change = change % DIME_VALUE;
      return num;
    }
    return 0;
  }

  public double nickelsBack(double change){
    if(change > NICKEL_VALUE){
      double num = change / NICKEL_VALUE;
      change = change % NICKEL_VALUE;
      return num;
    }
    return 0;
  }

  public double penniesBack(double change){
    if(change > PENNY_VALUE){
      double num = change / PENNY_VALUE;
      change = change % PENNY_VALUE;
      return num;
    }
    return 0;
  }

}
