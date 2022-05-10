package MediumBS;

/**
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {2,2,2,3,2,2,2};
        int target = 3;
        System.out.println(search(arr,target));

    }

    public static boolean search(int[] arr,int target) {
        int n=arr.length;
        int pivot=pivotIndex(arr);
        System.out.println(pivot);
        if(arr[pivot]<= target && target<=arr[n-1])
        {
            //Apply BS to second line
            return binarySearch(arr,pivot,n-1,target);
        }else{
            return binarySearch(arr,0,pivot-1,target);
        }
    }

    static int pivotIndex(int[] arr) {
//        int n = arr.length;
//        int start = 0;
//        int end = n - 1;
//
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] >= arr[0]) {
//                start = mid+1 ;
//            } else {
//                end = mid;
//            }
//        }
//        return start;// we can return end also


        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            //if mid is greater than mid+1(next of mid) than mid is pivot
            if (mid<end && arr[mid]>arr[mid+1]) {
                return mid;
            }
            //if mid is less than mid-1(previous of mid) than mid is pivot
            if (mid>0 && arr[mid]<arr[mid-1]) {
                return mid-1;
            }

            if(arr[mid]>=arr[start])
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }

        }
        return start;
    }

    //function for Binary Search
    static boolean binarySearch(int [] arr,int s,int e,int target)
    {
        int start=s;
        int end=e;
        while(start<=end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid]==target)
            {
                return true;
            }
            else if(arr[mid]<=target)
            {
                start= mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }
}
