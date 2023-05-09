package array.hard;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 1};
        System.out.println(reversePairs(nums));
        System.out.println(reversePairsOptimal(nums));
    }

    /*
        Brute force
        Step1: Run a for loop from i = 0 to n-1
        Step2: Run another for loop from j = 0 to n
        step3: Check if nums[i] > 2* nums[j], then increase the count
        step4: Return the count

        TC = O(n^2)
        SC = O(1)
    */

    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
        Optimal solution : Using merge sort algo
        We are going to count the reverse pairs when we are merging the  left and right array

        Steps to count reverse pair
        step1: we will take two pointers to traverse the first and second
               ie i = low and j = mid+1
               start of second array is mid+1
        step2: run a loop from i = low to mid  -> ie this loop is to iterate the first array
        step3: Inside the for loop run a while loop (j <= high && nums[i] > 2 * nums[j])
               if these conditions are meet increment the j pointer

        step4: If these condition fail, lets count the reverse pairs, that can be formed with element present in first
               array present at  ith index
               count += j - (mid+1)
                        ie To count how many element form a reverse pair with element present at ith index in first array
        step5 : Merge the array



        TC = O(nlog(n)) + O(n) + O(n)
            merge sort    merge   count the reverse pair
     */


    public static int reversePairsOptimal(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int reversePairCount = mergeSort(nums, low, mid);
        reversePairCount += mergeSort(nums, mid + 1, high);
        reversePairCount += merge(nums, low, mid, high);

        return reversePairCount;
    }

    private static int merge(int[] nums, int low, int mid, int high) {
        int reversePairCount = 0;

        int[] first = Arrays.copyOfRange(nums, low, mid + 1);
        int[] second = Arrays.copyOfRange(nums, mid + 1, high + 1);

        int j = 0;
        for (int i = 0; i < first.length; i++) {
            while (j < second.length && first[i] > (2 * (long) second[j])) {
                j++;
            }
            reversePairCount += j;
        }

        // alternate way to do the above without using the first and second array
//        int j = mid+1; // start of imaginary second index
//        for (int i = low; i <= mid; i++) {
//            while (j <= high && nums[i] > (2 * (long) nums[j])) {
//                j++;
//            }
//            reversePairCount += j - (mid+1);
//        }


        int index1 = 0, index2 = 0, startOfMainIndex = low;
        while (index1 < first.length && index2 < second.length) {
            if (first[index1] < second[index2]) {
                nums[startOfMainIndex++] = first[index1++];
            } else {
                nums[startOfMainIndex++] = second[index2++];
            }
        }

        while (index1 < first.length) {
            nums[startOfMainIndex++] = first[index1++];
        }

        while (index2 < second.length) {
            nums[startOfMainIndex++] = second[index2++];
        }

        return reversePairCount;
    }
}
