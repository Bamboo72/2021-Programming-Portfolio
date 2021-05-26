/**
 * This project is practice with multi threading in java. I possibly want to
 * utilize multithreading in my CYO Adventure game.
 * 
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-11-22
 */

//import java.io.IOException;
import java.util.Scanner;

public class MultiThreading implements Runnable {

    // What the thread will do:
    public void run() {
        

        Scanner inputReader = new Scanner(System.in);
        String input = "";
        while (MultiThreadingTest.listen) {
           
            System.out.println("POINT 1 ");
            if (MultiThreadingTest.speedOn) {
                System.out.println("POINT 2 ");

               if (inputReader.hasNext()) {
                System.out.print("\010");
                   String tempInput = input + inputReader.next();
                    if (input != tempInput) {
                        System.out.println("SPEED");
                        MultiThreadingTest.charSpeed = 10;
                        input = tempInput;
                    }
               }
            }
        }
        inputReader.close();

/*
         * Scanner input = new Scanner();
         * 
         * input.next(); input.reset();
         * 
         * MultiThreadingTest.charSpeed = 10; input.close();
         */

        // This method seems to be the most effective, but outputs a new line each
        // time..
        /*
         * while(MultiThreadingTest.listen){ if(MultiThreadingTest.speedOn){ try {
         * System.in.read(); // This is reading the input from the keyboard
         * System.out.print("\010"); // This comes from
         * https://stackoverflow.com/questions/10819469/hide-input-on-command-line
         * MultiThreadingTest.charSpeed = 10; } catch (IOException e) {
         * e.printStackTrace(); }
         * 
         * } }
         */

        /*
         * // Code from //
         * https://stackoverflow.com/questions/18281543/java-using-scanner-enter-key-
         * pressed Scanner scanner = new Scanner(System.in); String readString =
         * scanner.nextLine(); while (readString != null) {
         * System.out.println(readString);
         * 
         * if (readString.isEmpty()) { // System.out.println("Read Enter Key."); }
         * 
         * if (scanner.hasNextLine()) { readString = scanner.nextLine(); } else {
         * readString = null; } } scanner.close();
         */

        // This seemed interesting to me:
        // InputStream.nullInputStream();

    }
}
