package ArraysProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class KeyPair {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int sum=16;
        ArrayList<Integer> list = new ArrayList<>();
        list =hasArrayTwoCandidates(arr,sum);
        System.out.println(list);
    }

    public static ArrayList<Integer> hasArrayTwoCandidates(int[] arr, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();

//        for (int i = 0; i < arr.length ; i++) {
//            for (int j = i+1; j < arr.length ; j++) {
//                if(arr[i]+arr[j] == sum)
//                {
//                    ans.add(arr[i]);
//                    ans.add(arr[j]);
//                }
//            }
//        }


        //Approach2: Sorting and two pointer approach

//        Arrays.sort(arr);
//        int start=0, end= arr.length-1;
//        while(start<end)
//        {
//
//            if(arr[start]+arr[end]==sum)
//            {
//                ans.add(arr[start++]);
//                ans.add(arr[end--]);
//            }
//            else if (arr[start]+arr[end]>sum)
//            {
//                end--;
//            }
//            else if(arr[start]+arr[end]<sum)
//            {
//                start++;
//            }
//
//        }


        //using HashSet

        HashSet<Integer> set =new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int temp =sum-arr[i];
            if(set.contains(temp))
            {
                ans.add(arr[i]);
                ans.add(temp);
            }
            set.add(arr[i]);
        }
        return ans;

    }
}
