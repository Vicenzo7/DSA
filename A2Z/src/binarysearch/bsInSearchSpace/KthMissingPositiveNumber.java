package binarysearch.bsInSearchSpace;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};
//        int k = 2;
//        int[] arr = {2, 3, 4, 7, 11};
//        int k = 5;
        int[] arr = {32, 59, 77};
        int k = 1;
        System.out.println(findKthPositive(arr, k));
        System.out.println(findKthPositiveOptimal(arr, k));
    }

    /*
        Brute force
        Array is sorted so, check if first element > k then k is the answer.
        Otherwise, iterate the array and check if element <= k, then increment k,
        the moment element is not <= k,  break of the loop and k will be your missing element

        TC = O(n).

        eg ; arr = {2, 3, 4, 7, 11};, k = 5
         2 <= 5
         5++ = 6
         3 <= 6
         6++ = 7
         4 <=  7
         7++ = 8
         7 <= 8
         8++ = 9
         11 <= 9 false -> 9 is the 5th missing element.
    */


    public static int findKthPositive(int[] arr, int k) {
        // since the array is sorted,check if first element is > k, then the missing element is k
//        if (arr[0] > k) return k;
        for (int i : arr) {
            if (i <= k) {
                k++;
            } else {
                break;
            }
        }

        return k;
    }

    /*
        Optimal approach, binary search
        Basically you are finding if the number-(index+1) is greater than k or not and,
        number-(index+1) indicates how many missing element we have in the left.
        If it's less than k then we move forward and if we get greater than or equal to k
        then we move back.
        If we cross the pointers i.e. low>high there it gets terminated and the index low points
        to that index which has missing elements greater than or equal to k in left.
        At last, we just add k with the low pointer and that's our missing kth positive number.

        Tc = O(log(n))

    */

    public static int findKthPositiveOptimal(int[] arr, int k) {
        if (arr[0] > k) return k;

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] - (mid + 1) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low + k;
    }
}
