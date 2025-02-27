package company.pharmeasy;

import java.util.PriorityQueue;

public class PharEasyTest1 {

    /*

     Given an array of non-negative integers representing an elevation map where the width of each bar is 1,
     compute how much water it can trap after raining.

    Examples:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The elevation map can trap 6 units of rainwater.

    Input: height = [4,2,0,3,2,5]
    Output: 9



    */


    public static void main(String[] args) {
//        firstQuestion();
//        secondQuestion();
        thirdQuestion();

    }


    private static void firstQuestion() {
        int[] nums = {4, 2, 0, 3, 2, 5};
        System.out.println(findTotalWaterTrapped2(nums));
    }

    private static int findTotalWaterTrapped(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];

        int maxLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            leftMax[i] = maxLeft;
            maxLeft = Math.max(maxLeft, nums[i]);
        }

        int maxRight = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightMax[i] = maxRight;
            maxRight = Math.max(maxRight, nums[i]);
        }

        int totalWaterStored = 0;
        for (int i = 0; i < nums.length; i++) {
            int waterTrapped = Math.min(leftMax[i], rightMax[i]) - nums[i];
            if (waterTrapped > 0) {
                totalWaterStored += waterTrapped;
            }
        }
        return totalWaterStored;
    }


    private static int findTotalWaterTrapped2(int[] nums) {
        int left = 0, right = nums.length - 1;
        int leftMax = nums[left], rightMax = nums[right];

        int totalWaterStored = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, nums[left]);
                totalWaterStored += leftMax - nums[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, nums[right]);
                totalWaterStored += rightMax - nums[right];
            }
        }

        return totalWaterStored;
    }


    /*

        You are given an array of rope lengths. The cost of connecting two ropes is the sum of their lengths.
        Your goal is to minimize the total cost of connecting all ropes into one.
        ropes = [4, 3, 2, 6]
        output=29

        3+2 = 5 [4,5,6]
        4+5=9 [6,9]
        6+9=15
        5+9+15 = 29

    */

    private static void secondQuestion() {
        int[] nums = {4, 3, 2, 6};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
        }

        int minCost = 0;
        while (minHeap.size() > 1) {
            Integer a = minHeap.poll();
            Integer b = minHeap.poll();

            int sum = a + b;
            minCost += sum;
            minHeap.offer(sum);
        }

        System.out.println("Minimum Cost is " + minCost);
    }


    /*
        You are given an array of integers nums sorted in non-decreasing order.
        Your task is to find the starting and ending position of a given target value.
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]
        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]
    */

    private static void thirdQuestion() {
        int[] nums = {5, 7, 7, 7, 8, 8, 10};
        int target = 7;

        int start = 0;
        int end = nums.length - 1;

        int leftIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                leftIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = nums.length - 1;
        int rightIndex = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                rightIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println("Left Index " + leftIndex);
        System.out.println("Right Index " + rightIndex);
    }


}
