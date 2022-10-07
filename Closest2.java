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

    public static void main(String[] args) {
        Location[][] grid;
        int b = 10;// Used to create the grid size
        // int x_ndx;
        grid = new Location[b][b];
        File f = new File("points");
        try {
            Scanner sk = new Scanner(f);

            // Download the input file 'points' and create the Grid
            while (sk.hasNext()) {
                double x = sk.nextDouble();
                double y = sk.nextDouble();
                // System.out.println("x next = " + x + " y next = " + y);
                int x_ndx = (int) Math.floor(x * b);
                int y_ndx = (int) Math.floor(y * b);
                // System.out.println("xIndex = " + x_ndx + " yIndex = " + y_ndx);
                Location cell = grid[x_ndx][y_ndx];
                // System.out.println("cell = " + cell);
                // If the cell is empty, then we insert the location onto the head
                // adding to the existing linked-list, if not we create a new cell
                // Note: Think of each grid as a Ptr to the head of a linked-list
                if (cell == null) {
                    grid[x_ndx][y_ndx] = new Location(x, y);
                } else {
                    grid[x_ndx][y_ndx] = new Location(x, y, cell);
                }
            }
            System.out.println("All Points loaded...");
            sk.close();// Close first scanner

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);
        }
        // sk = new Scanner(f);
        int count = 0;
        // This is where we'll compare and check points
        // to determine which pair are closest together.
        // Loops through the points looking at every point
        // -----------------------------------------------
        double temp = 0;
        double minDest = 0;
        // Y increments - for cell locations
        for (int x_ndx = 0; x_ndx < b; ++x_ndx) {// i value
            // X increments - for cell locations
            for (int y_ndx = 0; y_ndx < b; ++y_ndx) {// j value
                // Find current (i.e. first) point in the D formula: (x1, y1)
                for (Location first_pt = grid[x_ndx][y_ndx]; first_pt != null; first_pt = first_pt.next) {
                    // for (Location first_pt = new Location(x_ndx, y_ndx); first_pt != null;
                    // first_pt = first_pt.next) {
                    // In here, we must figure out how to offset the
                    // destination from the starting point
                    for (int offset = -1; offset <= 1; ++offset) {
                        int xOffset = x_ndx + offset;
                        int yOffset = y_ndx + offset;
                        // System.out.println("X offset = " + xOffset + "Y offset = " + yOffset);
                        if (xOffset > 0 && xOffset < b && yOffset > 0 && yOffset < b) {
                            int x_Offset = xOffset;
                            int y_Offset = yOffset;
                            for (Location second_pt = grid[x_Offset][y_Offset]; second_pt != null; second_pt = second_pt.next) {
                                // Now, calculate the distance between the points
                                minDest = Math.sqrt((Math.pow((second_pt.x - first_pt.x), 2)
                                        + Math.pow((second_pt.y - first_pt.y), 2)));
                                if (temp < minDest) {
                                    temp = minDest;
                                } else {
                                    minDest = temp;
                                }
                            }

                        }
                    }
                    System.out.println("The minimum distance is " + minDest);
                    // if (xOffset )
                    // Next, we find the destination (i.e. second) point in thd D formula: (x2, y2)

                    // while (sk.hasNext()) {
                    // double x = sk.nextDouble();
                    // double y = sk.nextDouble();
                    // x_ndx = (int) Math.floor(x * b);
                    // y_ndx = (int) Math.floor(y * b);
                    // System.out.println("xIndex = " + x_ndx + " yIndex = " + y_ndx);
                    // for (int i = 0; i < b; ++i) { y-value
                    // for (int j = 0; j < b; ++j) { x-value
                    // Location cell = grid[x_ndx + j][y_ndx + i];// Ptr to head of a cell's
                    // Loop through linked list and compare each point to the next until reach the
                    // end
                    // keeping the closest (min) value
                    // linked-list
                    // int cell_x_value = (int) Math.floor(cell.x);
                    // int cell_y_value = (int) Math.floor(cell.y);
                    // System.out.println("x_ndx = "+cell_y_value);
                    // Looking for points within the cell (not incrementing the cell yet)
                    // if (cell_x_value == x_ndx && cell_y_value == y_ndx) {
                    // System.out.println("Found a match to x = "+x_ndx+" and y = "+y_ndx);

                    // Now, compare the points within the cell, and print out
                    // the two closest pairs.
                    // }
                    // Location cell2 = grid[x_ndx + 1][y_ndx + 1];
                    // System.out.println("First cell = " + cell);
                    // System.out.println("Second cell = " + cell2);
                    // }

                }
            }
        }
    }
}
