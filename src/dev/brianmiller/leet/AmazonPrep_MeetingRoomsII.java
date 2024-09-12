package dev.brianmiller.leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AmazonPrep_MeetingRoomsII {

    /**
     * @author           Brian A. Miller
     * @date             Wednesday, September 11, 2024
     * @leetcode.status  Accepted
     * @leetcode.tests   79 / 79 test cases passed
     * @leetcode.runtime 9 ms
     * @leetcode.memory  45.7 MB
     */
    public static void main(String[] args) {

        final int[][] example1Input = new int[][] { { 0, 30}, { 5, 10}, { 15, 20 } };
        final int example1ExpectedOutput = 2;

        int example1Result = minMeetingRooms(example1Input);
        System.out.printf("Example 1: expected=%d, actual=%d%n", example1ExpectedOutput, example1Result);

        final int[][] example2Input = new int[][] { { 7, 10 }, { 2, 4 } };
        final int example2ExpectedOutput = 1;

        int example2Result = minMeetingRooms(example2Input);
        System.out.printf("Example 2: expected=%d, actual=%d%n", example2ExpectedOutput, example2Result);

    }

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            int compareStartTimes = Integer.compare(o1[0], o2[0]);
            if (compareStartTimes == 0) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return compareStartTimes;
            }
        });

        int numRoomsNeeded = 0;
        int numRoomsInUse = 0;
        PriorityQueue<Integer> meetingEndTimes = new PriorityQueue<>();

        for (int meeting = 0; meeting < intervals.length; meeting++) {
            int newStartTime = intervals[meeting][0];
            int newEndTime = intervals[meeting][1];
            int previousEndTime = -1;

            if (!meetingEndTimes.isEmpty()) {
                boolean removedPrevious = false;
                do {
                    if (meetingEndTimes.isEmpty()) {
                        removedPrevious = false;
                    } else {
                        previousEndTime = meetingEndTimes.peek();
                        if (previousEndTime <= newStartTime) {
                            meetingEndTimes.remove();
                            removedPrevious = true;
                            numRoomsInUse--;
                        } else {
                            removedPrevious = false;
                        }
                    }
                } while (removedPrevious);
            }

            meetingEndTimes.add(newEndTime);
            numRoomsInUse++;
            numRoomsNeeded = Math.max(numRoomsNeeded, numRoomsInUse);
        }

        return numRoomsNeeded;
    }
}
