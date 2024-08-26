package dev.brianmiller.leet;

public class Problem69_SqrtX {

    public static int mySqrt(int x) {

        if (x < 0) {
            throw new IllegalArgumentException("x must not be negative");
        }
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        return (int) mySqrtRecursive(2, x / 2, x);
    }

    private static long mySqrtRecursive(long low, long high, long target) {
        if (low == high) {
            return low;
        }
        if (high * high == target) {
            return high;
        } else if (high - low == 1) {
            if ((low * low <= target) && (high * high > target)) {
                return low;
            } else {
                return high;
            }
        } else {
            long pivot = (high + low) / 2;
            long pivotSquared = pivot * pivot;
            // System.out.println("New pivot = " + pivot + ", pivotSquared = " + pivotSquared);
            if (pivotSquared < (long) target) {
                // System.out.println("pivotSquared < target");
                return mySqrtRecursive(pivot, high, target);
            } else {
                // System.out.println("pivotSquared > target");
                return mySqrtRecursive(low, pivot, target);
            }
        }
    }
}
