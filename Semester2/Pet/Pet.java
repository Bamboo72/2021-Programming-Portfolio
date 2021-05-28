/**
* @author Jacob Schwartz
* @version 1.0
* @since 2021-1-3
*/

package Pet;

public class Pet {
  private int numOfLegs;
  private String species;
  private String owner;
  private String name;
  private String petType;

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

  public String getPetType(){
    return petType;
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
  public void setPetType(String newPetType){
    petType = newPetType;
  }

  public String getDescription(){
    return "This pet has " + numOfLegs + " legs. It's name is " + name + ".";
  }

}
