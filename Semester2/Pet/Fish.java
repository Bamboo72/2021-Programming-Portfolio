/**
* @author Jacob Schwartz
* @version 1.0
* @since 2021-1-3
*/

package Pet;

public class Fish extends Pet {
  private boolean hasScales;
  private int numOfFins;
  private String waterType;

  public Fish(){
    setNumOfLegs(0);
    hasScales = true;
    numOfFins = 0;
    waterType = "Unknown";
    setPetType("fish");
  }

  public void setNumOfFins(int num){
    numOfFins = num;
  }

  public void setWaterType(String type){
    waterType = type;
  }

  public void setHasScales(boolean newAns){
    hasScales = newAns;
  }

  public String getDescription(){
    return "It lives in " + waterType + ". Does it have scales? " + hasScales + ". It has " + numOfFins + " fins.";
  }

}
