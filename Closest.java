import java.util.Scanner;
import java.io.*;
import java.lang.Math;

/*--------------------------------------------------------------
 * Program by: Tim Tron
 * Program name: ClosePair
 * 
 * This is program computes the closes pair of points among one
 * million input points on the 2D plane using spatial Hasing.
 * 
 * INPUT: points.txt with an example: 0.53560570 0.57631996
 * OUTPUT: Closest two points
 * --------------------------------------------------------------
 */
public class Closest {

    // Node[][] grid;
    // int b = 100;// Used to create the grid size
    // grid=new Node[b][b];
    public class Node {
        public int point;
        public Node next;

        public Node(int p, Node n) {
            point = p;
            next = n;
        }
    }

    private int hash(int p) {
        int hash = 0;
        int x = 2;// initial test value
        for (int i = 0; i < x; ++i) {
            hash = (hash * i);
            // hash = (hash * x + k.charAt(i)) % size;
        }
        return hash;
    }

    public static void main(String[] args) {
        Location[][] grid;
        int b = 100;// Used to create the grid size
        grid = new Location[b][b];
        File f = new File("points");

        try {
            Scanner sk = new Scanner(f);
            StringSet pts = new StringSet();

            // Download the input file 'points' and create the Grid
            while (sk.hasNext()) {
                double x = sk.nextDouble();
                double y = sk.nextDouble();
                // System.out.println("x next = " + x + " y next = " + y);
                int xIndex = (int) Math.floor(x * b);
                int yIndex = (int) Math.floor(y * b);
                System.out.println("xIndex = " + xIndex + " yIndex = " + yIndex);
                Location square = grid[xIndex][yIndex];
                // System.out.println("square = " + square);
                // If the square is empty, then we insert the point into it
                // creating a Linked-List by hasing
                if (square == null) {
                    grid[xIndex][yIndex] = new Location(x, y);
                } else {
                    grid[xIndex][yIndex] = new Location(x, y, square);
                }
                // String points = sk.next();
                // pts.insert(points);
            }
            System.out.println("All Points loaded...");
            sk.close();// Close first scanner

            sk = new Scanner(System.in);

            // This is where we'll compare and check points
            // to determine which pair are closest together.
            /*
             * while (sk.hasNext()) {
             * String points = sk.next();
             * if (x.find(points)) {
             * System.out.println(points + " is correct.");
             * // x.print();
             * }
             * }
             * 
             */
            sk.close();// Close second scanner
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);
        }

    }
}
