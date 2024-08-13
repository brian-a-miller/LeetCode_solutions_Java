package dev.brianmiller.leet;

import java.util.HashSet;
import java.util.Set;

public class Problem3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String[] inputs = new String[] {
                "abcabcbb",
                "bbbbb",
                "pwwkew",
                "au",
                "dvdf"
        };

        for (String s : inputs) {
            System.out.println("Input: " + s);
            System.out.println("Output: " + lengthLongestSubstringWithoutRepeating(s));
        }
    }

    public static int lengthLongestSubstringWithoutRepeating(
            String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int candidateLength = 0;
        String candidateString = "";
        int windowLeft = 0;
        int windowRight = 0;
        int positionToCheck = 0;
        Set<Character> charsInWindow = new HashSet<>();

        while ((windowLeft < s.length()) &&
                (positionToCheck < s.length()) &&
                (windowRight < s.length())) {
            System.out.println("While: windowLeft=" + windowLeft + ", positionToCheck=" + positionToCheck +
                    ", windowRight=" + windowRight + ", s.substring(windowLeft, windowRight+1)=" + s.substring(windowLeft, windowRight+1));
            char thisChar = s.charAt(positionToCheck);
            if (charsInWindow.contains(thisChar)) {
                if (positionToCheck - windowLeft + 1 > candidateLength) {
                    candidateString = s.substring(windowLeft, positionToCheck);
                    candidateLength = candidateString.length();
                }
                if (s.length() - windowLeft < candidateLength) {
                    break;
                }
                windowLeft = Math.max(windowLeft+1, ((s.substring(windowLeft, windowRight)).lastIndexOf(thisChar)) + 1);
                windowRight = windowLeft;
                positionToCheck = windowLeft;
                charsInWindow.clear();
            } else {
                charsInWindow.add(s.charAt(positionToCheck));
                windowRight++;
                positionToCheck++;
                if (windowRight == s.length()) {
                    String tmp = s.substring(windowLeft);
                    if (tmp.length() > candidateLength) {
                        candidateString = tmp;
                        candidateLength = candidateString.length();
                    }
                }
            }
        }
        System.out.println("found answer string: " + candidateString + ", with length " +
                candidateLength);
        return candidateLength;
    }
}
