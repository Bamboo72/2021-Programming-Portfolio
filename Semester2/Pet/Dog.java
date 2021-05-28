/**
* @author Jacob Schwartz
* @version 1.0
* @since 2021-1-3
*/

package Pet;

public class Dog extends Pet {
  private String favoriteToy;
  private String furType;
  private String breed;

  public Dog(){
    setNumOfLegs(4);
    favoriteToy = "Unknown";
    furType = "Unknown";
    breed = "Unknown";
    setPetType("dog");
  }

  public void setBreed(String newBreed){
    breed = newBreed;
  }

  public void setFurType(String type){
    furType = type;
  }

  public void setFavoriteToy(String toy){
    favoriteToy = toy;
  }

  public String getDescription(){
    return "Its breed is " + breed + ". Its fur type is " + furType + ". Its favorite toy is " + favoriteToy + ".";
  }

}
