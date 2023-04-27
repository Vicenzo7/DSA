package array.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/majority-element-ii/
public class MajorityElement2 {
    public static void main(String[] args) {
//        Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
        int[] nums = {11, 33, 33, 11, 33, 11};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementOptimal(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequencyCountMap = new HashMap<>();
        for (int num : nums) {
            frequencyCountMap.put(num, frequencyCountMap.getOrDefault(num, 0) + 1);
        }

        for (int num : frequencyCountMap.keySet()) {
            if (frequencyCountMap.get(num) > nums.length / 3) {
                result.add(num);
            }
        }
        return result;
    }

   /* Solution 3: Optimal Solution (Extended Boyer Moore’s Voting Algorithm)

    Approach + Intuition: In our code, we start by declaring a few variables:

    num1 and num2 will store our current most frequent and second most frequent elements.
    c1 and c2 will store their frequency relative to other numbers.
    We are sure that there will be a max of 2 elements that occurs > N/3 times because there cannot be if you do a simple math addition.
    Let, ele be the element present in the array at any index.

    if ele == num1, so we increment c1.
    if ele == num2, so we increment c2.
    if c1 is 0, so we assign num1 = ele, and c1 = 1 .
    if c2 is 0, so we assign num2 = ele, and c2 = 1.
    In all the other cases we decrease both c1 and c2.
    In the last step, we will run a loop to check if num1 or nums2 are the majority elements or not by running a for loop check.

    Intuition: Since it’s guaranteed that a number can be a majority element, hence it will always be present at the last block, hence, in turn, will be on nums1 and nums2. For a more detailed explanation, please watch the video below.
    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public static List<Integer> majorityElementOptimal(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;
        for (int element : nums) {
            if (element == num1) {
                count1++;
            } else if (element == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = element;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = element;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int element : nums) {
            if (element == num1) {
                count1++;
            } else if (element == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(num1);
        }
        if (count2 > nums.length / 3) {
            result.add(num2);
        }

        return result;
    }


}
