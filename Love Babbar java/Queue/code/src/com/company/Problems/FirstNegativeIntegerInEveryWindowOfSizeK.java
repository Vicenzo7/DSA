package com.company.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1/
public class FirstNegativeIntegerInEveryWindowOfSizeK {

    public static void main(String[] args) {
        long[] A = {-8, 2, 3, -6, 10};
        int k = 2;

        System.out.println(Arrays.toString(printFirstNegativeInteger(A, A.length, k)));
    }


    public static long[] printFirstNegativeInteger(long A[], int N, int K) {

        ArrayList<Long> ans  = new ArrayList<>();
        //step1: create a queue
        Queue<Integer> q = new LinkedList<>();

        //step2: check for first window process
        for (int i = 0; i < K ; i++) {
            if(A[i] < 0)
                q.add(i);
        }

        //step3: save ans of first window
        if(q.size()>0)
            ans.add(A[q.peek()]);
        else
            ans.add(0L);

        //step4 : process for remaining window

        for (int i = K; i < N ; i++) {
            //check if within the window if not pop
            if(!q.isEmpty() && i-q.peek() >= K){
                q.remove();
            }

            //push in queue
            if(A[i] < 0)
                q.add(i);

            //save ans
            if(q.isEmpty())
                ans.add(0L);
            else
                ans.add(A[q.peek()]);

        }

        long[] output = new long[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            output[i] = ans.get(i);
        }
        return output;

    }
}
