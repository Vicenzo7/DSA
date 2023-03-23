package array.easy;
//https://leetcode.com/problems/rotate-array/description/
//https://practice.geeksforgeeks.org/problems/quick-left-rotation3806/1
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
//        rotate(nums, k);
//        rotateBruteForce(nums, k);
        rotateOptimised(nums, k);

    }

    public static void rotate(int[] nums, int k) {
        Queue<Integer> que = new LinkedList<>();

        for (int num : nums) {
            que.add(num);
        }

        for (int i = 0; i < k; i++) {
            que.add(que.remove());
        }
        for (int i = 0; i < nums.length; i++) {
            int element = que.remove();
            nums[i] = element;
        }

        System.out.println(que);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotateBruteForce(int[] nums, int k) {
        int lastIndex = nums.length - 1;

        for (int i = 0; i < k; i++) {
            int element = nums[0];
            for (int j = 1; j < nums.length; j++) {
                nums[j - 1] = nums[j];
            }
            nums[lastIndex] = element;
            System.out.println(Arrays.toString(nums) + "Array after " + i + 1 + " rotation");
        }

        System.out.println(Arrays.toString(nums));
    }

    // first element goes at the back

    public static void rotateOptimised(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        flip(nums, 0, n - 1);
        flip(nums, 0, k - 1);
        flip(nums, k, n - 1);
        System.out.println(Arrays.toString(nums));
    }


    // last element comes in the front
//    public static void leftRotate(long arr[], int k, int n) {
//        if (k > n) {
//            k = k % n;
//        }
//        flip(arr, 0, k - 1);
//        flip(arr, k, n - 1);
//        flip(arr, 0, n - 1);
//
//    }

    public static void flip(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
