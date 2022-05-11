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
        int[] arr = {1,0,1,1,1};
        int target = 0;
        System.out.println(search(arr,target));

    }

    public static boolean search(int[] arr, int target) {
        int n=arr.length;
        int pivot=pivotIndexWithDuplicates(arr);
        System.out.println(pivot);

        // if you did not find a pivot,it means the array is not rotated
        if(pivot==-1){
            //just do normal Binary search
            return  binarySearch(arr,0, n-1,target);
        }


        //if pivot is found we have two ascending sorted arrays
        if(arr[pivot]==target)
            return true;


        if(arr[0]<= target && target<arr[pivot])
        {
            //Apply BS to second line
            return binarySearch(arr,0,pivot-1,target);
        }else{
            return binarySearch(arr,pivot+1,n-1,target);
        }
    }


    //Function to find pivot index.Here pivot is the greatest element
    //this will work for duplicates
    static int  pivotIndexWithDuplicates(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //4 cases
            if(mid<end && arr[mid]>arr[mid+1]) {
                return mid;
            }
            if(mid>0 && arr[mid]<arr[mid-1]) {
                return mid - 1;
            }

            // if elements at start,mid,end are equal skip the duplicates
            if(arr[mid]==arr[start] && arr[mid]==arr[end])
            {
                //skip the duplicates
                //NOTE: what if these elements at start and end were the pivots??
                //check if start is pivot
                if(arr[start]>arr[start+1])
                {
                    return start;
                }
                start++;

                //check if end is our pivot
                if(arr[end]<arr[end-1])
                {
                    return end-1;
                }
                end--;
            }
            //left side is sorted, so pivot should be in right
            else if(arr[start]<arr[mid] || (arr[start]==arr[mid] &&arr[mid]>arr[end])){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }


    //function for Binary Search
    static boolean binarySearch(int [] arr,int start,int end,int target)
    {
        int n= arr.length;
        while(start<=end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid]==target)
            {
                return true;
            }
            else if(arr[mid]<target)
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
