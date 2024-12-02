package dev.brianmiller.leet;

public class Problem383_RansomNote {

    /**
     * Java Solution to LeetCode problem 383: "Ransom Note"
     *
     * For this version, I used simple arrays of size 26 to count the
     * occurrences of letters 'a' to 'z' - assuming those were the only
     * possible characters included
     *
     * It would be better to check input characters instead of assuming
     * they are always valid lower-case English letters
     *
     * @author Brian A. Miller
     * @date Friday, October 25, 2024
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] letterCountsInRansom = new int[26];
        int[] letterCountsInMagazine = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ++letterCountsInRansom[ransomNote.charAt(i) - 'a'];
        }
        for (int j = 0; j < magazine.length(); j++) {
            ++letterCountsInMagazine[magazine.charAt(j) - 'a'];
        }
        for (int letter = 0; letter < 26; letter++) {
            if (letterCountsInRansom[letter] > letterCountsInMagazine[letter]) {
                return false;
            }
        }

        return true;
    }
}
