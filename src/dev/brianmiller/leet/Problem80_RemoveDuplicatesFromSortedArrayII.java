package dev.brianmiller.leet;

public class Problem80_RemoveDuplicatesFromSortedArrayII {

    /**
     * @author            Brian A. Miller
     * @date              June 16, 2024
     * @leetcode.status   Accepted
     * @leetcode.runtime  0 ms (runtime beats 100.00 % of java submissions.)
     * @leetcode.memory   44.5 MB
     *
     */
    public static int removeDuplicates(int[] nums) {
        int numSame = 1;
        int shiftAmt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                numSame++;
                if (numSame > 2) {
                    shiftAmt++;
                }
            } else {
                numSame = 1;
            }
            if (shiftAmt > 0) {
                nums[i - shiftAmt] = nums[i];
            }
        }
        return (nums.length - shiftAmt);
    }
}
