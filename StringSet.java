/**
 * This is a string set data structure, that is implemented as a Hash Table.
 * This data structure supports operations insert, find and print - that insert
 * a new
 * String, finds a String key and prints the contents of the data structure
 * resp.
 */
public class StringSet {

  StringNode[] table; // Hash table - collisions resolved through chaining.
  int numelements; // Number of elements actually stored in the structure.
  int size; // Allocated memory (size of the hash table).

  /**
   * Constructur: initilaizes numelements, size and initial table size.
   */
  public StringSet() {
    numelements = 0;
    size = 100;
    table = new StringNode[size];
  }

  /*
   * inserts a new key into the set. Inserts it at the head of the linked list
   * given by its hash value.
   */
  public void insert(String key) {
    if (numelements == size) {
      // TODO: need to expand the hash table and rehash its contents.
      int k = hash(key);
      int new_size = 2 * size;// Double the table size
      for (int i = 0; i < new_size; ++i) {
        for (StringNode cur = table[k]; cur != null; cur = cur.getNext()) {
          // Loop through table until the node before null so we can expand
          // the hash table withour overwriting existing data
          if (cur.getNext() == null) {
            table[k] = new StringNode(key, table[k]);
          }
        }
      }
    }
    // TODO: Code for actual insert.
    // hash the key and put it at the head of a linked-list
    int k = hash(key);
    table[k] = new StringNode(key, table[k]);
    numelements++;
    // System.out.println("Inserted "+numelements+" elements into the table.");
  }

  /*
   * finds if a String key is present in the data structure.
   * Returns true if found, else false.
   */
  public boolean find(String key) {
    // First, hash the key to get the value we are looking for in the table
    int i = hash(key);
    for (StringNode cur = table[i]; cur != null; cur = cur.getNext()) {
      // System.out.println("I'm looking for "+key+" which is hash # "+i);
      // System.out.println("But cur is = "+cur);
      // String dictionary_word = cur.getKey();
      // System.out.println("dictionary word is "+dictionary_word);
      // if (dictionary_word == key) {
      if (cur.getKey().equals(key)) {
        // System.out.println("Found your word");
        return true;
      }
    }
    return false;
  }

  /*
   * Prints the contents of the hash table.
   */
  public void print() {
    // System.out.println("Inside print");
    for (int i = 0; i < size; ++i) {
      for (StringNode cur = table[i]; cur != null; cur = cur.getNext())
        System.out.println("The key is =  " + cur.getKey());
    }
  }

  /*
   * The hash function that returns the index into the hash table for a string k.
   */
  private int hash(String k) {
    int hash = 0;
    int x = 31;// initial Prime number to test with
    for (int i = 0; (int) i < k.length(); ++i) {
      hash = (hash * x + k.charAt(i)) % size;
    }
    // TODO: Compute a polynomial hash function for the String k.
    // Make sure that the hash value h returned is a proper index
    // in the hash table, ie. in the range [0...capacity-1].
    return hash;
  }

}
