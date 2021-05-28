// Jacob Schwartz - 3/11/2021
// This code didn't work because I couldn't figure it out. Here's what it should have looked like:
/*
My original attempt:

 public PermutationIterator(String aWord) { 

        if(this.nextPermutation().equals("")){ // nextPermutation returns either "" if the word length is 0 or c + nextPermut if word length is > 0
        // Note that nextPermutation uses hasNextPermutation to check for more permutations, which is why I don't use it here.
            PermutationIterator p = new PermutationIterator(aWord); // Make another PermutationIterator object for the smaller permutations.
            permutations.add(p.nextPermutation()); // The next permutation is calculated and added to the ArrayList.
        }
    }

*/

import java.util.ArrayList;

/**
 * This class generates permutations of a word.
 */
public class PermutationIterator {
    private String word;
    private int current;
    private PermutationIterator tailIterator;
    private String tail;

    ArrayList<String> permutations = new ArrayList<String>(); // This array list holds all the permutations

    /**
     * Permutation iterator for given word.
     * 
     * @param aWord the word to permute
     */
    public PermutationIterator(String aWord) {
        word = aWord;
        current = 0;
        if (word.length() > 0) {
            tailIterator = new PermutationIterator(word.substring(current + 1));
        }

    }

    public ArrayList<String> getPermutations() {
        ArrayList<String> permutations = this.permutations;
        return permutations;
    }

    /**
     * Generate next permutation.
     * 
     * @return next permutation
     */
    public String nextPermutation() {
        if (word.length() == 0) {
            current++;
            return "";
        }

        char c = word.charAt(current);
        String nextPermut = tailIterator.nextPermutation();

        if (!tailIterator.hasMorePermutations()) {
            current++;
            if (current >= word.length()) {
                tailIterator = null;
            } else {
                if (current + 1 >= word.length()) {
                    tail = word.substring(0, current);
                } else {
                    tail = word.substring(0, current) + word.substring(current + 1, word.length());
                }
                tailIterator = new PermutationIterator(tail);
            }
        }
        return c + nextPermut;
    }

    /**
     * Determine if there are more permutations.
     * 
     * @return true if more permutations
     */
    public boolean hasMorePermutations() {
        return current < word.length() || tailIterator != null && tailIterator.hasMorePermutations();
    }
}