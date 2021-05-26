/**
 * This project is practice with the enhanced for loop.
 * 
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-11-20
 */

/*
    Write enhanced for loops for the following tasks.

    a.Printing all elements of an array in a single row, separated by spaces.

    b.Computing the maximum of all elements in an array.

    c.Counting how many elements in an array are negative.
*/

import java.util.Random;

public class EnhancedForLoop {
    public static void main(String[] args){
        Random numGen = new Random();
        int[] array = new int[100];
        int negativeCount = 0;
        // Start at -99 because that's the least possible number
        int max = -99;
        
        // Everything is done in this enhanced for loop
        for(int index: array){
            // Assign random numbers
            index = numGen.nextInt(199) - 99;

            // Print the numbers
            System.out.print(index + " ");
            
            // Find the maximum
            if(index > max){
                max = index;
            }

            // Count the negatives
            if(index < 0){
                negativeCount++;
            }

        }
        System.out.println("\n Maximum: " + max + "\n Negatives: " + negativeCount);


    }

}
