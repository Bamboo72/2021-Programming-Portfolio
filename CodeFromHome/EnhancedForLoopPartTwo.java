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

public class EnhancedForLoopPartTwo {

  public int sum(int[] array) {
    int sum = 0;
    for (int index : array) {
      sum += index;
    }
    return sum;
  }

  public int average(int[] array) {
    int sum = 0;
    int avg;
    for (int index : array) {
      sum += index;
    }
    avg = sum / array.length;
    return avg;
  }

  public int max(int[] array) {
    // Start at -99 because that's the least possible number
    int max = -99;
    for (int index : array) {
      // Find the maximum
      if (index > max) {
        max = index;
      }
    }
    return max;
  }

  public int min(int[] array) {
    // Start at -99 because that's the least possible number
    int min = 0;
    for (int index : array) {
      // Find the minimum
      if (index < min) {
        min = index;
      }
    }
    return min;
  }

  public void printWithSeparators(int[] array) {
    // Print the numbers
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      if (i != array.length - 1) {
        System.out.print("|");
      }
    }
    System.out.println("");
    return;
  }

  public boolean linearSearch(int[] array, int find) {
    boolean found = false;
    for (int index : array) {
      if (index == find) {
        found = true;
      }
    }
    return found;
  }

  // You have to set an array equal to this method
  public int[] remove(int[] array) {
    int currentSize = array.length;
    int[] placeholder = new int[currentSize - 1];

    // Copy the array onto a placeholder, but not the last index.
    for (int i = 0; i < array.length - 1; i++) {
      placeholder[i] = array[i];
    }

    return placeholder;
  }

  // You have to set an array equal to this method
  public int[] insert(int[] array, int num, int place) {
    int currentSize = array.length;
    int[] placeholder = new int[currentSize + 1];

    // Copy the array onto a placeholder until you reach the insert place
    for (int i = 0; i <= place; i++) {
      if (i == place) {
        placeholder[i] = num;
      } else {
        placeholder[i] = array[i];
      }
    }
    for (int i = place; i < array.length; i++) {
      placeholder[i + 1] = array[i];
    }
    return placeholder;
  }

  public void swap(int[] array, int one, int two) {

    int valueOne = array[one];
    int valueTwo = array[two];
    array[one] = valueTwo;
    array[two] = valueOne;

  }

  // You have to set an array equal to this method
  public int[] copy(int[] arrayOne, int[] arrayTwo) {
    arrayTwo = arrayOne;
    return arrayTwo;
  }

  public static void main(String[] args) {

    int currentSize = 10;
    Random numGen = new Random();
    int[] myArray = new int[currentSize];

    EnhancedForLoopPartTwo m = new EnhancedForLoopPartTwo();

    // Populating the array:
    for (int i = 0; i < myArray.length; i++) {
      // Assign random numbers
      myArray[i] = numGen.nextInt(199) - 99;
      System.out.print(myArray[i] + " ");
    }

    System.out.println("\n Sum:" + m.sum(myArray) + "\n Average:" + m.average(myArray) + "\n Maximum: " + m.max(myArray)
        + "\n Minimum: " + m.min(myArray));
    m.printWithSeparators(myArray);
    System.out.println("Is the number 17 is in this array? " + m.linearSearch(myArray, 17));
    myArray = m.remove(myArray);
    myArray = m.remove(myArray);
    myArray = m.remove(myArray);
    myArray = m.remove(myArray);

    m.swap(myArray, 0, 1);

    m.printWithSeparators(myArray);

    myArray = m.insert(myArray, 1, 3);
    myArray = m.insert(myArray, 2, 3);
    myArray = m.insert(myArray, 3, 3);

    int[] duplicate = new int[currentSize];
    duplicate = m.copy(myArray, duplicate);
    m.printWithSeparators(duplicate);

  }

}
