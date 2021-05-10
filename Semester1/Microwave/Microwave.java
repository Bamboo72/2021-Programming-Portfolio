import java.util.concurrent.TimeUnit;

/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-10-8
*/
public class Microwave{

    private int powerlevel = 1;
    private int time;


/** This method sets the time to the user input
* @param input This param is what the timer is set to
*/
  public void setTime(int input){
    time = input;
  }

  /** This method adds 30 to the timer
  */
  public void addThirty(){
    time += 30;
  }

  /** This method gets the timer
  * @return int This is the time
  */
  public int getTimer(){
    return time;
  }

  /** This method resets the timer to 0
  */
  public void reset(){
    time = 0;
  }

  /** This method switches the power level between 1 and 2
  */
  public void changePower(){
    if(powerlevel == 1){
      powerlevel = 2;
    } else {
      powerlevel = 1;
    }
  }

  /** This method gets the power powerlevel
  * @return int This is the power level
  */
  public int powerGet(){
    return powerlevel;
  }

  /** This method starts the timer and sleeps for the amount of seconds on the timer
  */
  public void start(){
    int startTime = time;
    for(int i = 0; i < startTime; i++){
      time --;
      try {
          Thread.sleep(1000);
      }
      catch(InterruptedException e){
        Thread.currentThread().interrupt();
      }
    }
  }

}
