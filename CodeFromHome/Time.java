// Jacob Schwartz - 8/28/2020
// This is a test of using time in Java to create a delay.

/*

Method 1 - Date and time: https://www.tutorialspoint.com/java/java_date_time.htm
Method 2 - Timer: https://docs.oracle.com/javase/7/docs/api/java/util/Timer.html
Method 3 - TimeUnit?: https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
Method 4 - Sleep: https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html

*/ 

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Time {

    // Date and time: Turns out, Thread.sleep is best for delay, even for date/time.
    public static void method1() {
        try{
        System.out.println(new Date( ) + "\n"); 
        Thread.sleep(1000); 
        System.out.println(new Date( ) + "\n"); 
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
    }


    // Timer: Doesn't work? Or at least I can't get it working. Thread.sleep is probably better for now..
    Timer timer;

    public static void method2(int seconds) {
        System.out.println("Message 1");
       // Timer timer = new Timer();
       // RemindTask rt = new RemindTask();
      //  timer.schedule(rt, seconds*1000);
    }
    public class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Message 2");
            timer.cancel(); //Terminate the timer thread
        }
    }

     class Reminder {
    //     Timer timer;
    //     public Reminder(int seconds) {
    //         timer = new Timer();
    //         timer.schedule(new RemindTask(), seconds*1000);
    //     }
    //     class RemindTask extends TimerTask {
    //         public void run() {
    //             System.out.println("Time's up!");
    //             timer.cancel(); //Terminate the timer thread
    //         }
    //     }
     }
    


    // TimeUnit: Seems to work alright. Uses a form of .sleep, but requires try catch, so it's a bit bigger..
    public static void method3() {  
       for(int i = 1; i<6; i++){
        try{
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Message" + i);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
        System.out.println("Final Message");
    }


    // Sleep: I guess this requires a throws statement/ a try/catch too. I still think this is the easiest solution.
    // Also, it doesn't require an import.
    public static void method4() throws InterruptedException {

        for(int i = 1; i<6; i++){
            Thread.sleep(1000);
            System.out.println("Message" + i);
        }
        System.out.println("Final Message");

    }



    // Solution:
    public static void methodSol(int ms)
{
    try
    {
        Thread.sleep(ms*1000);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
}

    public static void main(String[] args) throws InterruptedException {

        //method1();
        // method2(5);
        // method3();
        // method4();

        System.out.println("First message...");
        methodSol(3);
        System.out.println("Second message!");
        methodSol(1);

    }


}