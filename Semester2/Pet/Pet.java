/**
* @author Jacob Schwartz
* @version 1.0
* @since 2021-1-3
*/

public class Pet {
  private int numOfLegs;
  private String species;
  private String owner;
  private String name;

  public int getNumOfLegs(){
    return numOfLegs;
  }

  public String getSpecies(){
    return species;
  }

  public String getName(){
    return name;
  }

  public String getOwner(){
    return owner;
  }

  public void setNumOfLegs(int num){
    numOfLegs = num;
  }

  public void setSpecies(String newSpecies){
    species = newSpecies;
  }

  public void setName(String newName){
    name = newName;
  }

  public void setOwner(String newOwner){
    owner = newOwner;
  }

  public String getDescription(){
    return "This pet has " + numOfLegs + " legs. It's name is " + name + ".";
  }

}
