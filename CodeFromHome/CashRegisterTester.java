import java.util.Scanner;

/**
* This code was copied from the Big Java textbook, but modified by Jacob Schwartz
* @author Jacob Schwartz
* @version 1.0
* @since 2020-10-14
*/

public class CashRegisterTester{

  public static void main(String[] args){
    {
      CashRegister register = new CashRegister();
      Scanner inputReader = new Scanner(System.in);
      double input = 0;

      System.out.println("How much is the purchase?");
      input = inputReader.nextDouble();
      register.recordPurchase(input);

      System.out.println("What do you want to pay?");
      System.out.println("(1) Dollars, (2) Quarters, (3) Dimes, (4) Nickels, (5) Pennies");
      input = inputReader.nextDouble();
      if(input == 1){
        System.out.println("How many dollars do you want to pay?");
        input = inputReader.nextDouble();
        register.enterDollars((int) input);
      } else if(input == 2){
        System.out.println("How many quarters do you want to pay?");
        input = inputReader.nextDouble();
        register.enterQuarters((int) input);
      } else if(input == 3){
        System.out.println("How many dimes do you want to pay?");
        input = inputReader.nextDouble();
        register.enterDimes((int) input);
      } else if(input == 4){
        System.out.println("How many nickels do you want to pay?");
        input = inputReader.nextDouble();
        register.enterNickels((int) input);
      } else {
        System.out.println("How many pennies do you want to pay?");
        input = inputReader.nextDouble();
        register.enterPennies((int) input);
      }

      System.out.println("Change: " + register.giveChange());
      inputReader.close();
}

  }

}
