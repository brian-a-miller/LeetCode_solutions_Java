package dev.brianmiller.leet;

/**
 * @author Brian A. Miller
 * @date Monday, August 26, 2024
 *
 * My solution in the Java language to the LeetCode problem
 * "70. Climbing Stairs" - as described at
 * https://leetcode.com/problems/climbing-stairs
 *
 *   --> "You are climbing a staircase. It takes n steps to reach the top.
 *        Each time you can either climb 1 or 2 steps. In how many distinct ways
 *        can you climb to the top?"
 */
public class Problem70_ClimbingStairs {

    /*
     * LeetCode submission result:
     * Success
     * Details
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 40.3 MB, less than 49.79% of Java online submissions for Climbing Stairs.
    */
    public static int climbStairs(int n) {

        // n = 1 : answer = 1 (1 step)
        // n = 2 : answer = 2 (1+1, 2)
        // n = 3 : answer = 3 (1+1+1, 1+2, 2+1)
        // n = 4 : answer = 5 (1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2)
        // n = 5 : answer = 8  (1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 1+2+2
        //                     2+1+1+1, 2+2+1, 2+1+2)
        // answers match Fibonacci sequence
/*
 *
 * NOTE: recursive approach resulted in a Time Out with larger input values
 *
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return climbStairs(n - 2) + climbStairs(n - 1);
        }
*/
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int grandparent = 1;
        int parent = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = grandparent + parent;
            grandparent = parent;
            parent = result;
        }
        return result;
    }
}
