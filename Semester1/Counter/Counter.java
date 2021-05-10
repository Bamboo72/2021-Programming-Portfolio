// Jacob Schwartz - 9/30/2020

/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-09-30
*/
public class Counter {

  private int value;

  /**
  * This is the default constructor
  * @param None.
  */
  public Counter(){
    value = 0;
  }

  /**
  * This is the second constructor for passing in an int
  * @param start this is the int you want the counter to start
  */
  public Counter(int start){
    value = start;
  }

  /**
  @return int This returns the private int value
  */
  public int getValue() {
    return value;
  }

  /**
  * This increases the value by 1.
  * @return Nothing
  */
  public void click() {
    value++;
  }

  /**
  * This decreases the value by 1.
  * @return Nothing
  */
  public void undo(){
    value--;
  }

  /**
  * This resets the value to 0.
  * @return Nothing
  */
  public void reset(){
    value = 0;
  }

}
