// Jacob Schwarz - 8/11/2020
// Based on the Guessing game I made in C++, found at https://github.com/Bamboo72/2019-Programming-Portfolio/blob/master/Term3and4/GuessingGame/GuessingGame.cpp

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

  static int number;
  static int guess;
  static String input;
  static boolean limGuesses = false;
  static int guessesLeft = 20;

  static Random numberGen = new Random();
  static Scanner inputReader = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println(
        "\n \n \n Welcome to Number Guesser! \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ \n Do you want a limited number of guesses? \n (1) Yes \n (2) No");
    input = inputReader.nextLine();
    if (input.equals("1")) {
      limGuesses = true;
    }

    System.out.println(" \n Select a difficulty: \n (1) Easy \n (2) Medium \n (3) Hard");
    input = inputReader.nextLine();

    if (input.equals("1")) {
      System.out.println("Easy mode: Guess between 0 - 50");
      number = numberGen.nextInt(50);

      if (limGuesses) {
        guessesLeft = 20;
      }

    } else if (input.equals("2")) {
      System.out.println("Medium mode: Guess between 0 - 100");
      number = numberGen.nextInt(100);

      if (limGuesses) {
        guessesLeft = 15;
      }

    } else if (input.equals("3")) {
      System.out.println("Hard mode: Guess between 0 - 1000");
      number = numberGen.nextInt(1000);

      if (limGuesses) {
        guessesLeft = 10;
      }

    } else {
      System.out.println("Input wasn't expected: defaulted to Easy mode...");
      System.out.println("Easy mode: Guess between 0 - 50");
      number = numberGen.nextInt(50);

      if (limGuesses) {
        guessesLeft = 20;
      }

    }

    // Gameplay Loop:

    while (guess != number && guessesLeft > 0) {
      guess = inputReader.nextInt();
      if (limGuesses) {
        // Limited Guesses On
        guessesLeft--;
        if (guess > number) {
          System.out.println("Your guess was too high! You have " + guessesLeft + " guesses left...");
        }
        if (guess < number) {
          System.out.println("Your guess was too low! You have " + guessesLeft + " guesses left...");
        }

      } else {
        // Limited Guesses Off
        if (guess > number) {
          System.out.println("Your guess was too high!");
        }
        if (guess < number) {
          System.out.println("Your guess was too low!");
        }
      }

    }

    // End Checks:

    if (guessesLeft == 0) {
      System.out.println("You ran out of guesses! The right number was " + number);
    }

    if (guess == number) {
      System.out.println("You got it! The number was " + number);
    }

  }

}
