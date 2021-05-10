/**
 * This project is built on the last project for the enhanced for loop.
 *
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-11-20
 */

/*
Sum
Average
Minimum
Maximum
Print Element Separators
Linear Search for any value between -99 and 99 (can be hard coded)
Removing an element
Inserting an element
Swapping two elements
Copying the entire array
*/

import java.util.Random;

public class EnhancedForLoop {

  public int sum(int[] array){
    int sum = 0;
    for(int index: array){
      sum += index;
    }
    return sum;
  }

  public int average(int[] array){
    int sum = 0;
    int avg;
    for(int index: array){
      sum += index;
    }
    avg = sum/array.length;
    return avg;
  }

  public int max(int[] array){
    // Start at -99 because that's the least possible number
    int max = -99;
    for(int index: array){
      // Find the maximum
      if(index > max){
          max = index;
      }
    }
    return max;
  }

  public int min(int[] array){
    // Start at -99 because that's the least possible number
    int min = 0;
    for(int index: array){
      // Find the minimum
      if(index < min){
          min = index;
      }
    }
    return min;
  }

  public int printWithSeparators(int[] array){
    // Print the numbers
    for(int i = 0; i < array.length; i++){
      if(i >= 0){
        System.out.print(array[i] + "|");
      } else {
        System.out.print(array[i]);
      }
    }
    return 1;
  }

  public boolean linearSearch(int[] array, int find){
    boolean found = false;
    for(int index: array){
      if(index == find){
        found = true;
      }
    }
    return found;
  }

  public int remove(int[] array, int index){
    array[index] = array[currentSize - 1];
    currentSize--;
  }

  // public int sum(int[] array){
  //
  // }


    public static void main(String[] args){

        Random numGen = new Random();
        int[] myArray = new int[currentSize];
        int negativeCount = 0;
        int currentSize = 100;

        EnhancedForLoop m = new EnhancedForLoop();

        // Populating the array:
        for(int i = 0; i < myArray.length; i++){
            // Assign random numbers
            myArray[i] = numGen.nextInt(199) - 99;
            System.out.print(myArray[i] + " ");
        }

        System.out.println("\n Sum:" + m.sum(myArray) + "\n Average:" + m.average(myArray) + "\n Maximum: " + m.max(myArray) + "\n Minimum: " + m.min(myArray));
        System.out.println(m.printWithSeparators(myArray));
            System.out.println("Is the number 17 is in this array?:" + m.linearSearch(myArray, 17));

    }

}
