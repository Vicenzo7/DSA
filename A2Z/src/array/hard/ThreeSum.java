package array.hard;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0, 0};
        System.out.println(threeSum(nums));
        System.out.println(threeSumOptimal(nums));
        int N = 5, X = 10;
        int[] A = {1, 2, 3, 4, -5};
        System.out.println(closest3Sum(A, N, X));
    }

    /*Brute Force

    Run three loop and check if the triplets are summing up to zero
    1st loop from i = 0 to nums.length -2
    2nd loop from j = i+1  to nums.length -1
    3rd loop from k = j+1 to nums.length

    if nums[i] + nums[j] +nums[k] == 0,add them to result

    TC = O(n^3)
    SC = (3*k) k is number of triplets
    */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

   /* Optimal Approach

    Since we want distinct triplets one thing we can do is sort the array and skip the duplicates.
    We run a for loop from i = 0 to nums.length -2;
    Now we skip the duplicates, if nums[i] == nums[i-1], then continue, we move skip that iteration.
    Then we take two pointers start = i+1 and end = nums.length -1;
    we then iterate inside a while loop till start < end
    we check if nums[i] + nums[start] + nums[end] = sum == 0
    if zero add to the list and decrement end--, since we skipped duplicates from the front now skip duplicates from the back
    while start < end and nums[end] == nums[end+1] => end--

    if sum != 0 and sum < 0 -> start++;
    else end--;

    TC = O(n^2) + O(nlog(n))
        = O(n^2)

    The time complexity of the given code is O(n^2), where "n" is the length of the input array "nums".
    This is because there are two nested loops, and the inner loop is bounded by the remaining array elements after the outer loop index "i" is selected.
    The sorting step takes O(n*log(n)) time in the worst case, but since it is a one-time operation and the subsequent nested loops dominate the time complexity,
    we can ignore it and consider the overall time complexity as O(n^2).

    SC = O(3*k) k is number of distinct triplets
    The space complexity of the given code is O(1), because the memory usage does not depend on the input size. The code uses a constant amount of memory to store the loop indices and temporary variables, and the output list is returned as the final result.


   * */

    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // sorting the array since we need to skip duplicates
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // skipping the duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            while (start < end) {

                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    end--;
                    // skipping the duplicates from the end
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < 0) { // if the sum < 0 we move start forward in search to make  sum zero
                    start++;
                } else { // if sum > 0 we decrement end in search to make sum 0
                    end--;
                }
            }
        }
        return result;
    }


    // Geeks for geeks Version
    // https://practice.geeksforgeeks.org/problems/3-sum-closest/1
    // A triplet sum that is closet to X
    /**
     Sort the array and then iterate the array, use two pointer approach to find the triplet,
     if the sum of the triplet is equal to X return the sum.If not equal but sum < X, increment the start else decrement
     the end;
     But for each triplet find the closest

     if X = 1 then -3 and 3 have same distance from positive and negative side so better to keep track of positive
     if (Math.abs(sum -x) < minimum) where minimum = Math.MAX_VALUE
     minimum = Math.abs(sum-x) and closest = sum

     TC = O(n^2) 
     */
    public static int closest3Sum(int[] nums, int N, int X) {

        int closest = 0, minimum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // two pointer approach
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == X) {
                    return sum;
                } else if (sum < X) {
                    start++;
                } else {
                    end--;
                }

                if (Math.abs(sum - X) < minimum) {
                    // sum -x is the distance from x
                    minimum = Math.abs(sum - X);
                    closest = sum;
                }
            }
        }
        return closest;
    }
}
