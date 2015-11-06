import java.io.*;
import java.util.HashMap;

public class GreatWordsProblem {
  
  public static boolean MEMOIZATION = true;
  
  public static HashMap<String, Boolean> wordDictionary = new HashMap<> ();
  
  public static void main(String args[]) {
    String manyAs = "";
    
    for(int i = 0; i < 50; i++) {
      manyAs = manyAs.concat("a");
      wordDictionary.put(manyAs, true);
    }
    
    String str = manyAs.concat("b");
    System.out.println(wordSplitter(str));
  }
  
  public static HashMap<String, String> memoised = new HashMap<> ();
  
  public static String wordSplitter(String str) { 
    // Print the job of current recursive call, just to get an idea on what's happening.
    System.out.println("looking at: " + str);
    
    // Check recursive base cases.
    if (str.equals("")) return null;
    if (wordDictionary.get(str) != null) return str;
    
    // We will explore all prefixes and suffixes.
    // WARNING, str.substring behaves UNLIKE in choco,
    // i.e. str.substring(0, 1) is a string of length 1, not length 2
    for (int i = 1; i < str.length() - 1; i++) {
      String prefix = str.substring(0, i);
      String suffix = str.substring(i, str.length());
      
      // If prefix can form a solution, then let's try 
      // recursively all suffixes, until wipeout.
      if (wordDictionary.get(prefix) != null) {
        String recursionResult = null;
        String memoisedResult = null;
        
        // Let's check if we've explored this suffix before.
        memoisedResult = memoised.get(suffix);
        
        // If we haven't, then recurse.
        if (memoisedResult == null) {
          recursionResult = wordSplitter(suffix);
          
          // Memoize the result, so we don't thrash.
          if (recursionResult == null) {
            if (MEMOIZATION) {
 
              // We use a trick so that we don't confuse a negative result with no result
              memoised.put(suffix, "");
            }
          } else {
            if (MEMOIZATION) {
              memoised.put(suffix, recursionResult);
            }
          }
        } else if (memoisedResult.equals("")) {
          recursionResult = null;
        } else {
          recursionResult = memoisedResult;
        }
        if (recursionResult != null) {
          
          // if we found a solution, return it.
          return prefix + " " + recursionResult;
        }
      }
    }

    // inspected all prefixes and found no solution.
    return null;
  }
}
