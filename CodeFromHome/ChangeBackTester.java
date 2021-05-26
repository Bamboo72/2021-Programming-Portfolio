/**
 * This program tests the ChangeBack class
 * 
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-10-20
 */

import java.util.Scanner;

public class ChangeBackTester {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        ChangeBack change = new ChangeBack();

        System.out.print("What was the cost of the purchases? ");
        change.setPrice(in.nextDouble());

        System.out.print("How much was paid? ");
        change.addPay(in.nextDouble());

        change.changeCalc();
       
        System.out.println();
        System.out.println(change.changeBack());

        in.close();

    }
    
}
