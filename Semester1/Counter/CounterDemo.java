/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-09-30
*/

public class CounterDemo {

  /**
     * This is the main method which makes use of Counter class.
     * @param args Unused.
     * @return Nothing.
     */

  public static void main(String[] args){
    System.out.println("These numbers are just for the unit test:");

// tally starts at 0 and tally2 starts at 5
    Counter tally = new Counter();
    Counter tally2 = new Counter(5);

// print out the initial values for tally and tally2
    System.out.println("Initial value: " + tally.getValue());
    System.out.println("2nd Initial value: " + tally2.getValue());

// This will set tally to 2, tally2 to 6
    tally.click();
    tally.click();
    tally2.click();
// This will set tally2 to 5 again
    tally2.undo();

// This is used to save the current total of tally
    int result = tally.getValue();

  // This will set tally back to 0
    tally.reset();

// This will print the final values
    System.out.println("Value: " + tally.getValue());
    System.out.println("Value used to be " + result);
    System.out.println("2nd Value: " + tally2.getValue());

  }
}
