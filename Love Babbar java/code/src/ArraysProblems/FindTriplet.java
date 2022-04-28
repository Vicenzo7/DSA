package ArraysProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FindTriplet {
    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 1, 6, 9};
        int sum=24;
        ArrayList<Integer> list = new ArrayList<>();
        list =find3Number(arr,sum);
        System.out.println(list);
    }

    public static ArrayList<Integer> find3Number(int[] arr, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < arr.length ; i++) {
//            for (int j = i+1; j < arr.length ; j++) {
//                for (int k = j+1; k < arr.length ; k++) {
//                    if(arr[i]+arr[j]+arr[k] == sum)
//                    {
//                        ans.add(arr[i]);
//                        ans.add(arr[j]);
//                        ans.add(arr[k]);
//                    }
//                }
//
//            }
//        }

        //using Sorting a nd two pointer
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2 ; i++) {
            int start=i+1,end=arr.length-1;
            while(start<end)
            {
                if(arr[i]+arr[start]+arr[end]==sum)
                {
//                    System.out.println(arr[i]+" "+arr[start]+" "+arr[end]);
                    ans.add(arr[i]);
                    ans.add(arr[start++]);
                    ans.add(arr[end--]);
                }
                else if(arr[i]+arr[start]+arr[end]<sum)
                {
                    start++;
                }
                else //arr[i]+arr[start]+arr[end]>sum
                {
                    end--;
                }
            }
        }



        //optimised approach using hashset

//        for (int i = 0; i < arr.length-2 ; i++) {
//            HashSet<Integer> set = new HashSet<>();
//            int temp=sum-arr[i];
//            for (int j = i+1; j < arr.length; j++) {
//                if(set.contains(temp-arr[j]))
//                {
//                    ans.add(arr[i]);
//                    ans.add(arr[j]);
//                    ans.add(temp-arr[j]);
//                   return ans;
//                }
//                set.add(arr[j]);
//            }
//        }
        return ans;
    }
}
