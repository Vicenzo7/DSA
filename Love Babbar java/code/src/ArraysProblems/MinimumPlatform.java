package ArraysProblems;

import java.util.Arrays;

public class MinimumPlatform {
    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800 };
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        int ans = findMinimumPlatforms(arrival, departure);
        System.out.println(ans);
    }

    public static int findMinimumPlatforms(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        //length of both array is same;
        int n = arrival.length;
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            //Checking if arrival train comes before departure train
            if (arrival[i] <= departure[j]) {
                plat_needed++;
                i++;
            }
            //checking if arrival train comes after departure train
            else if (arrival[i] >= departure[j]) {
                plat_needed--;
                j++;
            }
            if (plat_needed > result) {
                result = plat_needed;
            }
        }
        return result;
    }
}
