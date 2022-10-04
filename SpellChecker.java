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
          // int not_found = 0;
          int count = word.length();
          // int i, j;
          StringBuffer str = new StringBuffer(word);
          temp = word;
          for (int i = 0; i < count; ++i) {
            int counter = 0;
            // System.out.println("Before WHILE loop WORD is " + word);
            while (!x.find(word) && (counter <= 25)) {
              // System.out.println("Before FOR loop WORD is " + word);
              // str.toString();
              str = new StringBuffer(word);
              for (char j = 'a'; j <= 'z'; ++j) {
                // System.out.println("i = " + i);
                // System.out.println("str in FOR loop = " + str);
                str.setCharAt(i, j);
                word = str.toString();
                // System.out.println("New WORD is " + word);
                counter++;
                // System.out.println("Counter = " + counter);
                if (x.find(word))
                  System.out.println(word + " is correct.");
                // String check = "" + word.charAt(i);// get the first letter
                // temp += j;

              }
              // System.out.println("Finished FOR loop");
              // }
            }
            word = temp;
            // System.out.println("After WHILE loop WORD is " + word);
          }
          // if (x.find(check))
          // temp = check;
          // System.out.println("The FIRST is " + temp);
          // not_found++;
          // Anything after the first letter
          // } else {
          // check = "" + word.charAt(i);// turn char to string
          // temp += check;// append next letter(s) to previous
          // if (x.find(temp)) {
          // Search for matching letters until not found
          // if matching, we update check to match
          // check = temp;
          // System.out.println("The SUBSEQUENT temp is " + temp);
          // not_found++;
          // When we no longer match, we have 'cooe', so we don't
          // want the last letter, so we throw it away (leaving
          // 'check' as it was without updating), and then start
          // incrementing up from 'a' to 'z', appending each
          // time and checking for validity until we find a valid
          // match, then we stop the loop and append the next letter
          // } else {
          // not_found++;
          /*
           * System.out.println("In the ELSE, check is " + check);
           * System.out.println("In the ELSE, temp is " + temp);
           * System.out.println("not_found = " + not_found);
           * if (not_found == count - 1) {
           * System.out.println("Expected this, temp is " + temp);
           * temp = temp.substring(0, temp.length() - 1);
           * break;
           * }
           * if (not_found == count) {
           * System.out.println("Expected this, temp is " + temp);
           * temp = temp.substring(0, temp.length() - 1);
           * System.out.println("Attempted edit of temp is " + temp);
           * break;
           * }
           * //}
           * //}
           * }
           * // We have the original word minus the last letter
           * // We will not append guess letters going from a - z
           * // Printing out 'Found a match for' when we get a Dictionary match
           * for (char j = 'a'; j <= 'z'; ++j) {
           * temp += j;
           * // System.out.println("Alphabet loop, temp is " + temp);
           * if (x.find(temp)) {
           * System.out.println("Found a match for " + temp);
           * temp = temp.substring(0, temp.length() - 1);
           * not_found--;
           * } else if (not_found <= word.length()) {
           * temp = temp.substring(0, temp.length() - 1);
           * not_found--;
           * // System.out.println("Match not found not_found <= count " + temp);
           * } else {
           * System.out.println("No Match Found for " + temp);
           * }
           * }
           * temp = null;
           */
        }
      }

    } catch (

    FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    }
  }
}
