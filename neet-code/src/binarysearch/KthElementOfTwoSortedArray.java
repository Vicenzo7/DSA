package binarysearch;

public class KthElementOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {100, 112, 256, 349, 770};
        int[] nums2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;
        System.out.println(kthElement(nums1, nums2, k));
        System.out.println(kthElement(nums1, nums2, nums1.length, nums2.length, k));
    }

    private static long kthElement(int[] nums1, int[] nums2, int m, int n, int k) {

        if (m > n) {
            return kthElement(nums2, nums1, n, m, k);
        }

        /*
             A =  2 3 4 15  = 4
             B =  1 3 4 7 10 12  = 6

            Deciding what low should be
        ->  k  >  the largest array size
            if k = 7 then we can only take max 6 elements from the largest array,
            so if now low = 0 means we are not considering any element from the smallest array,
            doing this we won't get our 7th element

            so left = Math.max(0,k-n) = (0,7-6) = 1 so one element from the smallest array

            Deciding what high should be
        ->  k < the smallest array size
            if k = 3, then max element you can pick from the smallest array is 4 but that's wrong because
            k = 3,
            so right = Math.min(k,m)
        */
        int left = Math.max(0, k - n);
        int right = Math.min(k, m);

        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = k - cut1;

            int l1 = cut1 > 0 ? nums1[cut1 - 1] : Integer.MIN_VALUE;
            int r1 = cut1 < m ? nums1[cut1] : Integer.MAX_VALUE;
            int l2 = cut2 > 0 ? nums2[cut2 - 1] : Integer.MIN_VALUE;
            int r2 = cut2 < n ? nums2[cut2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }

        }

        return -1;
    }

    private static long kthElement(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0, counter = 0;
        int ans = 0;
        while (i < nums1.length && j < nums2.length) {
            if (counter == k) break;
            if (nums1[i] <= nums2[j]) {
                ans = nums1[i];
                i++;
            } else {
                ans = nums2[j];
                j++;
            }
            counter++;
        }

        if (counter != k) {
            // check which array exited
            if (i != nums1.length - 1) {
                ans = nums1[k - counter];
            } else {
                ans = nums2[k - counter];
            }
        }

        return ans;
    }
}
