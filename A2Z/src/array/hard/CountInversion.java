package array.hard;

import java.util.Arrays;

public class CountInversion {
    public static void main(String[] args) {
        long[] nums = {468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312, 323};

//        System.out.println(inversionCount(nums));
        System.out.println(inversionCountOptimal(nums));
    }

    /*What is an inversion of an array? Definition: for all i & j < size of array, if i < j then,
     you have to find pair (A[i],A[j]) such that A[j] < A[i].

     Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
     If array is already sorted then the inversion count is 0.
     If an array is sorted in the reverse order then the inversion count is the maximum.
     Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     */

    /*
        Brute force
        Step1: Run first for loop from 0 to n-1
        Step2: Run second for loop from i+1 to n
        step3: Check if nums[j] < nums[i] , then increment the count

        TC = O(n^2)
    */
    public static long inversionCount(long[] nums) {
        long count = 0L;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
        Optimal approach using merge sort
        eg          [5,3,2,4,1]
                      /     \
               [5,3,2]      [4,1]
                 /\          /\
            [5,3]  [2]     [4]  [1]
             /\
           [5] [3]

        eg          [1,2,3,4,5]
                      /     \
               [2,3,5]      [1,4]
                 /\          /\
            [2,3]  [5]     [1]  [4]
             /\
           [3] [5]



            While doing merge sort we can count the inversion
            if nums[i] > nums[j] given i < j, then all the right elements from nums[i], in first array for an inversion pair with nums[j]

    */

    public static long inversionCountOptimal(long[] nums) {
        int low = 0, high = nums.length - 1;
        return mergeSort(nums, low, high);
    }

    private static long mergeSort(long[] nums, int low, int high) {
        long inversionCount = 0;
        if (high > low) {
            int mid = low + (high - low) / 2;

            inversionCount += mergeSort(nums, low, mid);
            inversionCount += mergeSort(nums, mid + 1, high);
            inversionCount += merge(nums, low, mid, high);
        }
        return inversionCount;
    }

    private static long merge(long[] nums, int low, int mid, int high) {
        long inversionCount = 0;
        long[] first = Arrays.copyOfRange(nums, low, mid + 1);
        long[] second = Arrays.copyOfRange(nums, mid + 1, high + 1);

        int index1 = 0, index2 = 0;
        int startOfMainIndex = low;

        while (index1 < first.length && index2 < second.length) {
            if (first[index1] <= second[index2]) {
                nums[startOfMainIndex++] = first[index1++];
            } else {
                nums[startOfMainIndex++] = second[index2++];
                // counting the inversion pair through formula
                // since the first array is sorted all the elements would form a pair with second[index2]
                // so to count the number of pair that can be formed, the second array starts from mid+1 and the element
                // from the first array which starts to form pair is at (low+index1), so the element between them is (mid+1) - (low+index1)
                // low +index1 because suppose the inversion count is at [4]  [1]  where 4 is at 3 and 1 is at 4 index

                inversionCount += (mid + 1) - (low + index1);
//                inversionCount += first.length-index1;
            }
        }

        while (index1 < first.length) {
            nums[startOfMainIndex++] = first[index1++];
        }

        while (index2 < second.length) {
            nums[startOfMainIndex++] = second[index2++];
        }

        return inversionCount;
    }
}
