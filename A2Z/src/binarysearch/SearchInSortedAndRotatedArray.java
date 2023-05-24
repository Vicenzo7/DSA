package binarysearch;

import java.util.Arrays;

public class SearchInSortedAndRotatedArray {
    public static void main(String[] args) {
        int[] nums = {6, 7, 1, 2, 3, 4, 5};
        int target = 7;
        System.out.println(search(nums, target));
        int ans = usingPivotIndex(nums, target);
        System.out.println(ans < 0 ? -1 : ans);
    }



    /*Approach :

    We divide the array into parts. It is done using two pointers, low and high, and dividing the range between them by 2.
    This gives the midpoint of the range. Check if the target is present in the midpoint, calculated before, of the array.
    If not present, check if the left half of the array is sorted.
    This implies that binary search can be applied in the left half of the array provided the target lies between the value range.
    Else check into the right half of the array. Repeat the above steps until low <= high.
     If low > high indicates, we have searched the array, and the target is not present hence return -1.
    Thus, it makes search operations less as we check the range first and then perform searching in possible ranges which may have target values.*/

    public static int search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid; // if the target is found at mid,return it

            // check if the left part is sorted
            if (nums[low] <= nums[mid]) {
                // now check if target can lie in this range
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;  // this mean target lies with the left part, so we move to the left part
                } else {
                    low = mid + 1; // doesn't lie in the left part, so we move to the right part
                }
            } else {  // the right part is sorted
                // now check if target can lie in this range
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // this mean target lies with the right part, so we move to the right part
                } else {
                    high = mid - 1;  // doesn't lie in the right part, so we move to the left part
                }
            }
        }

        return -1;
    }

        /*
        Another solution is to find the pivot index.
        Pivot Index is an index which has an element from which the array is rotated

        If the pivot Index doesn't exist, that means the array is not rotated, so we can do a regular BinarySearch

        If Pivot exists, check if pivotElement == target, than return pivotElement.
        Else check if target lies in a left part array from 0 to pivotElement, if yes do BS in left part.
        Else check if target lies in a right part array from pivotIndex to nums.length, if yes do BS in the right part.

    */


    public static int findPivotIndex(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 4 cases
            // check if mid is a pivotIndex
            if (mid < high && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // check if mid -1 is a pivot
            if (mid > 0 && nums[mid - 1] > nums[mid])
                return mid - 1;

            // if one left line, go towards right
            if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else { // if on right line go towards left
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int usingPivotIndex(int[] nums, int target) {
        int ans = -1;
        int pivotIndex = findPivotIndex(nums);
        if (pivotIndex == -1) {
            return Arrays.binarySearch(nums, target);
        }

        if (nums[pivotIndex] == target) return pivotIndex;

        if (nums[0] <= target && target < nums[pivotIndex]) {
            return Arrays.binarySearch(nums, 0, pivotIndex, target);
        } else {
            return Arrays.binarySearch(nums, pivotIndex + 1, nums.length, target);
        }
    }

}
