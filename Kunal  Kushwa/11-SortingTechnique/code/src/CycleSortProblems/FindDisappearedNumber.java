package CycleSortProblems;
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindDisappearedNumber {

    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i=0;
        while(i<nums.length)
        {
            int correct = nums[i] -1;
            if(nums[i] != nums[correct])
            {
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            }else
            {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        
        // search for disappeared  numbers in the array
        for(int index=0;index<nums.length;index++)
        {
            if(nums[index]!= index+1)
            {
                ans.add(index+1);
            }
        }
        return ans;
    }
}