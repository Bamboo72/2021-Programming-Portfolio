// Jacob Schwartz - 8/13/2020
// This is an attempt to fix the array issues in the Mastermind.java file

/*

    There was an error in calculating the correct number of 'Corrects' and 'Almost Corrects'
    - See the "Mastermind Error" notepad on the desktop.

*/

import java.util.*;

public class MastermindALversion {

    static int guessesLeft = 10;
    static int guessesMade = 1;

    static int correct = 0;
    static int almCorrect = 0;

    // For setup
    static String input;

    static Scanner inputReader = new Scanner(System.in);

    static ArrayList<Integer> solution = new ArrayList<Integer>();
    static ArrayList<Integer> guess = new ArrayList<Integer>();
    static ArrayList<Boolean> shouldCheck = new ArrayList<Boolean>();

    static int solutionLength = solution.size();
    static int solutionMax;

    static Random numGen = new Random();

    // Solution generation method
    public static void solutionGen() {
        for (int i = 0; i < solutionLength; i++) {
            solution.add(numGen.nextInt(solutionMax));
            shouldCheck.add(true);
        }

        // Print the correct solution for easier debugging:
        // System.out.println(solution);
    }

    // User guess method
    public static void guess() {
        System.out.println("Make a guess: ");
        input = inputReader.nextLine();

        for (int i = 0; i < input.length(); i++) {
            guess.add(i, input.charAt(i) - '0');
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Your guess was " + guess);

    }

    // Guess checker method
    public static void guessCheck() {

        // Check for correct answers and mark them as not needing to be checked again
        for (int i = 0; i < solutionLength; i++) {
            if (guess.get(i) == solution.get(i)) {
                correct++;
                shouldCheck.set(i, false);
            }
        }

        // Check for almost correct answers in the remaining numbers, and mark already
        // checked almost correct answers as not needing to be checked again
        for (int i = 0; i < solutionLength; i++) {
            for (int j = 0; j < solutionLength; j++) {
                if (guess.get(i) == solution.get(j) && shouldCheck.get(j) == true) {
                    almCorrect++;
                    shouldCheck.set(j, false);
                }
            }
        }

        if (correct != solutionLength) {
            System.out.println(correct + " were correct!");
            System.out.println(almCorrect + " were the right number, but in the wrong spot");
            guessesLeft--;

            System.out
                    .println("You've made " + guessesMade + " guesses, and you have " + guessesLeft + " guesses left.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            guessesMade++;
            correct = 0;
            almCorrect = 0;
            shouldCheck.clear();
            for (int i = 0; i < solutionLength; i++) {
                shouldCheck.add(true);
            }
        }
        guess.clear();

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
                solutionLength = 3;
                break;
            case "2":
                guessesLeft = 10;
                solutionMax = 2;
                solutionLength = 3;
                break;
            case "3":
                guessesLeft = 10;
                solutionMax = 3;
                solutionLength = 3;
                break;
            case "4":
                guessesLeft = 10;
                solutionMax = 4;
                solutionLength = 4;
                break;
            case "5":
                guessesLeft = 10;
                solutionMax = 5;
                solutionLength = 4;
                break;
            case "6":
                guessesLeft = 10;
                solutionMax = 6;
                solutionLength = 4;
                break;
            case "7":
                guessesLeft = 10;
                solutionMax = 7;
                solutionLength = 5;
                break;
            case "8":
                guessesLeft = 10;
                solutionMax = 8;
                solutionLength = 5;
                break;
            case "9":
                guessesLeft = 10;
                solutionMax = 9;
                solutionLength = 6;
                break;

            default:
                System.out.println("User input not expected: Defaulted to difficulty 1");
        }

        System.out.println("You chose difficulty " + input + ". This means you get:");
        System.out.println(guessesLeft + " guesses \n " + "The code is " + solutionLength
                + " numbers long \n and the numbers are 0-" + solutionMax);

        // Gameplay loop
        solutionGen();
        while (guessesLeft != 0 && correct != solutionLength) {
            guess();
            guessCheck();
        }

        // End game messages
        if (correct == solutionLength && guessesLeft > 0) {
            System.out.println("Congrats! You cracked the code! It was " + solution);
            System.out.println("You guessed it in " + guessesMade + " turns");
        }
        if (guessesLeft == 0) {
            System.out.println("Too bad! You ran out of turns. The correct code was " + solution);
        }

    }

}