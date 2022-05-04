package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums ={3,2,4};
        int target = 6;
//        ArrayList<Integer> result = new ArrayList<>();
//        result =twoSum(nums,target);
//        System.out.println();
//        for(int num : result) {
//            System.out.print(num + " ");
//        }
        int[] result2= twoSum(nums,target);
        for(int num : result2) {
            System.out.print(num + " ");
        }

    }

    public static int[] twoSum(int[] nums, int target) {

//        int[] ans= new int[2];
//        int c=0;
//
//        for (int i = 0; i <nums.length-1 ; i++) {
//            for (int j =i+1 ; j < nums.length ; j++) {
//
//                if(nums[i]+nums[j] == target)
//                {
//                    ans[c++]=i;
//                    ans[c]=j;
//                }
//            }
//        }
//        return ans;

        //approach optimised

//        ArrayList<Integer> ans = new ArrayList<>();
//        int n=nums.length;
//        int start=0;
//        int end=n-1;
//        Arrays.sort(nums);
//        for (int a:nums)
//        {
//            System.out.print(a+" ");
//        }
//        while(start<end)
//        {
//
//            int sum=nums[start]+nums[end];
//            if(sum==target)
//            {
//                ans.add(start++);
//                ans.add(end--);
//            }
//            else if (sum<0)
//            {
//                start++;
//            }
//            else
//            {
//                end--;
//            }
//        }
//        return ans;




        //using hashmap

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number=target-nums[i];
            if(map.containsKey(number))
            {
                return new int[]{map.get(number),i};
            }
            else
            {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
