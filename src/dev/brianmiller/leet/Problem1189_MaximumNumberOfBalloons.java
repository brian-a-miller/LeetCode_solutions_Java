package dev.brianmiller.leet;

public class Problem1189_MaximumNumberOfBalloons {

    /**
     * Java solution to LeetCode problem
     * "Maximum Number of Balloons"
     * Simple approach: first count number of occurrences
     * of each letter, then check how many "balloon" words
     * can be made using those letters
     *
     * @author Brian A. Miller (bamjuggler on leetcode)
     * @date Friday, October 25, 2024
     * @leetcode.test.results 28 / 28 test cases passed
     * @leetcode.runtime 3 ms, beats 80.32 % of java submissions
     * @leetcode.memory.usage 41.7 MB
     *
     */
    public static int maxNumberOfBalloons(String text) {
        int aCount = 0;
        int bCount = 0;
        int lCount = 0;
        int oCount = 0;
        int nCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case 'a':
                    aCount++;
                    break;
                case 'b':
                    bCount++;
                    break;
                case 'l':
                    lCount++;
                    break;
                case 'n':
                    nCount++;
                    break;
                case 'o':
                    oCount++;
                    break;
            }
        }
        int balloonCount = 0;
        while ((aCount >= 1) && (bCount >= 1) && (lCount >= 2) &&
                (oCount >= 2) && (nCount >= 1)) {

            balloonCount++;
            bCount--;
            aCount--;
            lCount -= 2;
            oCount -= 2;
            nCount--;
        }
        return balloonCount;
    }

}
