// Jacob Schwartz - 09/2/2020
// Tanker app created for Programming 2

import java.util.Scanner;

public class TankerApp{

public static void main(String[] args){
   double ozpd, gallpd, lifeYears, lifeDays, ozpl, gallpl, tankers;

  Scanner inputReader = new Scanner(System.in);

  System.out.println("Please input your estimated average amount of ounces of fluid intake you have per day: ");
  ozpd = inputReader.nextDouble();

  System.out.println("Please input your estimated life span in years: ");
  lifeYears = inputReader.nextDouble();

  lifeDays = lifeYears * 365.2425;
  ozpl = ozpd * lifeDays;
  gallpl = ozpl / 128;
  tankers = gallpl / 11000;


  System.out.println(" In your estimated lifetime you will consume " + tankers + " 11,000 gallon tankers of fluid.");

inputReader.close();
}

}
