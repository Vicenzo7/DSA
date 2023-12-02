package binarysearch;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] merged = new int[nums1.length + nums2.length];
//        int i = 0, j = 0, k = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] <= nums2[j]) {
//                merged[k++] = nums1[i];
//                i++;
//            } else {
//                merged[k++] = nums2[j];
//                j++;
//            }
//        }
//        while (i < nums1.length) {
//            merged[k++] = nums1[i];
//            i++;
//        }
//
//        while (j < nums2.length) {
//            merged[k++] = nums2[j];
//            j++;
//        }
//
//        int mid = merged.length / 2;
//        if (merged.length % 2 == 0) {
//            return (merged[mid - 1] + merged[mid]) / 2.0;
//        } else {
//            return merged[mid];
//        }
//    }


    // 1 1 2 2 3 3 4 4 5 5 6 7 8
    // 1 2 3 4 5
    // 1 2 3 4 5 6 7 8

    // left side        right side
    // 1 2           // 3 4 5
    // 1 2 3 4          //4 5 6 7 8
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        int half = (total) / 2;
        double result = 0;
        int left = 0, right = m;

        while (left <= right) {
            int cut1 = left + (right - left) / 2; // number of elements taken from the smallest array
            int cut2 = half - cut1;  // number of elements taken from the largest array

            int l1 = cut1 > 0 ? nums1[cut1 - 1] : Integer.MIN_VALUE; // if cut1 = 0 there is no position for l1 so assign min
            int r1 = cut1 < m ? nums1[cut1] : Integer.MAX_VALUE;     // if cut1 = n there is no position for l1 so assign max
            int l2 = cut2 > 0 ? nums2[cut2 - 1] : Integer.MIN_VALUE;  // if cut2 = 0 there is no position for l2 so assign min
            int r2 = cut2 < n ? nums2[cut2] : Integer.MAX_VALUE;      // if cut1 = m there is no position for l2 so assign max

            // partition is correct
            if (l1 <= r2 && l2 <= r1) {
                if (total % 2 == 0) { // even
                    result = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else { // odd
                    result = Math.min(r1, r2);
                }
                break;
            }
            // partition is wrong update left/right pointer
            else if (l1 > r2) {
                right = cut1 - 1; // we need to reduce number of elements of the smallest array
            } else {
                left = cut1 + 1; // we need to reduce number of elements of the largest array
            }

        }
        return result;
    }
}
