package sorting;

import java.util.Arrays;

public class QuickSort {
    /*Quick Sort is a divide-and-conquer algorithm like the Merge Sort. But unlike Merge sort, this algorithm does not use any extra array for sorting(though it uses an auxiliary stack space). So, from that perspective, Quick sort is slightly better than Merge sort.

    This algorithm is basically a repetition of two simple steps that are the following:

    Pick a pivot and place it in its correct place in the sorted array.
    Shift smaller elements(i.e. Smaller than the pivot) on the left of the pivot and larger ones to the right.

    Time Complexity: O(N*logN), where N = size of the array.

    Reason: At each step, we divide the whole array, for that logN and n steps are taken for the partition() function, so overall time complexity will be N*logN.

    The following recurrence relation can be written for Quick sort :

    F(n) = F(k) + F(n-1-k)

    Here k is the number of elements smaller or equal to the pivot and n-1-k denotes elements greater than the pivot.

    There can be 2 cases :

    Worst Case – This case occurs when the pivot is the greatest or smallest element of the array. If the partition is done and the last element is the pivot, then the worst case would be either in the increasing order of the array or in the decreasing order of the array.

    Recurrence:
    F(n) = F(0)+F(n-1)  or  F(n) = F(n-1) + F(0)

    Worst Case Time complexity: O(n2)

    Best Case – This case occurs when the pivot is the middle element or near to middle element of the array.
    Recurrence :
    F(n) = 2F(n/2)

    Time Complexity for the best and average case: O(N*logN)

    Space Complexity: O(1) + O(N) auxiliary stack space.

    */

    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int pivotIndex = partition(nums, start, end);

        quickSort(nums, start, pivotIndex - 1);

        quickSort(nums, pivotIndex + 1, end);

    }

    private static int partition(int[] nums, int start, int end) {
        int pivotElement = nums[start];
        // count all numbers slower than him;
        int count = 0;
        for (int i = start+1; i <= end; i++) {
            if (nums[i] <= pivotElement) {
                count++;
            }
        }

        int pivotIndex = start + count;
        // place the pivot at its right position
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[start];
        nums[start] = temp;

        // now before pivotElement all element should be less and after it, they should be greater in any order
        int i = start;
        int j = end;

        while (i < pivotIndex && j > pivotIndex) {
            while (nums[i] <= pivotElement) {
                i++;
            }

            while (nums[j] > pivotElement) {
                j--;
            }

            if (i < pivotIndex && j > pivotIndex) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }


        return pivotIndex;


    }
}
