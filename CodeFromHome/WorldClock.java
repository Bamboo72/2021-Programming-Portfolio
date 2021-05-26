// Jacob Schwartz - 1/13/2021
/*

Implement a class Clock whose getHours and getMinutes methods return the current time at your location. 
(Call java.time.LocalTime.now().toString() and extract the time from that string.)
Also provide a getTime method that returns a string with the hours and minutes by calling the getHours and getMinutes methods.
Provide a subclass WorldClock whose constructor accepts a time offset. 
For example, if you live in California, a new WorldClock(3) should show the time in New York, three time zones ahead.
Which methods did you override? (You should not override getTime.)

*/

public class WorldClock extends Clock {
    
    int timeOffSet;

    public WorldClock(int timeZonesAhead){
        timeOffSet = timeZonesAhead;
    }

    public String getHours(){
        String hours;
        int numHours;
        
        numHours = Integer.parseInt(java.time.LocalTime.now().toString().substring(0, 2)) + timeOffSet;
        hours = "" + numHours;

        return hours;
    }

}
