import java.util.Scanner;

import javax.xml.soap.Node;

import java.io.*;

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
public class ClosePair {

    Node[][] grid;

    public ClosePair() {
        int b = 0;
        grid = new Node[b][b];

    }

    public static void main(String[] args) {

        File f = new File("points");

        try {
            Scanner sk = new Scanner(f);

            StringSet x = new StringSet();

            // Read in the entire dictionary...
            while (sk.hasNext()) {
                String points = sk.next();
                x.insert(points);
            }
            System.out.println("All Points loaded...");

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

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);
        }

    }
}
