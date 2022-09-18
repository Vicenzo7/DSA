package com.company.medium;

import java.util.Arrays;
//

// DP question
public class MaximumHeightByStackingCuboids {
    public static void main(String[] args) {
        int[][] cuboids = { {50,45,20},
                {95,37,53},
                {45,23,12}};

        System.out.println(maxHeight(cuboids));
    }

    public static int maxHeight(int[][] cuboids) {
        // step1 sort all dimensions
        for(int[]row : cuboids){
            Arrays.sort(row);
        }

        //step2: sort basis on first parameter
        Arrays.sort(cuboids,(a,b)-> a[0]-b[0]);


//         for (int i = 0; i <cuboids.length ; i++) {

//             for (int j = 0; j <cuboids[0].length ; j++) {
//                 System.out.print(cuboids[i][j] +" ");
//             }
//         }System.out.println();


        int ans =solve(cuboids, cuboids.length, cuboids.length-1,-1);


        return ans;
    }

    static int solve(int[][] cuboids,int n,int curr,int prev){
        // base case
        if(curr< 0)
            return 0;


        // include
        int pick =0;
        if(prev ==-1 || isSafe(cuboids,curr,prev))
            pick = cuboids[curr][2] + solve(cuboids,n,curr-1,curr);

        int notPick =0+solve(cuboids,n,curr-1,prev);

        return Math.max(pick,notPick);
    }



    static boolean isSafe(int[][] cuboids, int curr, int prev){

        if((cuboids[curr][0] <= cuboids[curr][0])
                &&
                (cuboids[curr][1] <= cuboids[curr][1])
                &&
                (cuboids[curr][2] <= cuboids[curr][2])
        )
        {
            return true;
        }

        return false;
    }
}
