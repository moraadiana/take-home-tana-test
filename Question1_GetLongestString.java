import java.util.*;

public class LongestValidString {

    // Check if string is valid, pass paramaters 
    public static boolean isValid(String s, Set<Character> validCharacterSet) {
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);

            // Check if character is in the valid set of characters
            if (!validCharacterSet.contains(currentCharacter)) {
                return false;
            }
            //check if current character is same as the previous character 
            if (i > 0 && currentCharacter == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // Main function to find the longest valid string
    public static String getLongestString(String characters, List<String> strings) {
        Set<Character> validSet = new HashSet<>();
        for (char c : characters.toCharArray()) {
            validSet.add(c);
        }

        String longest = "";
        for (String s : strings) {
            if (isValid(s, validSet) && s.length() > longest.length()) {
                longest = s;
            }
        }

        return longest;
    }

    // tests on main methods
    public static void main(String[] args) {
        String validCharacters = "ABCD";
        List<String> stringsTest = Arrays.asList(
            "AABCDA",        // Invalid: contains 'AA'
            "ABCDZADC",      // Invalid: contains 'Z'
            "ABCDBCA",       // Valid
            "ABCDABDCA"      // Valid and longest
        );

        String LongestString= getLongestString(validCharacters, stringsTest);
        System.out.println("Longest valid string: " + LongestString);
    }
}
