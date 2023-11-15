package twopointer;

import java.util.Arrays;

public class TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) left++;
            else if (numbers[left] + numbers[right] > target) right--;

            else if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
        }

        return new int[]{-1, -1};
    }
}
