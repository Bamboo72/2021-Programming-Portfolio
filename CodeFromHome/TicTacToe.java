/**
 * This is Tic Tac Toe. It's not too complicated of a concept.
 * 
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-12-1
 */

// Write a program that plays tic-tac-toe. The tic-tac-toe game is played on a 3
// × 3 grid as in the photo at right.

//    │   │   
// ───┼───┼───
//    │   │  
// ───┼───┼───
//    │   │   

// The game is played by two players, who take turns. The first player marks
// moves with a circle, the second with a cross. The player who has formed a
// horizontal, vertical, or diagonal sequence of three marks wins. Your program
// should draw the game board, ask the user for the coordinates of the next
// mark, change the players after every successful move, and pronounce the
// winner.

// ┌ ┬ ┐
// ├ ┼ ┤
// └ ┴ ┘
// |│ ─

import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static Scanner inputReader = new Scanner(System.in);
    static String input = "";
    static int winner;
    static int movesMade;
    static boolean pTurn;

    // This is kinda sloppy, but it should check for every win combo
    static public boolean winCheck(boolean turn) {
        char check;

        if (turn) {
            check = 'X';
            winner = 1;
        } else {
            check = 'O';
            winner = 2;
        }

        // Check the top left corner
        //  X │ X │ X
        // ───┼───┼───
        // X  │   │
        // ───┼───┼───
        // X  │   │

        if (board[0][0] == check) {
            if (board[1][0] == check) {
                if (board[2][0] == check) {

                    return true;
                }
            }
            if (board[0][1] == check) {
                if (board[0][2] == check) {

                    return true;
                }
            }

        }

        // Check the bottom right corner
        // │ │ X
        // ───┼───┼───
        // │ │ X
        // ───┼───┼───
        // X │ X │ X
        else if (board[2][2] == check) {
            if (board[2][1] == check) {
                if (board[2][0] == check) {

                    return true;
                }
            }
            if (board[1][2] == check) {
                if (board[0][2] == check) {

                    return true;
                }
            }
        }

        // Check the straight cross
        // │ X │
        // ───┼───┼───
        // X │ X │ X
        // ───┼───┼───
        // │ X │
        else if (board[1][1] == check) {
            if (board[0][1] == check) {
                if (board[2][1] == check) {

                    return true;
                }
            }
            if (board[1][0] == check) {
                if (board[1][2] == check) {

                    return true;
                }
            }
        }
        // Check the diagonal cross
        else if (board[1][1] == check) {
            if (board[0][0] == check) {
                if (board[2][2] == check) {

                    return true;
                }
            }
            if (board[0][2] == check) {
                if (board[2][0] == check) {

                    return true;
                }
            }
        }

        return false;
    }

    static public void printBoard() {
        System.out.println("─────────────────────────────────────────────────────────────────────────");
        System.out.println("   a   b   c ");
        System.out.printf("1  %1c │ %1c │ %1c \n", board[0][0], board[0][1], board[0][2]);
        System.out.println("  ───┼───┼───");
        System.out.printf("2  %c │ %c │ %c \n", board[1][0], board[1][1], board[1][2]);
        System.out.println("  ───┼───┼───");
        System.out.printf("3  %c │ %c │ %c \n", board[2][0], board[2][1], board[2][2]);
    }

    static public void doTurn(boolean turn) {
        int x, y;

        printBoard();
       
            if (turn) {
                System.out.println("Player 1's turn (X). Type the coordinates for your move. (Ex: a1, b2, c3)");
            } else {
                System.out.println("Player 2's turn (O). Type the coordinates for your move. (Ex: a1, b2, c3)");
            }

            input = inputReader.next();

            if (input.charAt(0) == 'a') {
                y = 0;
            } else if (input.charAt(0) == 'b') {
                y = 1;
            } else if (input.charAt(0) == 'c') {
                y = 2;
            } else {
                System.out.println("Input Error!");
                return;
            }

            if (input.charAt(1) == '1') {
                x = 0;
            } else if (input.charAt(1) == '2') {
                x = 1;
            } else if (input.charAt(1) == '3') {
                x = 2;
            } else {
                System.out.println("Input Error!");
                return;
            }

            if(board[x][y] == 'X' || board[x][y] == 'O'){
                System.out.println("That spot is already taken!");
                return;
            }

            if (turn) {
                board[x][y] = 'X';
                movesMade++;
                pTurn = false;
            } else {
                board[x][y] = 'O';
                movesMade++;
                pTurn = true;
            }

        
    }

    static public void main(String[] args) {

        pTurn = true; // True = P1, False = P2
        movesMade = 0;
        boolean on = true;
        boolean play = true;

        System.out.println("Welcome to Tic Tac Toe!");
        while (on) {

            while (play) {
                if (winCheck(true) || winCheck(false)) {
                    play = false;
                    printBoard();
                    System.out.println("Player " + winner + " won! Play again? (1) Yes (2) No");
                } else if(movesMade == 9){
                    play = false;
                    printBoard();
                    System.out.println("The board is full. It's a tie! Play again? (1) Yes (2) No");
                } else {
                    if (pTurn) {
                        doTurn(true);
                        winCheck(true);
                        
                    } else {
                        doTurn(false);
                        winCheck(false);
                        
                    }
                }

            }
                        
            input = inputReader.next();
            if (input.equals("1")) {
                board = new char[3][3];
                movesMade = 0;
                play = true;
            } else {
                on = false;
            }

        }
    }

}
