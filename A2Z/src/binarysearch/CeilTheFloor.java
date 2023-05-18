package binarysearch;

import java.util.Arrays;

public class CeilTheFloor {
    public static void main(String[] args) {
        int X = 42;
        int[] nums = {85, 24, 40, 10, 66, 16, 6, 54, 93, 42, 6, 98, 49, 100, 98, 23, 59, 48, 17, 56, 64, 94, 77};

        Pair floorAndCeil = getFloorAndCeil(nums, X);
        System.out.println(floorAndCeil.floor + "-" + floorAndCeil.ceil);
    }

    /*
        Solution
        First sort the array and then apply binary search to find the floor and ceil

        Steps to find the floor
        1. Take variable result = -1
        2. If nums[mid] == X return nums[mid]
        3. If nums[mid] < X
            then check if nums[mid]> result, if true update and  store the nums[mid] in result;
            update low = mid+1
        4. If nums[mid] > X , then update high = mid-1
        5. return result;


        Steps to find the ceil
        1. Take variable result = Integer.MAX_Value
        2. If nums[mid] == X return nums[mid]
        3. If nums[mid] > X
            then check if nums[mid]< result ,if true update and  store the nums[mid] in result;
            update high = mid-1
        4. If nums[mid] < X , then update low = mid+1
        5. return result == Integer.MAX_VALUE ? -1 : result;

        TC = O( 2 * log(n))
    */

    public static Pair getFloorAndCeil(int[] nums, int x) {
        Arrays.sort(nums);
        int floor = getFloor(nums, 0, nums.length - 1, x);
        int ceil = getCeil(nums, 0, nums.length - 1, x);

        return new Pair(floor, ceil);


    }

    public static int getFloor(int[] nums, int low, int high, int x) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == x) {
                return nums[mid];
            } else if (nums[mid] < x) {
                if (nums[mid] > result) {
                    result = nums[mid];
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static int getCeil(int[] nums, int low, int high, int x) {
        int result = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == x) {
                return nums[mid];
            } else if (nums[mid] > x) {
                if (nums[mid] < result) {
                    result = nums[mid];
                }
                high = mid - 1;
            } else {
                low = mid + 1;

            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }


}

class Pair {
    int floor, ceil;

    public Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    public Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}