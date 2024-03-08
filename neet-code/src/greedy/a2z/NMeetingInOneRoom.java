package greedy.a2z;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingInOneRoom {
    public static void main(String[] args) {
        int n = 6;
//        int[] start = {1, 3, 0, 5, 8, 5};
//        int[] end = {2, 4, 6, 7, 9, 9};
        int[] start = {10, 12, 20};
        int[] end = {20, 25, 30};

        System.out.println(maxMeetings(start, end, n));
    }

    public static int maxMeetings(int[] start, int[] end, int n) {
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new int[]{start[i], end[i]});
        }

        meetings.sort(Comparator.comparingInt(o -> o[0]));
        int count = 0;
        int previousEnd = meetings.get(0)[1];

        for (int i = 1; i < meetings.size(); i++) {
            int[] currentMeeting = meetings.get(i);
            int currentStart = currentMeeting[0];
            int currentEnd = currentMeeting[1];

            if (previousEnd >= currentStart) {
                count++;
                previousEnd = Math.min(previousEnd, currentEnd);
            } else {
                previousEnd = currentEnd;
            }
        }

        return meetings.size() - count;
    }
}
