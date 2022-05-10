/*
    Approach
    1- First find the pivot index
    This is done to get two points of one line

    2- check condition in which line your pivot lies
    3- according to that apply Binary Search
 */

package MediumBS;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,2};
        int target = 4;
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
        if(arr[pivot]<= target && target<=arr[n-1])
        {
            //Apply BS to second line
            return binarySearch(arr,pivot,n-1,target);
        }else{
            return binarySearch(arr,0,pivot-1,target);
        }
    }


    //Function to find pivot index
    static int pivotIndex(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= arr[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;// we can return end also
    }




    //Function to find pivot index here pivot will be 6
//    static int pivotIndex(int[] arr) {
//        int n = arr.length;
//        int start = 0;
//        int end = n - 1;
//
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            if(mid<end && arr[mid]>arr[mid+1])
//                return mid;
//            if(mid>0 && arr[mid]<arr[mid-1])
//                return mid-1;
//
//            if(arr[mid]>=arr[start])
//            {
//                start=mid+1;
//            }else
//                end=mid;
//        }
//        return start;// we can return end also
//    }



    //function for Binary Search
     static int binarySearch(int [] arr,int s,int e,int target)
     {
         int start=s;
         int end=e;
          while(start<=end)
          {
              int mid = start + (end - start) / 2;
              if(arr[mid]==target)
              {
                  return mid;
              }
              else if(arr[mid]<=target)
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
