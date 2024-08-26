package dev.brianmiller.leet;

import java.util.*;

public class Problem56_MergeIntervals {

    public static void main(String[] args) {

        // int[][] inputIntervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] inputIntervals = new int[][] { { 1, 4 }, {1, 4} };
        System.out.println("Input: ");
        for (int i = 0; i < inputIntervals.length; i++) {
            System.out.println(Arrays.toString(inputIntervals[i]));
        }
        int[][] outputIntervals = merge(inputIntervals);
        System.out.println("\nOutput: ");
        for (int i = 0; i < outputIntervals.length; i++) {
            System.out.println(Arrays.toString(outputIntervals[i]));
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<Integer[]> newIntervalsList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newIntervalsList.isEmpty()) {
                newIntervalsList.add(new Integer[] { intervals[i][0], intervals[i][1]});
            } else {
                int newLow = intervals[i][0];
                int newHigh = intervals[i][1];
                //for (Integer[] oldInterval : newIntervalsList) {
                var iterator = newIntervalsList.listIterator();
                boolean foundOverlap = false;
                while (iterator.hasNext() && !foundOverlap) {
                    Integer[] oldInterval = iterator.next();
                    int oldLow = oldInterval[0];
                    int oldHigh = oldInterval[1];
                    if ((newLow == oldLow) && (newHigh == oldHigh)) {
                        foundOverlap = true;
                    }
                    if ((newLow >= oldLow) && (newLow <= oldHigh) && (newHigh > oldHigh)) {
                        oldInterval[1] = newHigh;
                        System.out.printf("Updated known interval [%d, %d] --> [%d, %d]%n", oldLow, oldHigh, oldLow, newHigh);
                        foundOverlap = true;
                    } else if ((newLow < oldLow) && (newHigh >= oldLow)) {
                        oldInterval[0] = newLow;
                        oldInterval[1] = Math.max(oldHigh, newHigh);
                        System.out.printf("Updated known interval [%d, %d] --> [%d, %d]%n", oldLow, oldHigh, newLow, oldInterval[1]);
                        foundOverlap = true;
                    }
                }
                if (!foundOverlap) {
                    newIntervalsList.add(new Integer[] { newLow, newHigh });
                    System.out.printf("Added new interval [%d, %d]%n", newLow, newHigh);
                }
            }
        }
        int[][] result = new int[newIntervalsList.size()][2];
        for (int i = 0; i < newIntervalsList.size(); i++) {
            result[i] = new int[] { newIntervalsList.get(i)[0], newIntervalsList.get(i)[1] };
        }
        return result;
    }


    /*
    public static int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[0][0];
        }
        Set<Interval> sortedIntervals = new TreeSet<>();
        for (int[] pair : intervals) {
            Interval interval = new Interval(pair[0], pair[1]);
            sortedIntervals.add(interval);
        }
        Interval[] intervalsArray = sortedIntervals.toArray(new Interval[0]);
        var mergedIntervalsList = new ArrayList<ArrayList<Integer>>();
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < intervalsArray.length) {
            ArrayList<Integer> mergedInterval = new ArrayList<>(2);
            mergedInterval.add(intervalsArray[startIndex].getStart());
            int tmpIndex = endIndex + 1;
            while ((tmpIndex < intervalsArray.length) &&
                    (intervalsArray[startIndex].isOverlapping(intervalsArray[tmpIndex]))) {
                endIndex = tmpIndex;
                tmpIndex++;
            }
            mergedInterval.add(intervalsArray[endIndex].getEnd());
            mergedIntervalsList.add(mergedInterval);
            startIndex = endIndex + 1;
        }

        // return mergedIntervalsList.toArray(new int[mergedIntervalsList.size()][]);
        int[][] result = new int[mergedIntervalsList.size()][2];
        for (int i = 0; i < mergedIntervalsList.size(); i++) {
            result[i] = new int[] { mergedIntervalsList.get(i).get(0), mergedIntervalsList.get(i).get(1) };
        }
        return result;
    }
     */
}

/*
class Interval implements Comparable<Interval> {
    private final int start;
    private final int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int compareTo(Interval other) {
        if (other == null) {
            return 1;
        }
        if (start == other.start) {
            return Integer.compare(end, other.end);
        } else {
            return Integer.compare(start, other.start);
        }
    }

    public boolean isOverlapping(Interval other) {
        if (other == null) {
            return false;
        }
        return (other.start <= this.end) || (this.start <= other.end);
    }

    public boolean equals(Interval other) {
        return ((other != null) && (start == other.start) && (end == other.end));
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof Interval) {
            return equals((Interval) other);
        } else {
            return false;
        }
    }
}
*/
