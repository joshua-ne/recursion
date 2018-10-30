/******************************************************************************
 *  Prints instructions for a Beckett play with n actors.
 *
 *  % java Beckett 1
 *  enter 1
 *
 *  % java Beckett 2
 *  enter 1
 *  enter 2
 *  exit  1
 *
 *  % java Beckett 3
 *  enter 1
 *  enter 2
 *  exit  1
 *  enter 3
 *  enter 1
 *  exit  2
 *  exit  1
 *
 ******************************************************************************/



public class Beckett {

    static void moves(int n, boolean enter) {
        StdOut.println("calling n = " + n + "; enter = " + enter + "!");
        if (n == 0) return;
        moves(n-1, true);
        //if (enter) System.out.println("enter " + n);
        //else         System.out.println("exit  " + n);
        moves(n-1, false);
        return;
    }

    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        int n = 3;
        moves(n, true);
        //moves2(n, true);
    }
}