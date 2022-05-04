package BinarySearch;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr={24,69,100,99,79,78,67,36,26,19};
        int result=peakIndexInMountainArray(arr);
        System.out.println(result);
    }

    private static int peakIndexInMountainArray(int[] arr) {
        //brute force approach
//        int n=arr.length;
//        int count=0;
//        for (int i = 0; i < n-1; i++) {
//            if(arr[i]<arr[i+1])
//            {
//                count++;
//            }
//        }
//        return count;



        //using binary search
        int n= arr.length;
        int start=0;
        int end=n-1;
        while(start<end)
        {
            int mid =start +(end-start)/2;
            if(arr[mid]<arr[mid+1])
            {
                start=mid+1;
            }
            else //arr[mid]<arr[mid+1]
            {
                end=mid;
            }
        }
        return start;
    }
}
