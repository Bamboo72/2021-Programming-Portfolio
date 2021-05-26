// Jacob Schwartz 9/10/2020
// A maze running robot that navigates a maze made in an array.

import java.util.Arrays;

public class ArrayMaze {
    
    public static void main(String[] args){
         
        // Create the arrays:
    char[] row1 = {'#','#','#','#','#','#','#','E','#','#',};
    char[] row2 = {'#','#','#','#','#','#','#','O','#','#',};
    char[] row3 = {'#','O','O','O','O','O','O','O','#','#',};
    char[] row4 = {'#','O','#','#','#','#','#','#','#','#',};
    char[] row5 = {'#','^','#','#','#','#','#','#','#','#',};
        
        System.out.println(Arrays.toString(row1));
        System.out.println(Arrays.toString(row2));
        System.out.println(Arrays.toString(row3));
        System.out.println(Arrays.toString(row4));
        System.out.println(Arrays.toString(row5));
    }

}
