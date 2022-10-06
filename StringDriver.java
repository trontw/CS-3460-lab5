
/* -----------------------------------------
 * By Tim Tron
 * Program: StringDriver
 * Purpose: To test StringSet.java
 * -----------------------------------------
 */
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import java.io.*;

public class StringDriver {

    public static void main(String[] args) {
        File f = new File("dictionary");
        String temp = null;// variable to increment letters in word
        try {

            Scanner sk = new Scanner(f);
            StringSet x = new StringSet();
            int opt = 0;
            // Read in the entire dictionary...
            while (sk.hasNext()) {
                String word = sk.next();
                x.insert(word);
            }
            System.out.println("Dictionary loaded...");

            Scanner in = new Scanner(System.in);
            System.out.println("Please enter numer 1-5: ");
            opt = in.nextInt();
            in.nextLine();
            System.out.println("Enter a word to search for in the Dictionary.");
            String key = in.nextLine();

            switch (opt) {
                // Testing print of StringSet
                case 1:
                    x.print();
                    break;
                case 2:
                    x.insert(key);
                    break;
                case 3:
                    if (x.find(key))
                        System.out.println(key + " is correct.");
                    else
                        System.out.println(key + " not found.");
                    break;
                default:
                    System.out.println("Incorrect Input");
                    break;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);
        }
    }

}