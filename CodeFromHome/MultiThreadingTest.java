/**
 * This project is the test for practice with multi threading in java.
 * 
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-11-22
 */

public class MultiThreadingTest {
    static int charSpeed = 50;
    static boolean speedOn = false;
    static boolean listen = true;

    // This is the default speak method (waits 50 ms between characters)
    public static void speak(String dialog) throws InterruptedException {
        speedOn = true;
        charSpeed = 50;

       

        for (int i = 0; i < dialog.length(); i++) {
            System.out.print(dialog.charAt(i));
            try {
                Thread.sleep(charSpeed);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();

        // End the listener thread
        charSpeed = 50;
        speedOn = false;
    }

    // This speak method takes in an int for the spacing between characters
    public static void speak(String dialog, int sec) throws InterruptedException {
        for (int i = 0; i < dialog.length(); i++) {
            System.out.print(dialog.charAt(i));
            try {
                Thread.sleep(sec);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {

          // Start the listener thread
     MultiThreading r1 = new MultiThreading();
     Thread t1 = new Thread(r1);
     t1.start();
        
        for(int i = 0; i < 10; i++){
            speak("Listen to what I'm saying to you now!");
        }
        
        listen = false;
    }
}
