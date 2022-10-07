import java.util.Scanner;
import java.io.*;

/*
 * This class implements a spell checker application. 
 * This class requires a proper implementation to the StirngSet class.
 */
public class SpellChecker {

  public String suggestions(String word) {

    return word;
  }

  public static void main(String[] args) {

    File f = new File("dictionary");
    String temp = null;// variable to increment letters in word
    String check = null;// variable to increment letters in word
    try {
      Scanner sk = new Scanner(f);

      StringSet x = new StringSet();

      // Read in the entire dictionary...
      while (sk.hasNext()) {
        String word = sk.next();
        x.insert(word);
      }
      System.out.println("Dictionary loaded...");

      sk = new Scanner(System.in);

      // Keep suggesting alternatives as long as the user makes an input.
      while (sk.hasNext()) {
        String word = sk.next();
        if (x.find(word)) {
          System.out.println(word + " is correct.");
          // x.print();
        } else {
          System.out.println("Suggesting alternatives ...");
          /*----------------------------------------------------------
           * Look into the StringSet for all possible alternatives
           * of the input word mis-spelled by one character.
           * 
           * RETHING - take the given word, then loop through each 
           *           character, checking against the Dictionary
           *           to see if any character in that position respells
           *           a new word.
           * INPUT - 'word'
           * ACTION - 'coee' would become '[a-z]oee', then 'c[a-z]ee'
           *----------------------------------------------------------
          */
          int count = word.length();
          // Initialize str to word
          StringBuffer str = new StringBuffer(word);
          temp = word;
          // Loop through all the letters of the input
          for (int i = 0; i < count; ++i) {
            int counter = 0;
            // While word not found and counter less than 26 alphabet letters
            while (!x.find(word) && (counter <= 25)) {
              // Set str to original input of word to restart loop
              str = new StringBuffer(word);
              for (char j = 'a'; j <= 'z'; ++j) {
                str.setCharAt(i, j);
                word = str.toString();
                // Increment counter
                counter++;
                // Search for correct version of modified word
                if (x.find(word))
                  System.out.println(word);
              }
            }
            word = temp;
          }
        }
      }

    } catch (

    FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    }
  }
}
