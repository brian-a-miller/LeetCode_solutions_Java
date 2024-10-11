package dev.brianmiller.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * A solution to the problem described at
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * "The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class Problem6_ZigzagConversion {

    /**
     * @author           Brian A. Miller
     * @date             August 29, 2024
     * @leetcode.status  Accepted
     * @leetcode.tests   1157 / 1157 test cases passed
     * @leetcode.runtime 75 ms
     * @leetcode.memory  46.1 MB
     */
    public static String convert(String s, int numRows) {

        // prepare extra storage containing grid of letters
        List<List<Character>> columns = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {

            // vertical column
            ArrayList<Character> column = new ArrayList<>();
            for (int row = 0; row < numRows; row++) {
                if (i >= s.length()) {
                    break;
                } else {
                    column.add(s.charAt(i++));
                }
            }
            columns.add(column);

            // diagonal
            for (int row = numRows - 2; row > 0; row--) {
                if (i >= s.length()) {
                    // TODO: or insert null value(s) ... ?
                    break;
                }
                column = new ArrayList<>();
                for (int rowFill = 0; rowFill < numRows; rowFill++) {
                    if (rowFill == row) {
                        column.add(s.charAt(i++));
                    } else {
                        column.add(null);
                    }
                }
                columns.add(column);
            }
        }

        // read result in desired order from grid
        StringBuilder resultSB = new StringBuilder();
        // TODO: convert from ArrayList to 2D array [][] first ?
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < columns.size(); col++) {
                List<Character> colList = columns.get(col);
                if (colList != null && (row + 1 <= colList.size())) {
                    Character c = colList.get(row);
                    if (c != null) {
                        resultSB.append(c);
                    }
                }
            }
        }
        return resultSB.toString();
    }
}
