
import java.util.Scanner;

/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-09-30
*/
public class BankTester{

  /**
     * This is the main method which makes use of BankAccount class.
     * @param args Unused.
     */
  public static void main(String[] args){

    BankAccount myAccount = new BankAccount(100);
    Scanner inputReader = new Scanner(System.in);

    double input;
    boolean run = true;
    boolean feePaid = false;

    System.out.println("Welcome to our bank! What would you like to do?");
    while(run){
      System.out.println(" (1) Make a Deposit \n (2) Make a Withdrawal \n (3) Check Balance \n (4) Pay your Monthly Fee \n (5) Exit");
      input = inputReader.nextDouble();

      if(input == 1){
        System.out.println("How much would you like to deposit?");
        input = inputReader.nextDouble();
        myAccount.deposit(input);

      } else if(input == 2){
        System.out.println("How much would you like to withdraw?");
        input = inputReader.nextDouble();
        myAccount.withdrawal(input);
        System.out.println("Transaction fee of $" + myAccount.transactionFee() + " taken from your account.");

      } else if(input == 3){

        System.out.println(" Your balance is $" + myAccount.getBalance());

      } else if(input == 4){
        if(!feePaid){
          System.out.println(" Your monthly fee is $" + myAccount.getMonthlyFee());
          System.out.println(" Do you want to pay it now? (1) Yes (2) No " );
          input = inputReader.nextDouble();
          if(input == 1){
            myAccount.deductMonthlyFee();
            System.out.println("Thank you for paying your monthly fee!");
            feePaid = true;
          } else {
            System.out.println("Be sure to pay that soon!");
          }
        } else {
          System.out.println("Your fee is already paid!");
        }


      } else if(input == 5){
        System.out.println("Thank you for using our services ☺");
        run = false;
      } else {
        System.out.println("Input error, please try again.");
      }
    }



  }

}
