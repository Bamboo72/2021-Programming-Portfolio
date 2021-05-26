/**
 * This project requires a sequence of inputs to unlock the doors of a minivan.
 * The instructions explain the conditions well, so they are left below as a
 * comment.
 * 
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-11-13
 */

/* Instructions from the textbook:
 * The game of Nim. This is a well-known game with a number of variants. The
 * following variant has an interesting winning strategy. Two players
 * alternately take marbles from a pile. In each move, a player chooses how many
 * marbles to take. The player must take at least one but at most half of the
 * marbles. Then the other player takes a turn. The player who takes the last
 * marble loses.
 * 
 * Write a program in which the computer plays against a human opponent.
 * 
 * Generate a random integer between 10 and 100 to denote the initial size of
 * the pile. 
 * 
 * Generate a random integer between 0 and 1 to decide whether the
 * computer or the human takes the first turn. 
 * 
 * Generate a random integer between
 * 0 and 1 to decide whether the computer plays smart or stupid.
 * 
 *  In stupid mode
 * the computer simply takes a random legal value (between 1 and n/2) from the
 * pile whenever it has a turn. 
 * 
 *  In smart mode the computer takes off enough
 * marbles to make the size of the pile a power of two minus 1—that is, 3, 7,
 * 15, 31, or 63. That is always a legal move, except when the size of the pile
 * is currently one less than a power of two. In that case, the computer makes a
 * random legal move.
 * 
 * You will note that the computer cannot be beaten in smart mode when it has
 * the first move, unless the pile size happens to be 15, 31, or 63. Of course,
 * a human player who has the first turn and knows the winning strategy can win
 * against the computer.
 */

import java.util.Scanner;
import java.util.Random;

public class TheGameOfNim {

    static Scanner input = new Scanner(System.in);
    static int in = 0;
    static Random numGen = new Random();

    static boolean turn, run = true;
    static String id = "";
    static int pile;

    /**
     * This method sets up the game by randomly selecting the pile size and who goes first.
     * @param mode This is the game mode the player selects
     */
    static void start(int mode) {
        pile = 10 + numGen.nextInt(100);
        if (numGen.nextDouble() < 0.5) {
            turn = true;
            if (mode == 2) {
                id = "Player 1";
            } else {
                id = "the player";
            }

        } else {
            turn = false;
            if (mode == 2) {
                id = "Player 2";
            } else {
                id = "the computer";
            }

        }
        // The player can only win if they go first against a hard CPU, so I'm giving them that chance
        if (mode == 4) {
            turn = true;
            id = "the player";
        }
        System.out.println("The marble pile size is " + pile + " and " + id + " will go first:");
    }

    /**
     * This method is the player's turn, and asks how much they want to take and confirms it
     * @param playerNum This is player 1, 2, or 'the player'. It's just to fill in the right name to address the player.
     */
    static void playerTurn(String playerNum) {
        int take = 1;
        boolean done = false;

        System.out.println(pile + " marbles left. " + playerNum + "'s turn:");
        while (!done) {
            System.out.println("How much would you like to take? (Between 1 and " + pile / 2 + ")");
            in = input.nextInt();
            if (in >= 1 && in <= pile / 2 || pile == 1 && in == 1) {
                take = in;
                System.out.println("Are you sure you want to take " + take + "? (y/n)");
                if (input.next().equals("y")) {
                    pile -= take;
                    done = true;
                }
            } else {
                System.out.println("That input wasn't within the range 1 to " + pile / 2 + ". Please try again.");
            }
        }

        return;
    }

    /**
     * This method is the logic behind the computer player's turn.
     * @param type This is the type of computer player. 1 for easy, 2 for hard
     */
    static void computerTurn(int type) {
        int take = 1;
        System.out.println(pile + " marbles left. It's the computer's turn:");
        // Easy (type == 1)
        if (type == 1) {
            take = numGen.nextInt(1 + pile / 2);
            // Hard (type == 2)
        } else {
            for (int i = 2; i < 7; i++) {
                if (pile == Math.pow(2, i) - 1) {
                    take = numGen.nextInt(1 + pile / 2);
                } else {
                    if (Math.pow(2, i) < pile) {
                        take = pile - ((int) Math.pow(2, i) - 1);
                    }

                }

            }
        }
        pile -= take;
        System.out.println("The computer took " + take + " marbles.");
        return;
    }

    /**
     * This method finishes the game by printing who wins as well as either directing back to the menu or quitting.
     * @param mode This is the game mode the player selects
     */
    static void end(int mode) {
        if (turn == true) {
            if (mode == 2) {
                System.out.println("Player 1 wins!");
            } else {
                System.out.println("The player wins!");
            }

        } else {
            if (mode == 2) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("The computer wins!");
            }
        }
        System.out.println("(1) Menu\n(2) Quit");
        in = input.nextInt();
        if (in == 1) {
            in = 0;
        } else if (in == 2) {
            run = false;
        } else {
            System.out.println("Unrecognized input, please try again.");
        }
    }

    public static void main(String[] args) {

        System.out.println("+=============================+");
        System.out.println("| Welcome to The Game of Nim! |");
        System.out.println("+=============================+");
        while (run) {

            System.out.println(
                    "(1) Rules\n(2) Player vs. Player\n(3) Player vs. Easy Computer\n(4) Player vs. Hard Computer\n(5) Quit");
            in = input.nextInt();

            if (in == 1) {

                System.out.println(
                        "\tThe game of Nim: Two players alternately take marbles from a pile.\n\tIn each move, a player chooses how many marbles to take. The player must take at least one but at most half of the marbles.\n\tThen the other player takes a turn. The player who takes the last marble loses!\n");
            } else if (in == 2) {
                start(2);
                while (pile > 0) {
                    if (turn == true) {
                        playerTurn("Player 1");
                        turn = false;
                    } else {
                        playerTurn("Player 2");
                        turn = true;
                    }
                }
                end(2);

            } else if (in == 3) {
                start(3);
                while (pile > 0) {
                    if (turn == true) {
                        playerTurn("It's the player");
                        turn = false;
                    } else {
                        computerTurn(1);
                        turn = true;
                    }
                }
                end(3);

            } else if (in == 4) {
                start(4);
                while (pile > 0) {
                    if (turn == true) {
                        playerTurn("It's the player");
                        turn = false;
                    } else {
                        computerTurn(2);
                        turn = true;
                    }
                }
                end(4);

            } else if (in == 5) {
                run = false;
            } else {
                System.out.println("Unrecognized input, please try again.");
            }
        }
        System.out.println("Thanks for playing!");
    }

}