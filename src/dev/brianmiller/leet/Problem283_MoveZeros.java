package dev.brianmiller.leet;

public class Problem283_MoveZeros {

    /*
     * @author Brian A Miller (bamjuggler on leetcode)
     * @date   Wednesday, October 23, 2024
     * @leetcode.status Accepted
     * @leetcode.result Success
     * @leetcode.runtime 2 ms, faster than 86.26% of Java online submissions
     * @leetcode.memory.usage 46.1 MB, less than 11.75% of Java online submissions
     */
    public static void moveZeroes(int[] nums) {

        int numMoves = 0;
        int reader = 0;
        int writer = 0;
        while (reader < nums.length) {
            if (nums[reader] == 0) {
                reader++;
                continue;
            }
            if (writer < reader) {
                nums[writer] = nums[reader];
                numMoves++;
            }
            reader++;
            writer++;
        }
        if (numMoves == 0) {
            return;
        }
        while (writer < nums.length) {
            nums[writer++] = 0;
        }
    }
}
