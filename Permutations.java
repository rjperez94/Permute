import ecs100.*;
import java.util.*;

/** Prints out all permuations of a string
 *  The static method permute constructs all the permutations
 *  The main method gets the string, calls recPermute, and prints the result.
 */
public class Permutations {
    private static List <String> words = new ArrayList<String>();
    /** Return a List of all the permutations of a String. */
    public static List <String> recPermute(String pref, String string) {
        if (string.length() <= 1) words.add(pref + string);
        else {
            for (int i = 0; i < string.length(); i++) {
                String newString = string.substring(0, i)   + string.substring(i + 1);
                recPermute(pref + string.charAt(i), newString);
            }
        }
        return words;
    }

    // Main
    public static void main(String[] arguments){
        String string = "";
        while (! string.equals("#")) {
            string = UI.askString("Enter string to permute - # to exit: ");
            List<String> permutations = recPermute("" , string);
            for (String p : permutations)
                UI.println(p);
            UI.println("---------");
        }
        UI.quit();
    }    
}
