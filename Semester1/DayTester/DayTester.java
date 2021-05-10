// Jacob Schwartz - 9/15/2020
// DayTester for Programming 2
// This program calculates your age in days using the Day class

import java.util.Scanner;

public class DayTester{

static int year, month, day;

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Enter your birth year:");
    year = input.nextInt();
    System.out.println("Enter your birth month:");
    month = input.nextInt();
    System.out.println("Enter your birth day:");
    day = input.nextInt();

    Day birthday = new Day(year, month, day);
    Day today = new Day();

    System.out.println("Your birthday is " + birthday.toString() + " based on what you entered.");
    int daysAlive = today.daysFrom(birthday);
    System.out.println("You've been alive for " + daysAlive + " days.");
  }

}
