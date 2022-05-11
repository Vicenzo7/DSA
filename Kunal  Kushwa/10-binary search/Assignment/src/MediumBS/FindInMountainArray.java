package MediumBS;

//https://leetcode.com/problems/find-in-mountain-array/
public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        int target = 3;
        int peak = peakIndexInMountainArray(arr);
        int firstTry=orderAgnosticBinarySearch(arr, 0, peak, target);
        //if not found in ascending part of the array,search in descending part of array
        if(firstTry==-1){
            firstTry=orderAgnosticBinarySearch(arr, peak, arr.length-1, target);
        }

        System.out.println(firstTry);
    }


    static int orderAgnosticBinarySearch(int[] arr, int start, int end, int target) {

        boolean isAsec = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }


            if (isAsec) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }else{
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // mid is on left line so move right to reach peak;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                // mid is on right line so move left to reach peak;
                end = mid - 1;
            }
        }
        return start;
    }

}
