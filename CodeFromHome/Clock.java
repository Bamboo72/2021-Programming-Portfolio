// Jacob Schwartz - 1/13/2021
/*
NOTE: This is a very simple program, and does not account for the International Date Line

Implement a class Clock whose getHours and getMinutes methods return the current time at your location. 
(Call java.time.LocalTime.now().toString() and extract the time from that string.)
Also provide a getTime method that returns a string with the hours and minutes by calling the getHours and getMinutes methods.
Provide a subclass WorldClock whose constructor accepts a time offset. 
For example, if you live in California, a new WorldClock(3) should show the time in New York, three time zones ahead.
Which methods did you override? (You should not override getTime.)

*/

public class Clock {

    public String getHours(){
        String hours;
        hours = java.time.LocalTime.now().toString().substring(0, 2);
        return hours;
    }

    public String getMinutes(){
        String minutes;
        minutes = java.time.LocalTime.now().toString().substring(3, 5);
        return minutes;
    }

    public String getTime() {
        String time;
        time = getHours() + ":" + getMinutes();
        return time;
    }

    public static void main(String[] args) {
        Clock yourClock = new Clock();
        WorldClock twoAhead = new WorldClock(2);
        System.out.println("The current time at your location is: " + yourClock.getTime());
        System.out.println("The current time two time zones ahead is: " + twoAhead.getTime());
    }

}
