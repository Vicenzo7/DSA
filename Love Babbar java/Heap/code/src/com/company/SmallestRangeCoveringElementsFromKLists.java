package com.company;

import java.util.*;

public class SmallestRangeCoveringElementsFromKLists {
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
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<Info> minHeap = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.data > o2.data)
                    return 1;
                else if (o1.data < o2.data)
                    return -1;
                return 0;
            }
        });

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        //create a min heap of k size of first element of each row
        for (int i = 0; i < k; i++) {
            int element = nums.get(i).get(0);
            Info temp = new Info(element,i,0);
            minHeap.add(temp);
            mini = Math.min(mini,element);
            maxi = Math.max(maxi,element);

        }

        //for storing answer range
        int start = mini;
        int end = maxi;

        while(!minHeap.isEmpty()){
            //extract the top or minimum element
            Info temp = minHeap.remove();
            //save data in mini
            mini = temp.data;

            //answer update
            if(end-start > maxi - mini){
                start = mini;
                end = maxi;
            }

            //push next element and update the max
            if(temp.col+1 < nums.get(temp.row).size()){
                Info toPush = new Info(nums.get(temp.row).get(temp.col+1),temp.row,temp.col+1);
                minHeap.add(toPush);
                maxi = Math.max(maxi,toPush.data);
            }else{
                //if at least one list exhausted than come out of the loop
                break;
            }
        }

        return new int[] {start,end};
    }


    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);


        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);

        nums.add(list1);
        nums.add(list2);
        nums.add(list3);



        SmallestRangeCoveringElementsFromKLists obj = new SmallestRangeCoveringElementsFromKLists();
        System.out.println(Arrays.toString(obj.smallestRange(nums)));
    }
}
