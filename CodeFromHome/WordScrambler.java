
/**
 * This project swaps the letters of a word provided by the user.
 * 
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-11-10
 */

import java.util.Scanner;
import java.util.Random;

public class WordScrambler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = "";
        Random numberGen = new Random();
        int i = 0, j = 0;

        System.out.println("Please type a word: ");
        word = input.next();
        String OGWord = word;

        for (int n = 0; n < word.length(); n++) {

            i = numberGen.nextInt(word.length());
            if (i == word.length() - 1) {
                while (i == word.length() - 1) {
                    i = numberGen.nextInt(word.length());
                }
            }

            j = numberGen.nextInt(word.length());
            if (j <= i) {
                while (j <= i) {
                    j = numberGen.nextInt(word.length());
                }
            }

            String first = word.substring(0, i);
            String middle = word.substring(i + 1, j);
            String last = word.substring(j + 1, word.length());

            word = first + word.charAt(j) + middle + word.charAt(i) + last;
            System.out.println(word);
        }
        System.out.println("You went from " + OGWord + " to " + word);

        input.close();
    }
}
