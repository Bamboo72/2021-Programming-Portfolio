/**
 * This project requires a sequence of inputs to unlock the doors of a minivan.
 * The instructions explain the conditions well, so they are left below as a
 * comment.
 * 
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-11-3
 */

/*
 * A minivan has two sliding doors. Each door can be opened by either a
 * dashboard switch, its inside handle, or its outside handle. However, the
 * inside handles do not work if a child lock switch is activated. In order for
 * the sliding doors to open, the gear shift must be in park, and the master
 * unlock switch must be activated. (This book’s author is the long-suffering
 * owner of just such a vehicle.)
 * 
 * Your task is to simulate a portion of the control software for the vehicle.
 * The input is a sequence of values for the switches and the gear shift, in the
 * following order:
 * 
 * • Dashboard switches for left and right sliding door, child lock, and master
 * unlock (0 for off or 1 for activated)
 * 
 * • Inside and outside handles on the left and right sliding doors (0 or 1)
 * 
 * • The gear shift setting (one of P N D 1 2 3 R).
 * 
 * A typical input would be 0 0 0 1 0 1 0 0 P.
 * 
 * Print “left door opens” and/or “right door opens” as appropriate. If neither
 * door opens, print “both doors stay closed”.
 */

import java.util.Scanner;

public class MiniVanDoors {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean DSL, DSR, CL, MU, IHL, IHR, OHL, OHR;
        char GS;

        System.out.println(
                "(Dashboard Switch L, Dashboard Switch R, Child Lock, Master Unlock, Inside Handle L, Inside Handle R, Outside Handle L, Outside Handle R, Gear Shift)");
        System.out.println("0 = off, 1 = on. Gear Shift can be P, N, 1, 2, 3, D, or R");

        System.out.println("\n Examples:\n0 0 0 1 1 0 0 0 P to open the left door");
        System.out.println("1 0 1 1 0 1 0 0 P to open the left door even though the right door is trying to be opened");
        System.out.println("1 1 0 1 1 1 1 1 D to not open any doors because the car is in Drive, even though all the switches are trying to open the doors\n");

        System.out.println("Enter the unlocking sequence:");

        // Dashboard Switch Left
        if (input.nextInt() == 0) {
            DSL = false;
        } else {
            DSL = true;
        }

        // Dashboard Switch Right
        if (input.nextInt() == 0) {
            DSR = false;
        } else {
            DSR = true;
        }

        // Child Lock
        if (input.nextInt() == 0) {
            CL = false;
        } else {
            CL = true;
        }

        // Master Unlock
        if (input.nextInt() == 0) {
            MU = false;
        } else {
            MU = true;
        }

        // Inside Handle Left
        if (input.nextInt() == 0) {
            IHL = false;
        } else {
            IHL = true;
        }

        // Inside Handle Right
        if (input.nextInt() == 0) {
            IHR = false;
        } else {
            IHR = true;
        }

        // Outside Handle Left
        if (input.nextInt() == 0) {
            OHL = false;
        } else {
            OHL = true;
        }

        // Outside Handle Right
        if (input.nextInt() == 0) {
            OHR = false;
        } else {
            OHR = true;
        }

        // Gear Shift
        String in = input.next();
        if (in.equals("P")) {
            GS = 'P';
        } else if (in.equals("N")) {
            GS = 'N';
        } else if (in.equals("1")) {
            GS = '1';
        } else if (in.equals("2")) {
            GS = '2';
        } else if (in.equals("3")) {
            GS = '3';
        } else if (in.equals("D")) {
            GS = 'D';
        } else if (in.equals("R")) {
            GS = 'R';
        } else {
            System.out.println("Error on the Gear Shift! Defaulted to Neutral.");
            GS = 'N';
        }

        // Old Print Line Statements:
        // System.out.println("Dashboard Switch Left: " + DSL );
        // System.out.println("Dashboard Switch Right: " + DSR);
        // System.out.println("Child Lock: " + CL);
        // System.out.println("Master Unlock: " + MU);
        // System.out.println("Inside Handle Left: " + IHL);
        // System.out.println("Inside Handle Right: " + IHR);
        // System.out.println("Outside Handle Left: " + OHL);
        // System.out.println("Outside Handle Right: " + OHR);
        // System.out.println("Gear Shift: " + GS);

        if (MU == true && GS == 'P') {
            if (CL == true) {
                if (DSL == true) {
                    System.out.println("Left door opened by Left Dashboard Switch.");
                }
                if (DSR == true) {
                    System.out.println("Right door opened by Right Dashboard Switch.");
                }
                if (OHL == true) {
                    System.out.println("Left door opened by Left Outside Handle.");
                }
                if (OHR == true) {
                    System.out.println("Right door opened Right Outside Handle.");
                }

            } else {
                if (DSL == true) {
                    System.out.println("Left door opened by Left Dashboard Switch.");
                }
                if (DSR == true) {
                    System.out.println("Right door opened by Right Dashboard Switch.");
                }
                if (IHL == true) {
                    System.out.println("Left door opened by Left Inside Handle.");
                }
                if (IHR == true) {
                    System.out.println("Right door opened by Right Inside Handle.");
                }
                if (OHL == true) {
                    System.out.println("Left door opened by Left Outside Handle.");
                }
                if (OHR == true) {
                    System.out.println("Right door opened Right Outside Handle.");
                }
            }
        } else {
            System.out.println("Both doors stayed closed.");
        }

        input.close();
    }

}
