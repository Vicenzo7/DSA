package com.company.medium;
//https://leetcode.com/problems/pizza-with-3n-slices/

// DP Question
public class PizzaWith3nSlices {

    public static void main(String[] args) {
        int [] slices = {1,2,3,4,5,6};
        System.out.println(maxSizeSlices(slices));
    }

    public static int maxSizeSlices(int[] slices) {
        // 3n slices
        int totalSlice = slices.length;
        //option1 -> include first element of array
        int option1 = solve(slices, 0, slices.length - 2, totalSlice / 3);
        //option1 -> include first element of array
        int option2 = solve(slices, 1, slices.length - 1, totalSlice / 3);


        return Math.max(option1, option2);
    }


    static int solve(int[] slices, int s, int e, int n) {

        if (n == 0 || s > e)
            return 0;


        int include = slices[s] + solve(slices, s + 2, e, n - 1);
        int exclude = solve(slices, s + 1, e, n);

        return Math.max(include, exclude);

    }

}
