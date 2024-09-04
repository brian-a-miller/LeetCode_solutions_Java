package dev.brianmiller.leet;

import java.util.ArrayList;
import java.util.List;

public class Problem118_PascalsTriangle {

    // [0] [1] [2] [3] [4]
    //  1
    //  1 , 1
    //  1 , 2 , 1
    //  1 , 3 , 3 , 1
    //  1 , 4 , 6 , 4 , 1

    /**
     * @author Brian A. Miller
     * @date Wednesday, September 4, 2024
     *
     * @leetcode.status Accepted
     * @leetcode.test.result Success
     * @leetcode.test.details 30 / 30 test cases passed.
     * @leetcode.runtime 1 ms, faster than 82.58% of Java online submissions
     * @leetcode.memory.usage 42 MB, less than 45.89% of Java online submissions
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows > 0) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            result.add(row);
            for (int r = 2; r <= numRows; r++) {
                row = new ArrayList<>();
                row.add(1);
                List<Integer> previousRow = result.get(r-2);
                for (int c = 2; c < r; c++) {
                    row.add(previousRow.get(c-2) + previousRow.get(c-1));
                }
                row.add(1);
                result.add(row);
            }
        }
        return result;
    }
}