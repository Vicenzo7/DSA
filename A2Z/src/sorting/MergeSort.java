package sorting;

import java.util.Arrays;

public class MergeSort {
    /*
        Intuition:

        Merge Sort is a divide and conquers algorithm, it divides the given array into equal parts and then merges the 2 sorted parts.
        There are 2 main functions :
        merge(): This function is used to merge the 2 halves of the array. It assumes that both parts of the array are sorted and merges both of them.
        mergeSort(): This function divides the array into 2 parts. low to mid and mid+1 to high where,
         low = leftmost index of the array
         high = rightmost index of the array
         mid = Middle index of the array

        Time complexity: O(nlogn)

        Reason: At each step, we divide the whole array, for that logn and we assume n steps are taken to get a sorted array, so overall time complexity will be nlogn

        Space complexity: O(n)

        Reason: We are using a temporary array to store elements in sorted order.

        Auxiliary Space Complexity: O(n)
     */

    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return;

        int mid = low + (high - low) / 2;
        // sort left part
        mergeSort(nums, low, mid);
        //sort right part
        mergeSort(nums, mid + 1, high);
        // merge the two sorted array
        merge(nums, low, mid, high);

    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] first = Arrays.copyOfRange(nums, low, mid + 1);
        int[] second = Arrays.copyOfRange(nums, mid + 1, high + 1);

        int startOfMainIndex = low;
        int i = 0;
        int j = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                nums[startOfMainIndex++] = first[i++];
            } else {
                nums[startOfMainIndex++] = second[j++];
            }
        }

        while (i < first.length) {
            nums[startOfMainIndex++] = first[i++];
        }

        while (j < second.length) {
            nums[startOfMainIndex++] = second[j++];
        }
    }
}
