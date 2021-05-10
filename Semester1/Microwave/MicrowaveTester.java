import java.util.Scanner;

/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-10-8
*/
public class MicrowaveTester{

  /**
     * This is the main method which makes use of BankAccount class.
     * @param args Unused.
     */
  public static void main(String[] args){

    Microwave mw = new Microwave();
    Scanner inputReader = new Scanner(System.in);
    int input;
    boolean run = true;

    while(run){
      System.out.println("Timer: " + mw.getTimer());
      System.out.println("(1) Set timer (2) Add 30 seconds (3) Reset (4) Switch power level (5) Start");
      input = inputReader.nextInt();
      if(input == 1){
        System.out.println("What do you want to set the timer to? (In seconds)");
        input = inputReader.nextInt();
        mw.setTime(input);
      } else if (input == 2){
        mw.addThirty();
      } else if (input == 3){
        mw.reset();
      } else if (input == 4){
        mw.changePower();
        System.out.println("Power level switched to " + mw.powerGet());
      } else {
        run = false;
        System.out.println("Cooking for " + mw.getTimer() + " seconds...");
        mw.start();
        System.out.println("DIING! Your food is done!");
      }
    }


  }

}
