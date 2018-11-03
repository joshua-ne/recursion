/******************************************************************************
 *  Compilation:  javac AnimatedHtree.java
 *  Execution:    java AnimatedHtree n
 *  Dependencies: StdDraw.java
 *
 *  Plot an order n Htree.
 *
 *  % java AnimatedHtree 5
 *
 ******************************************************************************/


public class AnimatedHtree {

    // plot an order n H-tree, centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;

        // compute the coordinates of the 4 tips of the H
        double x0 = x - size/2, x1 = x + size/2;
        double y0 = y - size/2, y1 = y + size/2;

        // draw the H, centered on (x, y) of the given side length
        StdDraw.line(x0,  y, x1,  y);
        StdDraw.line(x0, y0, x0, y1);
        StdDraw.line(x1, y0, x1, y1);
        StdDraw.show();
        StdDraw.pause(0);


        draw(n-1, x0, y0, size/2);   // lower left
        draw(n-1, x0, y1, size/2);   // upper left
        draw(n-1, x1, y0, size/2);   // lower right
        draw(n-1, x1, y1, size/2);   // upper right
    }

    // read in an integer command-line argument n and plot an order n H-tree
    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        int n = 10;
        StdDraw.setPenRadius(0.0005);
        StdDraw.enableDoubleBuffering();
        draw(n, 0.5, 0.5, 0.5);
    }
}
