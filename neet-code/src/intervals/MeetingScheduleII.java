package intervals;

import java.util.*;

public class MeetingScheduleII {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>() {{

//            add(new Interval(0, 10));
//            add(new Interval(1, 3));
//            add(new Interval(2, 6));
//            add(new Interval(5, 8));
//            add(new Interval(7, 12));
//            add(new Interval(11, 15));
//            add(new Interval(13, 18));
//            add(new Interval(16, 20));
//            add(new Interval(19, 25));
//            add(new Interval(24, 30));

//            add(new Interval(0, 10));
//            add(new Interval(2, 3));
//            add(new Interval(3, 4));
//            add(new Interval(4, 5));
//            add(new Interval(5, 6));

            add(new Interval(1, 5));
            add(new Interval(2, 6));
            add(new Interval(3, 7));
            add(new Interval(4, 8));
            add(new Interval(5, 9));
        }};

        System.out.println(minMeetingRooms(intervals));
        System.out.println(minMeetingRoomsTwoPointer(intervals));

    }


    public static int minMeetingRoomsTwoPointer(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int minimumRooms = 0;
        int count = 0;
        int s = 0;
        int e = 0;
        while (s < start.length) {
            if (start[s] < end[e]) {
                s += 1;
                count += 1;
            } else {
                e += 1;
                count = -1;
            }
            minimumRooms = Math.max(minimumRooms, count);
        }

        return minimumRooms;
    }

    /**
     * Calculates the minimum number of meeting rooms required to schedule all given intervals.
     *
     * @param intervals List of intervals representing meeting start and end times.
     * @return The minimum number of meeting rooms needed.
     */
    public static int minMeetingRooms(List<Interval> intervals) {
        // Sort intervals based on meeting start times
        intervals.sort(Comparator.comparingInt(o -> o.start));

        // Priority Queue (minHeap) to keep track of meetings ending earliest and also have many rooms are occupied
        Queue<Interval> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        int minMeetingRooms = 0; // Keeps track of the minimum meeting rooms required

        // Iterate through each interval
        for (Interval currentMeeting : intervals) {
            // Check if there are any meetings that have ended and rooms are available
            while (!minHeap.isEmpty() && currentMeeting.start >= minHeap.peek().end) {
                // Remove the meeting with the earliest end time, as its room becomes available
                minHeap.poll();
            }

            // Schedule the current meeting and update the minimum meeting rooms required
            minHeap.offer(currentMeeting);
            minMeetingRooms = Math.max(minMeetingRooms, minHeap.size());
        }

        return minMeetingRooms;
    }


    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
