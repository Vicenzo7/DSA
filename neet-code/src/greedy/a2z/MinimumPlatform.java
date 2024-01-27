package greedy.a2z;

import java.util.Arrays;

public class MinimumPlatform {

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, n));
    }

    public static int findPlatform(int[] arr, int[] dep, int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int minimumPlatform = 0;
        int count = 0;
        int start = 0;
        int end = 0;

        while (start < n - 1) {
            if (arr[start] <= dep[end]) {
                count += 1;
                start++;
            } else {
                count -= 1;
                end++;
            }
            minimumPlatform = Math.max(minimumPlatform, count);
        }

        return minimumPlatform;

    }

}
