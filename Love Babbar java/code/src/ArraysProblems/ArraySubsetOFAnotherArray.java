package ArraysProblems;

import java.util.Arrays;
import java.util.HashSet;

// to check array 2 is subset of another array
public class ArraySubsetOFAnotherArray {
    public static void main(String[] args) {
        int[] arr={11,1, 13, 21,3, 7};
        int [] arr2={11, 3, 7, 1};
        System.out.println(isArray2Subarry(arr,arr2));
    }

    private static boolean isArray2Subarry(int[] arr, int[] arr2) {
        int n= arr.length;
        int m=arr2.length;
//        int count=0;
//        if(m>n)
//        {
//            return false;
//        }
//        for (int i = 0; i <m ; i++) {
//            for (int j = 0; j <n ; j++) {
//                if(arr2[i]==arr[j])
//                {
//                    count++;
//                }
//            }
//        }
//        if(count==m)
//        {
//            return true;
//        }
//        return false;
//    }

    //approach 2: sorting and binary search

        //sorting array one
//        Arrays.sort(arr);
//        int count=0;
//        for (int i = 0; i < m; i++) {
//            if(binarySearch( arr,arr2[i]))
//            {
//                count++;
//            }
//        }
//
//        if(count==m)
//        {
//            return true;
//        }
//        return false;




        //Approach3: Hashing

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        System.out.println(set);

        for (int i = 0; i <m ; i++) {
            if(!set.contains(arr2[i]))
            {
                return false;
            }
        }
        return true;


















    }

//    private static boolean binarySearch(int[] arr, int ele) {
//        int n = arr.length;
//        int low=0,high=n-1;
//
//        while(low<=high)
//        {
//            int mid=(low+high)/2;
//            if(arr[mid]==ele)
//            {
//                return true;
//            }
//            else if(arr[mid]<ele)
//            {
//                low=mid+1;
//            }
//            else
//            {
//                high= mid-1;
//            }
//        }
//
//        return false;
//
//    }

}
