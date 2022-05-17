package MediumBS;

import java.util.Arrays;

//https://leetcode.com/problems/frequency-of-the-most-frequent-element/
public class FrequencyoftheMostFrequentElement {
    public static void main(String[] args) {
        int[]  nums = {1,4,8,13};
        int k = 5;
        System.out.println(maxFrequency(nums,k));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0,right =0;
        long result =0;
        long total=0;

        while(right<nums.length)
        {
            total +=nums[right];
            //right -left +1 == window Size
            while(nums[right]*(right-left+1) > total+k)
            {
                total -= nums[left];
                left++;
            }
            result=Math.max(result,(right-left+1));
            right++;
        }
        return (int)result;
    }
}
