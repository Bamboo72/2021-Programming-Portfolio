// Jacob Schwartz - 3/11/2021

import java.util.Scanner;

public class Permutation {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String aWord = "";

        System.out.println("Type the word you want to permutate: ");
        aWord = in.next();

        PermutationIterator p = new PermutationIterator(aWord);
       // System.out.println(p.getPermutations());
        System.out.println(p.permutations);

        in.close();
    }

}
