package Tree;

import java.util.HashMap;
import java.util.Map;

public class BinarySearchTrees {

    public static void main(String[] args) {
        int[] inputArray = {57, 58, 59, -22, 7, 60, 61, 62, 20, 35, 55, -14, 1, 56};
        Tree intTree = new Tree();
        for (int j : inputArray) {
            intTree.insert(j);
        }
        intTree.traverseInOrder();
        System.out.println();

        System.out.println(intTree.get(61));
        System.out.println(intTree.get(7));
        System.out.println(intTree.get(1));
        System.out.println(intTree.get(555));

        System.out.println("min = " + intTree.min());
        System.out.println("max = " + intTree.max());


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
