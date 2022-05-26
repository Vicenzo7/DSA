package CycleSortProblems;
//https://leetcode.com/problems/set-mismatch/
import java.util.Arrays;

class SetMismatch {

    public static void main(String[] args) {
        int[] nums= {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }



    public static int[] findErrorNums(int[] nums) {
      
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
        
        // search for disappeared  numbers in the array
        for(int index=0;index<nums.length;index++)
        {
            if(nums[index]!= index+1)
            {
                return new int[]{nums[index],index+1};
            }
        }
        return new int[]{-1,-1};
    
    }
}