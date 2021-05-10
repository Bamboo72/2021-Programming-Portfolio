// Jacob Schwartz - 3/11/2021

import java.util.Scanner;

public class Permutation{

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String word = "";

    System.out.println("Enter a word to permute: ");
    word = in.next();

    PermutationIterator p = new PermutationIterator(word);
    while(p.hasMorePermutations()){
      System.out.println(p.nextPermutation());
    }


  }

}
