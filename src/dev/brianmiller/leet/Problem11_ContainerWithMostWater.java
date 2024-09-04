package dev.brianmiller.leet;

public class Problem11_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int windowLeft = 0;
        int windowRight = height.length - 1;
        int maximumArea = 0;
        while (windowRight > windowLeft) {
            int leftHeight = height[windowLeft];
            int rightHeight = height[windowRight];
            int area = Math.min(leftHeight, rightHeight) * (windowRight - windowLeft);
            if (area > maximumArea) {
                maximumArea = area;
            }
            if (leftHeight < rightHeight) {
                windowLeft++;
            } else {
                windowRight--;
            }
        }
        return maximumArea;
    }
}
