// Jacob Schwartz - 9/9/2020
// Maze App, first project created for Programming 2

public class Maze{

// This method generates a random maze
  static void mazeGen(){
  }

// This method moves the robot forward
  static void moveForward(){
  }

// This method turns the robot to the right
  static void turnRight(){
  }

// This method turns the robot to the left
  static void turnLeft(){
  }

// This method senses what is in front of the robot
  static void sense(){
  }

  public static void main(String[] args){
    boolean exitFound = false;
    boolean isWall, isAir, isExit;

//Generate the maze and put the robot in the maze
  System.out.println("Entering the maze...");

    while (!exitFound) {
      turnRight();
      sense();

      if(isWall){
        turnLeft();
        while(!isAir){
          sense();
          if(isWall){
            turnLeft();
          }
          if(isAir){
            moveForward();
          }
        }
      }

      if(isAir){
        moveForward();
      }

      if(isExit){
        moveForward();
        exitFound = true;
        System.out.println("Exit has been found!");
      }
    }

  }

}
