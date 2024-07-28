package dp.pattern.linear_sequence_with_constant_transition;

import java.util.*;

public class MinimumCostForTickets {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

//        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
//        int[] costs = {2, 7, 15};
//        int[] days = {1, 3, 7};
//        int[] costs = {1, 4, 20};


        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        System.out.println(bruteForce(days, costs, 0));
        System.out.println(memoization(days, costs, 0, new HashMap<>()));
        return dp(days, costs);
    }

    private static int bruteForce(int[] days, int[] costs, int startDay) {

        // check if start day is beyond days
        if (startDay >= days.length) {
            return 0;
        }

        // on this day we buy one day pass and move to the next day
        int oneDayPass = costs[0] + bruteForce(days, costs, startDay + 1);

        /*
            our next option is to buy a weekly pass on this day, so we can travel for next 7 days
            and move forward to buy tickets when our weekly pass gets over
        */

        int i = startDay;
        while (i < days.length && days[i] < days[startDay] + 7) {
            // starting from the start day and checking if the weekly pass is valid on the ith day
            i++;
        }
        int weeklyPass = costs[1] + bruteForce(days, costs, i);

        /*
            our next option is to buy a monthly pass on this day, so we can travel for next 30 days
            and move forward to buy tickets when our monthly pass gets over
        */

        i = startDay;
        while (i < days.length && days[i] < days[startDay] + 30) {
            // starting from start day and checking if the monthly pass is valid on the ith day
            i++;
        }
        int monthlyPass = costs[2] + bruteForce(days, costs, i);
        return Math.min(oneDayPass, Math.min(weeklyPass, monthlyPass));
    }

    private static int memoization(int[] days, int[] costs, int startDay, Map<Integer, Integer> cache) {

        // check if start day is beyond days
        if (startDay >= days.length) {
            return 0;
        }

        if (cache.containsKey(startDay)) {
            return cache.get(startDay);
        }

        // on this day we buy one day pass and move to the next day
        int oneDayPass = costs[0] + memoization(days, costs, startDay + 1, cache);

        /*
            our next option is to buy a weekly pass on this day, so we can travel for next 7 days
            and move forward to buy tickets when our weekly pass gets over
        */

        int i = startDay;
        while (i < days.length && days[i] < days[startDay] + 7) {
            // starting from the start day and checking if the weekly pass is valid on the ith day
            i++;
        }
        int weeklyPass = costs[1] + memoization(days, costs, i, cache);

        /*
            our next option is to buy a monthly pass on this day, so we can travel for next 30 days
            and move forward to buy tickets when our monthly pass gets over
        */

        i = startDay;
        while (i < days.length && days[i] < days[startDay] + 30) {
            // starting from start day and checking if the monthly pass is valid on the ith day
            i++;
        }
        int monthlyPass = costs[2] + memoization(days, costs, i, cache);
        int minCostForTravel = Math.min(oneDayPass, Math.min(weeklyPass, monthlyPass));
        cache.put(startDay, minCostForTravel);
        return minCostForTravel;
    }


    private static int dp(int[] days, int[] costs) {

        Set<Integer> travelDays = new HashSet<>(Arrays.stream(days).boxed().toList());
        int[] dp = new int[366];
        for (int currentDay = 1; currentDay <= days[days.length - 1]; currentDay++) {

            if (travelDays.contains(currentDay)) {
                dp[currentDay] = Math.min(
                        dp[currentDay - 1] + costs[0], // previous day cost + one day pass,
                        Math.min(
                                dp[Math.max(0, currentDay - 7)] + costs[1], // previous 7 day cost + 7 day pass,
                                dp[Math.max(0, currentDay - 30)] + costs[2] // previous 30 day cost + 30 day pass,
                        )
                );
            } else {
                dp[currentDay] = dp[currentDay - 1]; // adding previous day cost
            }
        }

        return dp[days[days.length - 1]];
    }
}
