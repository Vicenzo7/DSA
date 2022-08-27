package com.company.array;

import java.util.ArrayList;

public class FindOccurance {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5,2,2,1};

        int target = 2;

        System.out.println(firstOccurrence(arr,0,target));
       System.out.println(lastOccurrence(arr,arr.length-1,target));
        ArrayList<Integer> list = new ArrayList<>();
        allOccurrence(arr,0,target,list);
        System.out.println(list);
    }


    static int firstOccurrence(int[] arr,int index,int target){
        if(index == arr.length){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

       return  firstOccurrence(arr,index+1,target);
    }

    static int lastOccurrence(int[] arr,int index,int target){
        if(index < 0){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return  lastOccurrence(arr,index-1,target);
    }

    static void allOccurrence(int[] arr,int index,int target,ArrayList<Integer> list){
        if(index == arr.length){
            return ;
        }

        if(arr[index] == target){
            list.add(index);
        }

        allOccurrence(arr,index+1,target,list);
    }
}
