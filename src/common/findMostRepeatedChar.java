package common;


import java.util.HashMap;
import java.util.Map;

public class findMostRepeatedChar {

    public static void main(String[] args) {

        System.out.println("findMostRepeatedChar = " + findMostRepeatedChar("abbbssssoooookdonnnnnnnnnnakdoa323"));

    }


    public static char findMostRepeatedChar(String str) {
        // Create a map to store the frequency of each character
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Loop through the characters in the string
        for (char c : str.toCharArray()) {
            // If the character is already in the map, increment its frequency
            if (charFrequency.containsKey(c)) {
                charFrequency.put(c, charFrequency.get(c) + 1);
            }
            // Otherwise, add the character to the map with a frequency of 1
            else {
                charFrequency.put(c, 1);
            }
        }

        // Loop through the map to find the character with the highest frequency
        char mostRepeatedChar = ' ';
        int highestFrequency = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > highestFrequency) {
                highestFrequency = entry.getValue();
                mostRepeatedChar = entry.getKey();
            }
        }

        return mostRepeatedChar;
    }
}
