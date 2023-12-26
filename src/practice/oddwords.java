package practice;


import java.util.*;

class OddWordsFinder {

    public static void main(String[] args) {
        String set1 = "turing community is the best";
        String set2 = "turing community is the greatest";

        List<String> oddWords = new ArrayList<>(findOddWords(set1, set2));

        System.out.println(oddWords);
    }

    public static List<String> findOddWords(String set1, String set2) {
        String[] set1Words = set1.split(" ");
        String[] set2Words = set2.split(" ");

        Set<String> uniqueSet1Words = new HashSet<>();
        Set<String> uniqueSet2Words = new HashSet<>();

        Collections.addAll(uniqueSet1Words, set1Words);

        Collections.addAll(uniqueSet2Words, set2Words);

        List<String> oddWords = new ArrayList<>();

        for (String word : uniqueSet1Words) {
            if (!uniqueSet2Words.contains(word)) {
                oddWords.add(word);
            }
        }

        for (String word : uniqueSet2Words) {
            if (!uniqueSet1Words.contains(word)) {
                oddWords.add(word);
            }
        }
        return oddWords;
    }

}