// Jacob Schwartz - 4/16/2021
// Chapter 14 Project

/*

     P14.7 Implement the radix sort algorithm described in Exercise •• R14.26 to sort arrays of numbers between 0 and 999.

     R14.26 The radix sort algorithm sorts an array of n integers with d digits, using ten auxiliary arrays. 
     First place each value v into the auxiliary array whose index corresponds to the last digit of v. 
     Then move all values back into the original array, preserving their order. Repeat the process, now using 
     the next-to-last (tens) digit, then the hundreds digit, and so on. What is the big-Oh time of this algorithm 
     in terms of n and d? When is this algorithm preferable to merge sort?
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RadixSort {

    static Random generator = new Random();
    static int length = 20;

    // Random array creation code borrowed from the textbook
    public static int[] randomIntArray(int length, int n) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.nextInt(n);
        }

        return a;
    }

    public static int[] radixSort(int[] a) {

        for (int placeValue = 10; placeValue < 10000; placeValue *= 10) {
            System.out.println("placeValue:" + placeValue + ". 1000 % placeValue:" + 1000 % placeValue);
            //System.out.println(1000 % placeValue + "'s' place");

            ArrayList<Integer> tempArrayList = new ArrayList<Integer>();

            // Initialize the ArrayLists
            List<Integer> array0 = new ArrayList<Integer>();
            List<Integer> array1 = new ArrayList<Integer>();
            List<Integer> array2 = new ArrayList<Integer>();
            List<Integer> array3 = new ArrayList<Integer>();
            List<Integer> array4 = new ArrayList<Integer>();
            List<Integer> array5 = new ArrayList<Integer>();
            List<Integer> array6 = new ArrayList<Integer>();
            List<Integer> array7 = new ArrayList<Integer>();
            List<Integer> array8 = new ArrayList<Integer>();
            List<Integer> array9 = new ArrayList<Integer>();

            // Add the arrays to a 2D ArrayList for easier management
            ArrayList<List<Integer>> auxArrays = new ArrayList<List<Integer>>();
            auxArrays.add(array0);
            auxArrays.add(array1);
            auxArrays.add(array2);
            auxArrays.add(array3);
            auxArrays.add(array4);
            auxArrays.add(array5);
            auxArrays.add(array6);
            auxArrays.add(array7);
            auxArrays.add(array8);
            auxArrays.add(array9);

            for (int i = 0; i < a.length; i++) {
                switch (a[i] % placeValue) {
                case 0:
                    array0.add(a[i]);
                    break;
                case 1:
                    array1.add(a[i]);
                    break;
                case 2:
                    array2.add(a[i]);
                    break;
                case 3:
                    array3.add(a[i]);
                    break;
                case 4:
                    array4.add(a[i]);
                    break;
                case 5:
                    array5.add(a[i]);
                    break;
                case 6:
                    array6.add(a[i]);
                    break;
                case 7:
                    array7.add(a[i]);
                    break;
                case 8:
                    array8.add(a[i]);
                    break;
                case 9:
                    array9.add(a[i]);
                    break;
                }
            }

            // Add all the sorted numbers from the 10 ArrayLists to a single ArrayList
            for (List<Integer> array : auxArrays) {
                for (int num : array) {
                    tempArrayList.add(num);
                }
                System.out.println(array);
            }
            
            System.out.println("tempArrayList: " + tempArrayList);

            //Transfer the sorted numbers back to array a
            for(int i = 0; i < a.length; i++){
                System.out.println("a[i]: " + a[i] + ". tempArrayList.get(i):" + tempArrayList.get(i));
                a[i] = tempArrayList.get(i);
            }

            //a = (Integer[]) tempArrayList;

            // List<Integer> al = new ArrayList<Integer>(); 
            // Integer[] arr = new Integer[al.size()]; 
            // arr = al.toArray(arr); 

        }

        return a;
    }

    public static void main(String[] args) {

        int[] theArray = new int[length];
        theArray = randomIntArray(10, 1000);

        System.out.println("Before: " +Arrays.toString(theArray));

        radixSort(theArray);

        System.out.println("After: " +Arrays.toString(theArray));

    }

}
