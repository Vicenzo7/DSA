/*
    Approach
    1- First find the pivot index
    This is done to get two points of one line

    2- check condition in which line your pivot lies
    3- according to that apply Binary Search
 */

package Problems;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int ans=search(arr,target);
        if(ans==-1)
        {
            System.out.println("Target not found");
        }else {
            System.out.println("Target at index " + ans);
        }
    }

    public static int search(int[] arr,int target) {
        int n=arr.length;
        int pivot=pivotIndex(arr);
        System.out.println(pivot);

        // if you did not find a pivot,it means the array is not rotated
        if(pivot==-1){
            //just do normal Binary search
            return  binarySearch(arr,0, n-1,target);
        }


        //if pivot is found we have two ascending sorted arrays
        //3 cases
        if(arr[pivot]==target)
            return pivot;


        if(arr[0]<= target && target<arr[pivot])
        {
            //Apply BS to second line
            return binarySearch(arr,0,pivot,target);
        }else{
            return binarySearch(arr,pivot+1,n-1,target);
        }
    }


    //Function to find pivot index here pivot will be 6
    //this will not work for duplicates values
    static int pivotIndex(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //4 cases
            if(mid<end && arr[mid]>arr[mid+1])
                return mid;
            if(mid>0 && arr[mid]<arr[mid-1])
                return mid-1;

            if(arr[mid]>=arr[start])
            {
                start=mid+1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }


    static int pivotIndexWithduplicates(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //4 cases
            if(mid<end && arr[mid]>arr[mid+1])
                return mid;
            if(mid>0 && arr[mid]<arr[mid-1])
                return mid-1;

            // if elements at middle,start,end are equal then just skip the duplicates
            if(arr[mid]==arr[start] && arr[mid]==arr[end])
            {
                //skipp the duplicates
                //NOTE: what if these elements at start and end were pivot??
                //check if start is pivot
                if(arr[start]>arr[start+1])
                {
                    return start;
                }
                start++;

                //check if end is pivot
                if(arr[end]<arr[end-1])
                {
                    return end -1;
                }
                end--;
            }
            //left side is sorted,so pivot should be in right
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
     static int binarySearch(int [] arr,int start,int end,int target)
     {

          while(start<=end)
          {
              int mid = start + (end - start) / 2;
              if(arr[mid]==target)
              {
                  return mid;
              }
              else if(arr[mid]<target)
              {
                  start= mid+1;
              }
              else{
                  end=mid-1;
              }
          }
          return -1;
     }



}
