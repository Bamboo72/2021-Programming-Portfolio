// Jacob Schwartz - 8/12/2020
// Based off the logic code breaking game: Mastermind

/*

    An error was found in MastermindALversion.java, and it might apply to this version too.
    - See MastermindALversion.java and/or the "Mastermind Error" notepad on the desktop for details.

*/

import java.util.*;

public class Mastermind {

    static int solutionLength = 4;
    static int solutionMax;

    static int guessesLeft = 10;
    static int guessesMade = 1;

    static int correct = 0;
    static int almCorrect = 0;

    // For setup
    static String input;

    static Scanner inputReader = new Scanner(System.in);

    // Maybe use ArrayLists instead of arrays to solve the length issues?
    static int[] solution = new int[solutionLength];
    static int[] guess = new int[solutionLength];
    static boolean[] shouldCheck = new boolean[solutionLength];

    static Random numGen = new Random();

    // Solution generation method
    public static void solutionGen() {
        for (int i = 0; i < solutionLength; i++) {
            solution[i] = numGen.nextInt(solutionMax);
            shouldCheck[i] = true;
            // System.out.println(solution[i]);
        }
        System.out.println("The solution is: " + Arrays.toString(solution));

    }

    // User guess method
    public static void guess() {
        System.out.println("Make a guess: ");
        input = inputReader.nextLine();

        for (int i = 0; i < input.length(); i++) {
            guess[i] = input.charAt(i) - '0';
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Your guess was " + Arrays.toString(guess));

    }

    // Guess checker method
    public static void guessCheck() {

        // Check for correct answers and mark them as not needing to be checked again
        for (int i = 0; i < solutionLength; i++) {
            if (solution[i] == guess[i]) {
                correct++;
                shouldCheck[i] = false;
            }
        }
        // Check for almost correct answers in the remaining numbers, and mark already
        // checked almost correct answers as not needing to be checked again
        for (int i = 0; i < solutionLength; i++) {
            for (int j = 0; j < solutionLength; j++) {
                if (guess[i] == solution[j] && shouldCheck[j] == true) {
                    almCorrect++;
                    shouldCheck[j] = false;
                }
            }
        }

        if (correct != solutionLength) {
            System.out.println(correct + " were correct!");
            System.out.println(almCorrect + " were the right number, but in the wrong spot");
            guessesLeft--;

            System.out.println(
                    " You've made " + guessesMade + " guesses, and you have " + guessesLeft + " guesses left.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            guessesMade++;
            correct = 0;
            almCorrect = 0;
            for (int i = 0; i < solutionLength; i++) {
                shouldCheck[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                "\n Welcome to Mastermind! Your goal is to guess the code before you run out of guesses. \n Choose your difficulty (1-9)");

        // Difficulty setter
        input = inputReader.nextLine();
        switch (input) {
            case "1":
                guessesLeft = 10;
                solutionMax = 1;
                break;
            case "2":
                guessesLeft = 10;
                solutionMax = 2;
                break;
            case "3":
                guessesLeft = 10;
                solutionMax = 3;
                break;
            case "4":
                guessesLeft = 10;
                solutionMax = 4;
                break;
            case "5":
                guessesLeft = 10;
                solutionMax = 5;
                break;
            case "6":
                guessesLeft = 10;
                solutionMax = 6;
                break;
            case "7":
                guessesLeft = 10;
                solutionMax = 7;
                break;
            case "8":
                guessesLeft = 10;
                solutionMax = 8;
                break;
            case "9":
                guessesLeft = 10;
                solutionMax = 9;
                break;

            default:
                System.out.println("User input not expected: Defaulted to difficulty 1");
        }

        System.out.println("You chose difficulty " + input + ". This means you get:");
        System.out.println(" " + guessesLeft + " guesses \n " + "The code is " + solutionLength
                + " numbers long \n and the numbers are 0-" + solutionMax);

        // Gameplay loop
        solutionGen();
        while (guessesLeft != 0 && correct != solutionLength) {
            guess();
            guessCheck();
        }

        // End game messages
        if (correct == solutionLength && guessesLeft > 0) {
            System.out.println("Congrats! You cracked the code! It was " + Arrays.toString(solution));
            System.out.println("You guessed it in " + guessesMade + " turns");
        }
        if (guessesLeft == 0) {
            System.out.println("Too bad! You ran out of turns. The correct code was " + Arrays.toString(solution));
        }

    }

}