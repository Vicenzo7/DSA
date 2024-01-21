package intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingSchedule {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>() {{
//            add(new Interval(0, 30));
//            add(new Interval(5, 10));
//            add(new Interval(15, 20));
            add(new Interval(5, 8));
            add(new Interval(9, 15));
        }};

        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {
        // sort the intervals according to start

        intervals.sort(Comparator.comparingInt(o -> o.start));
        int previousEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            int currentStart = currentInterval.start;
            int currentEnd = currentInterval.end;

            // check if overlapping
            if (previousEnd > currentStart) {
                return false;
            } else {
                previousEnd = currentEnd;
            }
        }

        return true;
    }

    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}


