package MediumBS;

public class FindTheRotationCountInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int n=arr.length;
        System.out.println(findKRotation(arr,n));
    }

    static int findKRotation(int arr[], int n) {

        //if array is of single length
        if (n == 1) {
            return 0;
        }

        int start = 0;
        int end = n - 1;
        //checking if array is rotated
        if (arr[start] < arr[end]) {
            return 0;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            }

            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
