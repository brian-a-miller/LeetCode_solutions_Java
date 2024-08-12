package dev.brianmiller.leet;

/**
 * @author Brian A. Miller
 * @date   July 26, 2024
 * LeetCode status: Accepted
 * runtime beats 100.00 % of java submissions
 *
 * My solution in Java for the LeetCode problem "290. Word Pattern"
 * described at https://leetcode.com/problems/word-pattern/
 */
public class Problem290_WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        if (s == null || pattern == null) {
            return false;
        }
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> mapCharToWord = new HashMap<>();
        HashMap<String, Character> mapWordToChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character letter = (Character) pattern.charAt(i);
            String word = words[i];
            if (mapCharToWord.containsKey(letter)) {
                String expected = mapCharToWord.get(letter);
                if (!expected.equalsIgnoreCase(words[i])) {
                    return false;
                }
            } else {
                if (mapWordToChar.containsKey(word)) {
                    Character expectedLetter = mapWordToChar.get(word);
                    if (expectedLetter != letter) {
                        return false;
                    }
                } else {
                    mapCharToWord.put(letter, word);
                    mapWordToChar.put(word, letter);
                }
            }
        }
        return true;
    }
}
