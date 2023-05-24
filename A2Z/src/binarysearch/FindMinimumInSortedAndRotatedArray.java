package binarysearch;

public class FindMinimumInSortedAndRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 2, 3};
        System.out.println(findMin(nums));
        System.out.println(findMin2(nums));
    }

    /*
        Brute Force: Linear Search.

        Optimal Approach: Binary Search using pivotIndex
        What is a pivotElement and pivotIndex
        In a sorted and rotated array a pivot element is the greatest element

        eg 4,5,6,7,0,1,2

                7
              6   0
            5       1
          4          2
          SO here 7 is a pivot element,
          elements on left of pivot including pivot are sorted and elements right of pivot
          excluding pivot are sorted.

          Steps to find pivotIndex
          Use Binary Search
          step1: check if mid is pivotIndex, mid > end && nums[mid] > nums[mid+1], then return mid.
          step2: check if mid-1 is pivotIndex, mid > 0 && nums[mid-1] > nums[mid], then return mid-1.

          step3: if none of the above conditions meets, check where pivotElement can be
                    ie num[mid] >= nums[start] if this is true mid is on left line we move right
                    low = mid+1;
                    else mid is on right line we move left

          Steps to find minimum in sorted and rotated array
          Step1: find pivotIndex
          Step2: if pivotIndex == -1 , means the array is sorted but not rotated, so minimum is nums[0]
          step3: else minimum element is next to pivot ie: nums[pivotIndex+1]

          TC = O(log(n))

    */

    public static int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int pivotIndex = getPivotIndex(nums);

        if (pivotIndex == -1) {
            return nums[0];
        } else {
            return nums[pivotIndex + 1];
        }
    }

    private static int getPivotIndex(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1])
                return mid;

            if (mid > 0 && nums[mid - 1] > nums[mid])
                return mid - 1;

            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }



    /*
     Solution 2

     We can optimize the solution using binary search.
     Since the array is sorted we can see that even after rotation one part of the array will still remain sorted.

    For ex : {5,1,2,3,4} here 3,4 is sorted
    Ex : [4,5,6,7,0,1,2] left part is sorted from 4 to 7

    We take a left pointer, a right pointer, and a mid. So if the left side is sorted, then the leftmost element is the smallest in that part.
    So we update our minVal and check on the right side. If the right part is sorted then mid is going to be the smallest value for that part,
    we update the result as min(mid,minVal).

    To know which part is sorted, We can observe that while rotation we are bringing the largest element ahead, so if nums[mid]>=nums[left],
    i.e, if an element greater than it exists further in the array, then that part is sorted.

    */


    public static int findMin2(int[] nums) {
        if (nums.length == 1) return nums[0];

        int minValue = Integer.MAX_VALUE;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            // check if array sorted return nuns[low]
            if (nums[low] < nums[high]) {
                return Math.min(minValue, nums[low]);
            }

            int mid = low + (high - low) / 2;

            // check if left part is sorted, if left part is sorted then min for that part will be nums[low]
            if (nums[low] <= nums[mid]) {
                minValue = Math.min(minValue, nums[low]);
                low = mid + 1;
            } else { // if right part is sorted,then min for that part will be nums[mid]
                minValue = Math.min(minValue, nums[mid]);
                high = mid - 1;
            }
        }

        return minValue;
    }
}
