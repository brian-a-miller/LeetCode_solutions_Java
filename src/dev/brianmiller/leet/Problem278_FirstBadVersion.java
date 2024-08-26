package dev.brianmiller.leet;

import java.util.Random;

public class Problem278_FirstBadVersion {

    private final static int MAX_POSSIBLE_VERSION = 999;

    private static int numVersions;
    private static int firstBadVersionSecret;

    private static Random rand = new Random();


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            resetData();
            int result = firstBadVersion(numVersions);
            System.out.println("result = " + result);
        }
    }

    private static void resetData() {
        numVersions = rand.nextInt(1, MAX_POSSIBLE_VERSION + 1);
        firstBadVersionSecret = rand.nextInt(1, numVersions + 1);
        System.out.println("numVersions = " + numVersions + ", firstBadVersionSecret = " + firstBadVersionSecret);
    }

    private static boolean isBadVersion(int version) {
        return (version >= firstBadVersionSecret);
    }

    public static int firstBadVersion(int n) {
        if (n <= 1) {
            return 1;
        }
        return firstBadVersionIterative(n);
        // return firstBadVersionRecursive(1, n);
    }

    public static int firstBadVersionIterative(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + ((high - low) / 2);
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
/*
    public static int firstBadVersionRecursive(int low, int high) {
        if (low == high) {
            return low;
        }
        if (high - low == 1) {
            if (isBadVersion(low)) {
                return low;
            } else {
                return high;
            }
        }
        int pivot = low + ((high - low) / 2);
        if (isBadVersion(pivot)) {
            return firstBadVersionRecursive(low, pivot);
        } else {
            return firstBadVersionRecursive(pivot, high);
        }
    }
*/

}
