package Arrays;

import java.util.ArrayList;



public class Common3ArrayOptimized {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80, 80 };
        int[] arr2 = {6, 7, 20, 80, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 80, 120};

        ArrayList<Integer> result =findCommonOptimized(arr1,arr2,arr3);
        for(int a:result)
        {
            System.out.println(a+" ");
        }
    }


    public static boolean binarySearch(int[] arr,int element)
    {
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==element)
            {
                return true;
            }
            else if(arr[mid]>element)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return false;
    }


    public static ArrayList<Integer> findCommonOptimized(int[] arr1, int[] arr2, int[] arr3) {

        ArrayList<Integer> common = new ArrayList<>();
        for(int i=0;i<arr1.length;i++)
        {
            if(i>0 && arr1[i]==arr1[i-1])
            {
                continue;
            }

            if(binarySearch(arr2, arr1[i]) &&  binarySearch(arr3, arr1[i]))
            {

                common.add(arr1[i]);
            }
        }

        return common;
    }
}
