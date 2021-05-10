// Jacob Schwartz - 9/28/2020
// An inventory system for my CYO Adventure game.

public class Inventory {
  int bagSize = 5;
  public static void main(String[] args){

    String[bagSize] inventory = {"armor", "sword", "boots", "green slime", "red slime"};
    int[bagSize] quantity = {0, 0, 0, 13, 8};

    System.out.println("0-----------------------------------------0")
    for(String i : inventory){
        System.out.println(" - " + inventory[i]);
    }

    System.out.println("0-----------------------------------------0")
  }
}
