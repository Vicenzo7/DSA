package Problems;
//https://leetcode.com/problems/first-missing-positive/submissions/
public class  FirstMissingPositive{


    public static void main(String[] args) {
        int[] nums={3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length)
        {
            int correct= nums[i]-1;
            if(nums[i] > 0 && nums[i] <= nums.length &&  nums[i] != nums[correct])
            {
                int temp= nums[correct];
                nums[correct]=nums[i];
                nums[i]=temp;
            }
            else{
                i++;
            }
        }
        

        
        for(int index=0;index<nums.length;index++)
        {
            if(nums[index]!= index+1)
            {
              return index+1;
            }
        }
        return nums.length+1;
    }
}