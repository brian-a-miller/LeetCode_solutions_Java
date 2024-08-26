package dev.brianmiller.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * A solution to the problem "54. Spiral Matrix" as described at
 * https://leetcode.com/problems/spiral-matrix/
 */
public class Problem54_SpiralMatrix {

    private enum CurrentDirection {
        RIGHT, DOWN, LEFT, UP;
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();

        CurrentDirection currentDirection = CurrentDirection.RIGHT;
        int row = 0;
        int column = 0;
        int topRowIncluded = -1;
        int bottomRowIncluded = matrix.length;
        int leftColumnIncluded = -1;
        int rightColumnIncluded = matrix[row].length;
        boolean reachedCenter = false;
        while (!reachedCenter && (topRowIncluded < bottomRowIncluded) && (leftColumnIncluded < rightColumnIncluded)) {

            int value = matrix[row][column];
            result.add(value);

            switch (currentDirection) {
                case RIGHT:
                    if (column + 1 < rightColumnIncluded) {
                        column++;
                    } else {
                        row++;
                        topRowIncluded++;
                        currentDirection = CurrentDirection.DOWN;
                    }
                    break;

                case DOWN:
                    if (row + 1 < bottomRowIncluded) {
                        row++;
                    } else {
                        column--;
                        rightColumnIncluded--;
                        currentDirection = CurrentDirection.LEFT;
                    }
                    break;

                case LEFT:
                    if (column - 1 > leftColumnIncluded) {
                        column--;
                    } else {
                        row--;
                        bottomRowIncluded--;
                        currentDirection = CurrentDirection.UP;
                    }
                    break;

                case UP:
                    if (row - 1 > topRowIncluded) {
                        row--;
                    } else {
                        column++;
                        leftColumnIncluded++;
                        currentDirection = CurrentDirection.RIGHT;
                    }
                    break;
            }
            if (row >= bottomRowIncluded || row <= topRowIncluded ||
                    column <= leftColumnIncluded || column >= rightColumnIncluded) {
                reachedCenter = true;
            }
        }
        return result;
    }
}
