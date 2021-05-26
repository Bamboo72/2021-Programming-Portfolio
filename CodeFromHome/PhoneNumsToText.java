// Jacob Schwartz - 3/12/2021
/*

  Phone numbers and PIN codes can be easier to remember when you find words that spell out the number on a standard phone pad.
  For example, instead of remembering the combination 5282, you can just think of JAVA.
  Write a recursive method that, given a number, yields all possible spellings (which may or may not be real words).

  2: A,B,C
  3: D,E,F
  4: G,H,I
  5: J,K,L
  6: M,N,O
  7: P,Q,R,S
  8: T,U,V
  9: W,X,Y,Z

  Start with the first number, translate it to the first letter for it's number and then feed the substring in again
*/

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumsToText {

    static ArrayList<String> combinations = new ArrayList<String>();
    static int turn = 1;

    public static ArrayList<String> phoneNumConvert(String number) {
        ArrayList<String> letters = new ArrayList<String>();
       
        if (number.length() == 1) { // If only one number is entered, or when the recursion reaches the last digit
            letters.add(convertToLetter(number.substring(0, 1)));
            combinations.add(convertToWord(letters));
            return combinations;
        } else {
            //phoneNumConvert(number.substring(1, number.length())); // I need to use this somehow?
            letters.add(convertToLetter(number.substring(0, 1)));
            turn++;
            combinations.add(convertToWord(letters));
            return combinations;
        }

    }

    public static String convertToWord(ArrayList<String> characters) { // converts the ArrayList of one character
                                                                       // strings into one string
        String word = "";
        for (String character : characters) {
            word = word + character;
        }
        return word;
    }

    public static String convertToLetter(String num) { // This method only returns a letter based on the number and turn
                                                       // it is given.
        String letter = "";
        switch (num) {

        case "1":
            letter = "1";
            break;

        case "2":
            if (turn == 1) {
                letter = "A";
                turn++;

            } else if (turn == 2) {
                letter = "B";
                turn++;

            } else {
                letter = "C";
                turn = 0;

            }
            break;

        case "3":
            if (turn == 1) {
                letter = "D";
                turn++;

            } else if (turn == 2) {
                letter = "E";
                turn++;

            } else {
                letter = "F";
                turn = 0;

            }
            break;

        default:
            letter = "!";
        }
        return letter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num;
        System.out.println("Enter a number to list all possible phone pad words: ");
        num = in.next();

        
        System.out.println(phoneNumConvert(num));

    }

} 