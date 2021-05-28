/**
* @author Jacob Schwartz
* @version 1.0
* @since 2021-1-3
*/

package Pet;

public class Bird extends Pet {
  private boolean wingsClipped;
  private String beakType;
  private int wingSpan;

  public Bird(){
    setNumOfLegs(2);
    wingsClipped = false;
    beakType = "Unknown";
    wingSpan = 0;
    setPetType("bird");
  }

  public void setWingsClipped(boolean newAns){
    wingsClipped = newAns;
  }

  public void setBeakType(String type){
    beakType = type;
  }

  public void setWingSpan(int span){
    wingSpan = span;
  }

  public String getDescription(){
    return "Its beak type is " + beakType + ". Are its wings clipped? " + wingsClipped + ". Its wing span is " + wingSpan + ".";
  }
}
