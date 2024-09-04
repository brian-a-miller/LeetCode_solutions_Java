package dev.brianmiller.leet;

public class Problem1672_RichestCustomerWealth {

    /*
     * @author Brian A. Miller
     * @date Monday, August 26, 2024
     *
     * Success
     *   Details
     *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Richest Customer Wealth.
     *   Memory Usage: 42.5 MB, less than 72.32% of Java online submissions for Richest Customer Wealth.
     *
     * 34 / 34 test cases passed.
     */
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int[] customerAccounts = accounts[i];
            int wealth = 0;
            for (int j = 0; j < customerAccounts.length; j++) {
                wealth += customerAccounts[j];
            }
            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }
        return maxWealth;
    }
}
