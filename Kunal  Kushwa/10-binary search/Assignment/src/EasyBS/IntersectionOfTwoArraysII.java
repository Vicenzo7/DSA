package EasyBS;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        int[] result=intersect(nums1,nums2);
        for(int x:result)
        {
            System.out.println(x+" ");
        }
    }


    public static int[] intersect(int[] nums1, int[] nums2) {

        //approach 1
         Arrays.sort(nums1);
         Arrays.sort(nums2);
         ArrayList<Integer> list = new ArrayList<>();
         int left=0;
         int right=0;

         while(left< nums1.length && right<nums2.length)
         {
             if(nums1[left] == nums2[right])
             {
                 list.add(nums1[left]);
                 left++;
                 right++;
             }
             else if(nums1[left] < nums2[right])
             {
                 left++;
             }
             else {
                 right++;
             }
         }
         int n=list.size();
         int[] ans = new int[n];
         for(int i=0;i<n;i++)
         {
             ans[i]=list.get(i);
         }
         return ans;



//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int left=0,right=0;
//        ArrayList<Integer> intersection= new ArrayList<>();
//
//        while(left<nums1.length && right<nums2.length)
//        {
//            //skip duplicates
////             while(left>0 && left<nums1.length && nums1[left]==nums1[left-1])
////             {
////                 left++;
//
////             }
////             while(right>0 && right<nums2.length && nums2[right]==nums2[right-1])
////             {
////                 right++;
//
////             }
//            // if one array exhaust
//            if(left>= nums1.length || right>=nums2.length)
//            {
//                break;
//            }
//            //comparison
//            if(nums1[left]<nums2[right])
//            {
//                left++;
//
//            }
//            else if(nums1[left]>nums2[right])
//            {
//                right++;
//            }
//            else
//            {
//                intersection.add(nums1[left]);
//                left++;
//                right++;
//            }
//        }
//        int n=intersection.size();
//        int[] ans = new int[n];
//        for(int i=0;i<n;i++)
//        {
//            ans[i]=intersection.get(i);
//        }
//        return ans;
    }
}
