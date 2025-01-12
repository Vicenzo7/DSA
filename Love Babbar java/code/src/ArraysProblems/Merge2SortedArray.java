package ArraysProblems;

public class Merge2SortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        mergeArray(nums1, nums2, m, n);
    }

    private static void mergeArray(int[] nums1, int[] nums2, int m, int n) {

        int[] nums3 = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }

        while (i < m) {
            nums3[k++] = nums1[i++];
        }

        while (j < n) {
            nums3[k++] = nums2[j++];
        }


        for (int a : nums3) {
            System.out.print(a + " ");
        }
    }
}
