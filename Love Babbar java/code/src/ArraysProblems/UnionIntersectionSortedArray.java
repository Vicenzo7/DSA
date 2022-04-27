package ArraysProblems;

import java.util.ArrayList;

public class UnionIntersectionSortedArray {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5};
        int[] arr2 = {1,2,3};
        union(arr1,arr2);
        intersection(arr1,arr2);

    }

    private static void union(int[] arr1, int[] arr2) {
        int left=0,right=0;
        ArrayList<Integer> union= new ArrayList<>();
        while(left< arr1.length || right<arr2.length)
        {
            //skip duplicates
            while(left>0 && left<arr1.length && arr1[left]==arr1[left-1])
            {
                left++;
            }
            while(right>0 && right<arr2.length && arr2[right]==arr2[right-1])
            {
                right++;
            }
            //if one array exhausts
            if(left>=arr1.length)
            {
                union.add(arr2[right++]);
                continue;
            }
            if(right>=arr2.length)
            {
                union.add(arr1[left++]);
                continue;
            }

            //comparison
            if(arr1[left]<arr2[right])
            {
                union.add(arr1[left++]);
            }
            else if(arr1[left]>arr2[right])
            {
                union.add(arr2[right++]);
            }
            else
            {
                union.add(arr1[left]);
                left++;
                right++;
            }
        }
        System.out.println("The union elements are:");
        System.out.println(union);
        System.out.println(union.size());
    }

    private static void intersection(int[] arr1, int[] arr2) {
        int left=0,right=0;
        ArrayList<Integer> intersection= new ArrayList<>();

        while(left<arr1.length && right<arr2.length)
        {
            //skip duplicates
            while(left>0 && left<arr1.length && arr1[left]==arr1[left-1])
            {
                left++;

            }
            while(right>0 && right<arr2.length && arr2[right]==arr2[right-1])
            {
                right++;

            }
            // if one array exhaust
            if(left>= arr1.length || right>=arr2.length)
            {
                break;
            }
            //comparison
            if(arr1[left]<arr2[right])
            {
                left++;

            }
            else if(arr1[left]>arr2[right])
            {
                right++;
            }
            else
            {
                intersection.add(arr1[left]);
                left++;
                right++;
            }


        }
        System.out.println("The union elements are:");
        System.out.println(intersection);
    }


    //we can store values in HashSet so duplicates aren't stored


}

