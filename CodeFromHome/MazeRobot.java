// Jacob Schwartz - 9/9/2020
// Maze App, first project created for Programming 2

import java.util.Arrays;

public class MazeRobot {

  static boolean exitFound = false;
  static boolean isWall, isAir, isExit;

  // Starting direction, coords, and maze dimensions.
  static char direction = 'N';
  static int x = 1;
  static int y = 4;
  static int w = 9;
  static int h = 4;

  //               (0,0)  V
  static char[] row0 = { '#', '#', '#', '#', 'E', 'O', 'O', '#', 'O', 'O', };
  static char[] row1 = { '#', '#', '#', '#', '#', '#', 'O', 'O', '#', 'O', };
  static char[] row2 = { '#', 'O', 'O', 'O', 'O', 'O', '#', 'O', 'O', 'O', };
  static char[] row3 = { '#', 'O', '#', 'O', '#', 'O', '#', '#', '#', 'O', };
  static char[] row4 = { '#', 'O', '#', 'O', '#', 'O', 'O', 'O', 'O', 'O', };
  // Starting positon is here  ^

  // This method generates a random maze (COMING SOON?) For now it just prints the maze.
  static void mazeGen() {
      
    // char[] [] maze = {row0, row1, row2, row3, row4};

    // Print the maze
    System.out.println(Arrays.toString(row0));
    System.out.println(Arrays.toString(row1));
    System.out.println(Arrays.toString(row2));
    System.out.println(Arrays.toString(row3));
    System.out.println(Arrays.toString(row4));
  }

  // This method moves the robot forward
  static void moveForward() {
    System.out.println("-- Moved forward --");
    switch (direction) {
      case 'N':
        y--;
        break;
      case 'E':
        x++;
        break;
      case 'S':
        y++;
        break;
      case 'W':
        x--;
        break;
    }
  }

  // This method turns the robot to the right
  static void turnRight() {
    System.out.println("-- Turned right --");
    switch (direction) {
      case 'N':
        direction = 'E';
        break;
      case 'E':
        direction = 'S';
        break;
      case 'S':
        direction = 'W';
        break;
      case 'W':
        direction = 'N';
        break;
    }
  }

  // This method turns the robot to the left
  static void turnLeft() {
    System.out.println("-- Turned left --");
    switch (direction) {
      case 'N':
        direction = 'W';
        break;
      case 'E':
        direction = 'N';
        break;
      case 'S':
        direction = 'E';
        break;
      case 'W':
        direction = 'S';
        break;
    }
  }

  // Row checker method
  static char rowCheck(String which) {

    int d = 0;

    if (which.equals("down")) {
      d = 1;
    } else if (which.equals("up")) {
      d = -1;
    }

    if (y + d == 0) {
      return row0[x];
    } else if (y + d == 1) {
      return row1[x];
    } else if (y + d == 2) {
      return row2[x];
    } else if (y + d == 3) {
      return row3[x];
    } else {
      return row4[x];
    }
  }

  // Column checker method
  static char columnCheck(String which) {

    int d = 0;

    if (which.equals("right")) {
      d = 1;
    } else if (which.equals("left")) {
      d = -1;
    }

    if (y == 0) {
      return row0[x + d];
    } else if (y == 1) {
      return row1[x + d];
    } else if (y == 2) {
      return row2[x + d];
    } else if (y == 3) {
      return row3[x + d];
    } else {
      return row4[x + d];
    }
  }

  // This method senses what is in front of the robot
  static void sense() {

    isWall = false;
    isAir = false;
    isExit = false;

    System.out.println("Direction = " + direction);
    System.out.println("Sensing...");
    switch (direction) {

      case 'N':
        if (y > 0) {
          if (rowCheck("up") == 'O') {
            isAir = true;
          } else if (rowCheck("up") == 'E') {
            isExit = true;
          } else if (rowCheck("up") == '#'){
            isWall = true;
          } 
        } else {
          isWall = true;
        }
        break;

      case 'E':
        if (x < w) {
          if (columnCheck("right") == 'O') {
            isAir = true;
          } else if (columnCheck("right") == 'E') {
            isExit = true;
          } else if (columnCheck("right") == '#') {
            isWall = true;
          } 
        } else {
          isWall = true;
        }
        break;

      case 'S':
        if (y < h) {
          if (rowCheck("down") == 'O') {
            isAir = true;
          } else if (rowCheck("down") == 'E') {
            isExit = true;
          } else if (rowCheck("down") == '#') {
            isWall = true;
          } 
        } else {
          isWall = true;
        }
        break;

      case 'W':
        if (x > 0) {
          if (columnCheck("left") == 'O') {
            isAir = true;
          } else if (columnCheck("left") == 'E') {
            isExit = true;
          } else if (columnCheck("left") == '#') {
            isWall = true;
          } 
        } else {
          isWall = true;
        }
        break;

    }
    System.out.print("Done sensing:");
    if (isWall) {
      System.out.println(" Wall was found.");
    } else if (isAir) {
      System.out.println(" Air was found.");
    } else if (isExit) {
      System.out.println(" Exit was found.");
    } else {
      System.out.println(" Error");
    }
  }

  public static void main(String[] args) {

    // Generate the maze and put the robot in the maze
    mazeGen();
    System.out.println("Entering the maze...");

     while (!exitFound) {
 
    turnRight();
    sense();

    if (isWall) {
      turnLeft();
      while (!(isAir || isExit)) {
        sense();
        if (isWall) {
          turnLeft();
          isWall = false;
        }
        if (isAir) {
          moveForward();
        }
      }
      isAir = false;
    }

    if (isAir) {
      moveForward();
    }

    if (isExit) {
      exitFound = true;
      System.out.println("Exit has been found!");
      moveForward();
    }
  System.out.println("Location is " + x + ", " + y + ", and direction is " + direction);
     }

  }

}
