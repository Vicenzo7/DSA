package EasyBS;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        int[] result= intersection(nums1,nums2);
        for(int x:result)
        {
            System.out.println(x+" ");
        }

    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set= new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            set.add(nums1[i]);
        }
        System.out.println(set);

        for(int i=0;i<nums2.length;i++)
        {
            if(set.contains(nums2[i]))
            {
                list.add(nums2[i]);
                //removing so we don't add duplicates in list
                set.remove(nums2[i]);
            }
        }

        int n= list.size();
        int[] ans =new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=list.get(i);
        }
        return ans;




        //using binary search
//        Arrays.sort(nums1);
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums2.length ; i++) {
//            if(binarySearch(nums1,nums2[i]))
//            {
//                set.add(nums2[i]);
//            }
//        }
//
//        int n=set.size();
//        int i=0;
//        int[] ans= new int[n];
//        for (int x:set) {
//            ans[i++]=x;
//        }
//        return ans;
    }

    private static boolean binarySearch(int[] nums1, int target) {
        int start=0;
        int end=nums1.length-1;
        while(start<=end)
        {
            int mid= start+(end-start)/2;
            if(nums1[mid]==target)
            {
                return true;
            }
            else if(nums1[mid]<target)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return false;
    }
}
