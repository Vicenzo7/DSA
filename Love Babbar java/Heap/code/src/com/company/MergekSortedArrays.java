package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedArrays {
    class Info {
        int data;
        int row;
        int col;

        public Info(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }
    }


    class Cmp implements Comparator<Info> {

        @Override
        public int compare(Info a, Info b) {
            if (a.data > b.data)
                return 1;
            else if (a.data < b.data)
                return -1;
            return 0;
        }
    }


    public ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        int n = arr[0].length;
        PriorityQueue<Info> minHeap = new PriorityQueue<>(new Cmp());
        ArrayList<Integer> ans = new ArrayList<>();

        //step1: put first element of all rows in to the heap
        for (int i = 0; i < k; i++) {
            int ele = arr[i][0];
            Info temp = new Info(ele, i, 0);
            minHeap.add(temp);
        }

        while (minHeap.size() > 0) {
            //fetch top element
            Info temp = minHeap.remove();

            //add to ans
            ans.add(temp.data);

            //check if next element exist, if yes than push in min heap
            if (temp.col + 1 < n) {
                Info toPush = new Info(arr[temp.row][temp.col + 1], temp.row, temp.col + 1);
                minHeap.add(toPush);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int[][] arr = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};

        MergekSortedArrays obj = new MergekSortedArrays();

        ArrayList<Integer> ans = obj.mergeKArrays(arr, k);
        System.out.println(ans);
    }
}
