package ArraysProblems;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting2DArray {
    public static void main(String[] args) {
        int[][] intervals ={
                {1,3},
                {8,10},
                {2,6},
                {9,9},
                {15,18}
        };
        for(int[] a :intervals)
        {
            System.out.println(Arrays.toString(a));
        }
        sort(intervals);


    }

    static void sort(int[][] intervals) {
        int n= intervals.length;
        int m= intervals[0].length;
        int col=1;

        //sorting array according to specific column
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] val1, int[] val2) {
                if(val1[col-1]>val2[col-1])
                    return 1;
                else
                    return -1;

            }
        });



        //sorts array entirely
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m ; j++) {
                for (int k = 0; k < n ; k++) {
                    for (int l = 0; l <m ; l++) {
                        if(intervals[i][j]<intervals[k][l])
                        {
                            int temp =intervals[i][j];
                            intervals[i][j]=intervals[k][l];
                            intervals[k][l]=temp;
                        }
                    }
                }
            }
        }

//        Arrays.sort(intervals,(a,b) ->a[0] -b[0]);

//        Arrays.sort(intervals, (a, b) -> Integer.compare(b[0],a[0])); //decreasing order
//
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0])); //increasing order

        System.out.println();
        for(int[] a :intervals)
        {
            System.out.println(Arrays.toString(a));
        }
    }
}
