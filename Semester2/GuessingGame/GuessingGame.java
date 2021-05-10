// Jacob Schwartz - 2/10/2021
// A guessing game similar to the one from Programming 1,
// but this time we are using I/O and writing to a file

import java.util.Scanner;
import java.util.Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.time.Duration;
import java.time.Instant;
import java.util.GregorianCalendar;

class GuessingGame {

    static public String getHighScore(File scores) throws FileNotFoundException {
        Scanner in = new Scanner(scores);
        double highScore = 300000; // 300 seconds or 5 minutes as a base high score
        String highScoreName = "";
        while (in.hasNext()) {
            String name = in.next();
            in.next();
            double scoreData = Double.parseDouble(in.next())/1000;
            in.next();
            in.next();
            if (scoreData < highScore) {
                highScore = scoreData;
                highScoreName = name;
            }
        }
        in.close();
        return "High Score: " + highScore + " seconds by " + highScoreName;
    }


    static public String getDate() {
        GregorianCalendar todayDate = new GregorianCalendar();
        String today = "";
        today = todayDate.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (todayDate.get(GregorianCalendar.MONTH) + 1) + "/"
                + todayDate.get(GregorianCalendar.YEAR);
        return today;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputReader = new Scanner(System.in);
        Random random = new Random();
        String input;
        int randNum, attempts;
        boolean run = true;

        Instant t1, t2;
        double duration;

        File scores = new File("scores.txt");
        String highscore = getHighScore(scores);



        System.out.println("What is your name?");
        String name = inputReader.next();
        System.out.println("-= Welcome to Guessing Game =-");
        System.out.println("   " + highscore);
        while (run) {

            System.out.println("What would you like to do? (1) New Game (2) View Scores (3) Change Name (4) Quit");
            input = inputReader.next();
            boolean loop = true;

            // Game
            if (input.equals("1")) {
                boolean gameLoop = true;
                t1 = Instant.now();
                while (gameLoop) {
                    randNum = random.nextInt(1000);
                    attempts = 0;
                    boolean game = true;
                    while (game) {
                        //System.out.println(randNum);// DEBUG REMOVE THIS!!!
                        System.out.println("Guess a number between 1 and 1000");
                        int guess = inputReader.nextInt();
                        attempts++;
                        if (guess == randNum) {
                            t2 = Instant.now();
                            duration = Duration.between(t1, t2).toNanos()/1000000; // Go from Nano to Milli
                            System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                            game = false;

                            // Store the old score
                            String oldContents = "";
                            Scanner in = new Scanner(scores);
                            while (in.hasNext()) {
                                String nextString = in.next();
                                oldContents = String.format(oldContents + "%10s ", nextString);
                                if (nextString.equals(";")) {
                                    oldContents = oldContents + System.lineSeparator();
                                }
                            }
                            in.close();

                            // Record the score
                            PrintWriter out = new PrintWriter(scores);
                            // System.out.println(oldContents);
                            out.printf(oldContents + "%10s %10s %10s %10s ;", name, getDate(), duration, attempts);
                            out.close();

                        } else if (guess > randNum) {
                            System.out.println("Too high! You've made " + attempts + " attempts.");
                        } else if (guess < randNum) {
                            System.out.println("Too low! You've made " + attempts + " attempts.");
                        } else {
                            System.out.println("Input not recognized. Please try again.");
                        }
                    }
                    System.out.println("Play again? (1) Yes (2) No");
                    input = inputReader.next();
                    if (input.equals("1")) {
                        System.out.println("Playing again!");
                    } else if (input.equals("2")) {
                        gameLoop = false;
                    } else {
                        System.out.println("Input not recognized. Defaulted to No.");
                        gameLoop = false;
                    }
                }

            } else if (input.equals("2")) {
                System.out.println("      Name      Date    Duration   Attempts");
                System.out.println("--------------------------------------------");

                Scanner in = new Scanner(scores);
                while (in.hasNext()) {
                    String scoreData = in.next();
                    if (scoreData.equals(";")) {
                        System.out.println();
                    } else {
                        System.out.printf("%10s ", scoreData);
                    }

                }
                in.close();

            } else if (input.equals("3")) {
                System.out.println("What is your name?");
                name = inputReader.next();

            } else if (input.equals("4")) {
                System.out.println("-= Thanks for Playing! =-");
                run = false;
            } else {
                System.out.println("Input not recognized. Please try again.");
            }

        }

        inputReader.close();
    }

}
