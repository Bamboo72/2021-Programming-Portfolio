import java.util.Scanner;

/**
* This code was copied from the Big Java textbook, but modified by Jacob Schwartz for an assignment
* @author Jacob Schwartz
* @version 1.0
* @since 2020-10-14
*/

public class CashRegisterTester{

  public static void main(String[] args){


    {
   CashRegister register = new CashRegister();
   System.out.println("Purchase: $20.37, Paid with 20 Dollars, 2 Quarters");
   register.recordPurchase(20.37);
   register.enterDollars(20);
   register.enterQuarters(2);
   System.out.println("Change: " + register.giveChange());
   System.out.println("Expected: 0.13");
   System.out.print("Change back in " + register.dollarsBack(register.giveChange()) + " dollars, ");
   System.out.print( register.quartersBack(register.giveChange()) + " quarters, ");
   System.out.print( register.dimesBack(register.giveChange()) + " dimes, ");
   System.out.print( register.nickelsBack(register.giveChange()) + " nickels, ");
   System.out.println( register.penniesBack(register.giveChange()) + " pennies, ");
   register.reset();

}

  }

}
