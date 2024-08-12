package dev.brianmiller.leet;

/**
 * Solution in Java for LeetCode problem "36. Valid Sudoku"
 * described at https://leetcode.com/problems/valid-sudoku/
 */
public class Problem36_ValidSudoku {

    /**
     * @author           Brian A. Miller
     * @date             August 5, 2024
     * @leetcode.status  Accepted
     * @leetcode.runtime 87 ms
     * @leetcode.memory  45.3 MB
     */
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length < 9) {
            throw new IllegalArgumentException("Bad input. Fewer than 9 columns");
        }
        var digitsFoundInColumns = new ArrayList<ArrayList<Boolean>>();
        var digitsFoundInSubBoxes = new ArrayList<Boolean[]>();
        for (int b = 0; b < 9; b++) {
            Boolean[] digitsFoundInSubBox = new Boolean[10];
            digitsFoundInSubBoxes.add(b, digitsFoundInSubBox);
        }
        for (int row = 0; row < 9; row++) {
            char[] rowData = board[row];
            if (rowData.length < 9) {
                throw new IllegalArgumentException("Bad input: row length < 9");
            }
            boolean[] digitFound = new boolean[10];
            for (int column = 0; column < 9; column++) {
                System.out.println("row=" + row + ", column=" + column + ", rowData[column]=" + rowData[column]);
                
                
                if (row == 0) {
                    ArrayList<Boolean> digitsFoundInColumn = new ArrayList<>(10);
                    for (int i = 0; i < 10; i++) {
                        digitsFoundInColumn.add(Boolean.FALSE);
                    }
                    System.out.println("Adding column " + column + " to digitsFoundInColumns");
                    digitsFoundInColumns.add(column, digitsFoundInColumn);
                }
                if (rowData[column] < '0' || rowData[column] > '9') {
                    continue;
                }
                int intValue = (int) (rowData[column] - '0');
                // System.out.println("rowData[column] = " + rowData[column]);
                System.out.println("Checking if found in row using digitFound[] array ...");
                if (digitFound[intValue]) {
                    return false;
                } else {
                    digitFound[intValue] = true;
                }
                if (digitsFoundInColumns.get(column) == null) {
                    System.out.println("ERROR: digitsFoundInColumns.get(column=" + column + ") == null");
                }
                if (digitsFoundInColumns.get(column).get(intValue)) {
                    return false;
                } else {
                    digitsFoundInColumns.get(column).set(intValue, true);
                }
                int subBoxNumber = -1;
                if (row < 3) {
                    if (column < 3) {
                        subBoxNumber = 0;
                    } else if (column > 5) {
                        subBoxNumber = 2;
                    } else {
                        subBoxNumber = 1;
                    }
                } else if (row > 5) {
                    if (column < 3) {
                        subBoxNumber = 6;
                    } else if (column > 5) {
                        subBoxNumber = 8;
                    } else {
                        subBoxNumber = 7;
                    }
                } else {
                    if (column < 3) {
                        subBoxNumber = 3;
                    } else if (column > 5) {
                        subBoxNumber = 5;
                    } else {
                        subBoxNumber = 4;
                    }
                }
                if (digitsFoundInSubBoxes == null) {
                    System.out.println("ERROR: digitsFoundInSubBoxes == null");
                } else if (digitsFoundInSubBoxes.get(subBoxNumber) == null) {
                    System.out.println("ERROR: digitsFoundInSubBoxes.get(subBoxNumber=" + subBoxNumber+ ") == null");
                } else if (digitsFoundInSubBoxes.get(subBoxNumber)[intValue] != null && digitsFoundInSubBoxes.get(subBoxNumber)[intValue] == Boolean.TRUE) {
                    return false;
                } else {
                    digitsFoundInSubBoxes.get(subBoxNumber)[intValue] = Boolean.TRUE;
                }
            }
        }
        return true;
    }
}
