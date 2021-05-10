/**
* @author Jacob Schwartz
* @version 1.0
* @since 2021-1-3
*/

import java.util.Scanner;
import java.util.ArrayList;

public class PetTester {

  public static void print(Dog d){
    System.out.println("This dog's name is: " + d.getName());
    System.out.println(d.getDescription());

  }

  public static void main(String[] args){

    boolean run = true;
    String input = "";
    Scanner inputReader = new Scanner(System.in);
    List<Pet> pets = new Pet<>;

    // Pet hmm = new Pet();
    // System.out.println(hmm.getDescription);

    Dog dog = new Dog();
    print(dog);

    System.out.println("After studying the dog further...");

    dog.setName("Lucky");
    dog.setFurType("Long Haired");
    dog.setOwner("You");

print(dog);

    // while(run){
    //   System.out.println("Select an option:");
    //   System.out.println("(1) Display Pets (2) Add Pet (3) Modify Pet (Q) Quit");
    //   input = inputReader.next();
    //   if(input.equals("1")){
    //     System.out.println("Displaying Pets...");
    //   } else if(input.equals("2")){
    //     System.out.println("Adding Pet...");
    //   } else if(input.equals("3")){
    //     System.out.println("Modify dat Pet...");
    //   } else if(input.equals("Q")){
    //     run = false;
    //   } else {
    //     System.out.println("Error! Please try again.");
    //   }
    // }
  }

}
