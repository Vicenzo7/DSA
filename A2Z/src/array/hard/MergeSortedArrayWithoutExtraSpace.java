package array.hard;

import java.util.Arrays;

public class MergeSortedArrayWithoutExtraSpace {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
//        merge(nums1, m, nums2, n);
//        mergeOptimal1(nums1, m, nums2, n);
        mergeOptimal2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    /*
        Brute Force Approach
        1.Use extra array of size m+n
        2.Add both array elements to the extra array
        3.Sort the extra array
        4.Now fill back the given two array
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            nums[k++] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            nums[k++] = nums2[i];
        }
        Arrays.sort(nums);
        k = 0;
        for (int i = 0; i < m; i++) {
            nums1[i] = nums[k++];
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = nums[k++];
        }
    }

    /*
       Optimal Solution without using extra space
       Step1. Iterate the first array.
       Step2. Whenever we encounter that array1 element is > array2 elements,swap the elements
       Step3. Rearrange the elements of array2(sort the elements of array2 using insertion sort)
       Step4. Repeat the process.

       TC = O(m*n)
       SC = O(1)

     */
    public static void mergeOptimal1(int[] nums1, int m, int[] nums2, int n) {
        int i, k;
        for (i = 0; i < m; i++) {
            // take first element from arr1
            // compare it with first element of second array
            // if condition match, then swap
            if (nums1[i] >= nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
            }
            // then sort the second array
            // put the element in its correct position
            // so that next cycle can swap elements correctly
            int first = nums2[0];
            // Insertion sort is used

            for (k = 1; k < n && nums2[k] <= first; k++) {
                nums2[k - 1] = nums2[k];
            }
            nums2[k - 1] = first;
        }
        k = 0;
        while (i < m + n) {
            nums1[i++] = nums2[k++];
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    /*Solution 3: Gap method-

    Approach:

    Initially take the gap as (m+n)/2;
    Take as a pointer1 = 0 and pointer2 = gap.
    Run a loop from pointer1 &  pointer2 to  m+n and whenever arr[pointer2]<arr[pointer1], just swap those.
    After completion of the loop reduce the gap as gap=gap/2.
    Repeat the process until the gap>0.

    Time complexity: O(n+m)

    Space Complexity: O(1)
    */

    public static void mergeOptimal2(int[] nums1, int m, int[] nums2, int n) {
        int length = m+n;
        int gap = (int) Math.ceil(length/2.0);

        while(gap > 0) {
            int left = 0;
            int right = left+gap;
            while(right < length) {
                // comparing arr1 and arr2 elements
                if(left < m && right >= m) {
                    // right-m because right pointer is second array
                    swapIfGreater(nums1,nums2,left,right-m);
                } else if(left >= m) {// comparing arr2 and arr2 elements
                    // left-m and right-m  because both the pointer are in arr2
                    swapIfGreater(nums2,nums2,left-m,right-m);
                } else {
                    swapIfGreater(nums1,nums1,left,right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (int) Math.ceil(gap/2.0);
        }
    }

    private static void swapIfGreater(int[] nums1, int[] nums2, int index1, int index2) {
        if (nums1[index1] > nums2[index2]) {
            int temp = nums1[index1];
            nums1[index1] = nums2[index2];
            nums2[index2] = temp;
        }
    }
}
