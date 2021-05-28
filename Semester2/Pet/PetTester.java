
/**
* @author Jacob Schwartz
* @version 1.0
* @since 2021-1-3
*/


package Pet;

import java.util.Scanner;
import java.util.ArrayList;

public class PetTester {

  public static void print(Pet p) {
    System.out.println("This " + p.getPetType() + "'s name is: " + p.getName() + ". It's owner is " + p.getOwner()
        + ". Its species is " + p.getSpecies() + " and it has " + p.getNumOfLegs() + " legs");
    System.out.println(p.getDescription());

  }

  public static void main(String[] args) {

    boolean run = true;
    String input = "";
    Scanner inputReader = new Scanner(System.in);
    ArrayList<Pet> pets = new ArrayList<>();

    Dog setUpDog = new Dog();
    setUpDog.setName("PlaceholderDog");
    pets.add(setUpDog);
    Bird setUpBird = new Bird();
    setUpBird.setName("PlaceholderBird");
    pets.add(setUpBird);

    while (run) {
      input = "";
      System.out.println("Select an option:");
      System.out.println("(1) Display Pets (2) Add Pet (3) Modify Pet (Q) Quit");
      input = inputReader.next();
      if (input.equals("1")) {
        System.out.println("• Displaying Pets:");

        for (int i = 0; i < pets.size(); i++) {
          System.out.println(" - " + i + ": " + pets.get(i).getName() + " the " + pets.get(i).getPetType());
        }

        System.out.println("Type a number to look at a pet closer, or type Q to go to the menu.");
        input = inputReader.next();

        if (input.equals("Q")) {
          System.out.println("Back to the menu");
        } else if (input.matches("-?\\d+")) { // If the String is an Int taken from
                                              // https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java

          if (Integer.parseInt(input) < pets.size()) {
            print(pets.get(Integer.parseInt(input)));

          } else {
            System.out.println("That number is not on the list");
          }
        } else {
          System.out.println("That input not recognized");
        }

      } else if (input.equals("2")) {
        System.out.println("• Adding Pet:");
        System.out.println("What kind of pet do you want to add? (1) Dog (2) Fish (3) Bird (4) Cancel");
        input = inputReader.next();

        if (input.equals("1")) {
          Dog dog = new Dog();
          System.out.println("What do you want to name this dog?");
          dog.setName(inputReader.next());
          pets.add(dog);
        } else if (input.equals("2")) {
          Fish fish = new Fish();
          System.out.println("What do you want to name this fish?");
          fish.setName(inputReader.next());
          pets.add(fish);
        } else if (input.equals("3")) {
          Bird bird = new Bird();
          System.out.println("What do you want to name this bird?");
          bird.setName(inputReader.next());
          pets.add(bird);
        } else if (input.equals("4")) {
          System.out.println("Canceled");
        } else {
          System.out.println("Input not recognized");
        }
      } else if (input.equals("3")) {
        int modifyNumber = 0;
        boolean inLoop = false;
        String placeholder = "";
        int numPlaceholder = 0;
        boolean booleanPlaceholder;
        input = "";

        System.out.println("• Modifying Pet:");
        System.out.println("Which pet do you want to modify?");
        for (int i = 0; i < pets.size(); i++) {
          System.out.println(" - " + i + ": " + pets.get(i).getName() + " the " + pets.get(i).getPetType());
        }
        modifyNumber = inputReader.nextInt();
        inLoop = true;

        System.out.println("C3");

        while (inLoop) {
          System.out.println("What would you like to modify about " + pets.get(modifyNumber).getName() + "?");
          System.out.println("(1) Name (2) Owner (3) Species (4) Number of Legs");
          if (pets.get(modifyNumber).getPetType().equals("dog")) {
            System.out.println("(5) Breed (6) Fur type (7) Favorite toy");

          } else if (pets.get(modifyNumber).getPetType().equals("fish")) {
            System.out.println("(5) Has Scales or Not (6) Number of Fins (7) Water type");

          } else if (pets.get(modifyNumber).getPetType().equals("bird")) {
            System.out.println("(5) Has Clipped Wings or Not (6) Wingspan (7) Beak type");

          }
          System.out.println("Or (8) Exit Modifier");

          input = inputReader.next();

          if (pets.get(modifyNumber).getPetType().equals("dog")) {
            Dog tempDog = (Dog) pets.get(modifyNumber);

            if (input.equals("5")) {
              System.out.print("Set breed to: ");
              placeholder = inputReader.next();
              tempDog.setBreed(placeholder);

            } else if (input.equals("6")) {
              System.out.print("Set fur type to: ");
              placeholder = inputReader.next();
              tempDog.setFurType(placeholder);

            } else if (input.equals("7")) {
              System.out.print("Set favorite toy to: ");
              placeholder = inputReader.next();
              tempDog.setFavoriteToy(placeholder);

            }
          }

          else if (pets.get(modifyNumber).getPetType().equals("fish")) {
            Fish tempFish = (Fish) pets.get(modifyNumber);

            if (input.equals("5")) {
              System.out.print("Set if it has scales or not to: ");
              booleanPlaceholder = inputReader.nextBoolean();
              tempFish.setHasScales(booleanPlaceholder);

            } else if (input.equals("6")) {
              System.out.print("Set favorite toy to: ");
              numPlaceholder = inputReader.nextInt();
              tempFish.setNumOfFins(numPlaceholder);

            } else if (input.equals("7")) {
              System.out.print("Set favorite toy to: ");
              placeholder = inputReader.next();
              tempFish.setWaterType(placeholder);

            }
          }

          else if (pets.get(modifyNumber).getPetType().equals("bird")) {
            Bird tempBird = (Bird) pets.get(modifyNumber);

            if (input.equals("5")) {
              System.out.print("Set if its wings are clipped or not to: ");
              booleanPlaceholder = inputReader.nextBoolean();
              tempBird.setWingsClipped(booleanPlaceholder);

            } else if (input.equals("6")) {
              System.out.print("Set wing span to: ");
              numPlaceholder = inputReader.nextInt();
              tempBird.setWingSpan(numPlaceholder);

            } else if (input.equals("7")) {
              System.out.print("Set beak type to: ");
              placeholder = inputReader.next();
              tempBird.setBeakType(placeholder);

            }
          }

          if (input.equals("1")) {
            System.out.print("Set name to: ");
            placeholder = inputReader.next();
            pets.get(modifyNumber).setName(placeholder);

          } else if (input.equals("2")) {
            System.out.print("Set owner to: ");
            placeholder = inputReader.next();
            pets.get(modifyNumber).setOwner(placeholder);

          } else if (input.equals("3")) {
            System.out.print("Set species to: ");
            placeholder = inputReader.next();
            pets.get(modifyNumber).setSpecies(placeholder);

          } else if (input.equals("4")) {
            System.out.print("Set number of legs to: ");
            placeholder = inputReader.next();
            pets.get(modifyNumber).setNumOfLegs(numPlaceholder);

          } else if (input.equals("8")) {
            inLoop = false;
          } else {
            System.out.println("Error! Please try again.");
          }

        }

      } else if (input.equals("Q")) {
        run = false;
      } else {
        System.out.println("Error! Please try again.");
      }
    }
    inputReader.close();
  }
}
