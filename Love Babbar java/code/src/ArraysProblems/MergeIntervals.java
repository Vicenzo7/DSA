package ArraysProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {8, 10},
                {2, 6},
                {9, 9},
                {15, 18}
        };
        for (int[] a : intervals) {
            System.out.println(Arrays.toString(a));
        }
        int[][] ans = merge(intervals);

//        int[][] ans2=mergeStack(intervals);
        System.out.println();

        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }

    }



    static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        if (intervals.length == 0 || intervals == null) {
            return res.toArray(new int[0][]);
        }
        //        Arrays.sort(intervals,(a,b) ->a[0] -b[0]);
        //Arrays.sort(intervals, (a, b) -> Integer.compare(b[0],a[0])); //decreasing order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //increasing order
        System.out.println();
        for (int[] a : intervals) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(i[1], end);
            } else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});


        return res.toArray(new int[0][]);
    }






    //problem solved using stack
    public static int[][] mergeStack(int[][] intervals) {

        //first we sort the array TC O(nlogn)
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        //initialise stack of type integer array
        Stack<int[]> stack = new Stack<>();
        //add first element into the stack
        stack.add(intervals[0]);

        //we start the for loop from 1 because we want to compare with the starting element of stack
        for (int i = 1; i < intervals.length ; i++) {

            //start and end pointer of 2nd element
            int startPoint2=intervals[i][0];
            int endPoint2 = intervals[i][1];

            //start and end pointers of stack element
            //to get this element we use integer array and add in those stack element by popping
            int[] popArray = stack.pop();
            int startPoint1= popArray[0];
            int endPoint1=  popArray[1];

            //1 4
            //2 3
            //1 4

            int maxEnd=Math.max(endPoint1,endPoint2);

            //checking if first endPoint is greater than second endPoint
            if(endPoint1>=startPoint2)
            {
                //if true we merge
                int[] merge = new int[]{startPoint1,maxEnd};
                stack.add(merge);
            }
            else
            {
                //else we add back to the stack the first stack element and the current interval element
                stack.add(popArray);
                stack.add(intervals[i]);
            }
        }

        //filling stack element into 2D array
        int[][] output = new int[stack.size()][2];

        for (int i = output.length-1; i >=0 ; i--) {
            int[] popArray = stack.pop();
            output[i][0]=popArray[0];
            output[i][1]=popArray[1];
        }

        return output;
    }




}
