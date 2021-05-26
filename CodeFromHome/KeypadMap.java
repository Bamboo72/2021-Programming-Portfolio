// Jacob Schwartz - 4/29/2021
// Chapter 15 project.

/*
•• P15.1 Read all words from a list of words and add them to a map whose keys are the phone keypad spellings of the word,
 and whose values are sets of words with the same code. 
 
 For example, 26337 is mapped to the set { "Andes", "coder", "codes", . . .}. 
 Then keep prompting the user for numbers and print out all words in the dictionary that can be spelled with that number. 
 
 In your solution, use a map that maps letters to digits.
*/

// 2:ABC, 3:DEF, 4:GHI, 5:JKL, 6:MNO, 7:PQRS, 8:TUV, 9:WXYZ

/*

    Steps for the project:
    1. Read all words from a list (I'm just going to use an ArrayList for now to keep things simple.)
    2. Find the word's numberSpelling using another map that maps letters to digits.
    3. Add the words to a map where KEYS: phone keypad spellings and VALUES: sets of words with the same code (I had to swap the Keys and Values for the project to work...)
    3. Prompt the user for numbers and return all the values for that specific key.

*/

import java.util.Scanner;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeypadMap {

    public static int letterToDigit(char letter) {
        int digit = 0;

        Map<Character, Integer> lettersToDigits = new HashMap<>(); // KEYS: letters, VALUES: digits
        lettersToDigits.put('a', 2);
        lettersToDigits.put('b', 2);
        lettersToDigits.put('c', 2);
        lettersToDigits.put('d', 3);
        lettersToDigits.put('e', 3);
        lettersToDigits.put('f', 3);
        lettersToDigits.put('g', 4);
        lettersToDigits.put('h', 4);
        lettersToDigits.put('i', 4);
        lettersToDigits.put('j', 5);
        lettersToDigits.put('k', 5);
        lettersToDigits.put('l', 5);
        lettersToDigits.put('m', 6);
        lettersToDigits.put('n', 6);
        lettersToDigits.put('o', 6);
        lettersToDigits.put('p', 7);
        lettersToDigits.put('q', 7);
        lettersToDigits.put('r', 7);
        lettersToDigits.put('s', 7);
        lettersToDigits.put('t', 8);
        lettersToDigits.put('u', 8);
        lettersToDigits.put('v', 8);
        lettersToDigits.put('w', 9);
        lettersToDigits.put('x', 9);
        lettersToDigits.put('y', 9);
        lettersToDigits.put('z', 9);

        Set<Character> theKeySet = lettersToDigits.keySet();
        for (Character character : theKeySet) {
            if (letter == character) {
                digit = lettersToDigits.get(character);
            }
            // Integer number = lettersToDigits.get(character);
            // System.out.println(character + " correlates to " + number); // Debug println
        }

        return digit;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        boolean run = true;

        Map<String, Integer> wordsToNumbers = new HashMap<>(); // KEYS: words, VALUES: numbers

        ArrayList<String> words = new ArrayList<>(); // A list of random 3 letter words I thought of:
        words.add("Ape");
        words.add("Bat");
        words.add("Car");
        words.add("Dad");
        words.add("Eat");
        words.add("Far");
        words.add("Guy");

        // I also added some word pairs that have the same number values:
        words.add("Wand");
        words.add("Wane");
        words.add("Prop");
        words.add("Pros");
        words.add("Sword");
        words.add("Swore");

        // You could technically hook up a list of the words in the dictionary and this would work.
        // I think the person who made this list must have done something like that: http://docshare01.docshare.tips/files/5544/55446192.pdf


        // Run through all the words in the ArrayList, convert them to numbers, and add
        // them to the HashMap with their number version.
        for (String word : words) {
            word = word.toLowerCase();
            String numberSpelling = "";
            for (int i = 0; i < word.length(); i++) {
                // System.out.println("Run number " + i + " for " + word); // Debug println
                numberSpelling = numberSpelling + letterToDigit(word.charAt(i));
            }
            // System.out.println(numberSpelling + ":" + word); // Debug println
            wordsToNumbers.put(word, Integer.valueOf(numberSpelling));
        }
        System.out.println(wordsToNumbers);

        while (run) {
            System.out.println("Type a number or Q to quit: ");
            input = in.next();

            if (input.equals("Q") || input.equals("q")) {
                run = false; // Quit
                in.close();
            }

            // Run through every word in the keySet and see if the number value matches the
            // user's input, then print the word if it matches.
            Set<String> theKeySet = wordsToNumbers.keySet();
            for (String word : theKeySet) {
                if (input.equals(Integer.toString(wordsToNumbers.get(word)))) {
                    System.out.println(word);
                }
            }

        }

    }
}
