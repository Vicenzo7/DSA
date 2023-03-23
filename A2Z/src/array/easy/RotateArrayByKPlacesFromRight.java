package array.easy;
// https://practice.geeksforgeeks.org/problems/reversal-algorithm5340/1

import java.util.Arrays;

public class RotateArrayByKPlacesFromRight {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
//        rotateBruteForce(nums, k);
        rotate(nums, k);
    }

    //optimised
    private static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    private static void rotateBruteForce(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        int[] temp = new int[k];
        for (int i = n-k; i < n; i++) {
            temp[i-n+k] = nums[i];
        }
        for (int i = n-k-1; i >=0 ; i--) {
            nums[i+k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i]= temp[i];
        }

        System.out.println(Arrays.toString(nums));
    }
}
