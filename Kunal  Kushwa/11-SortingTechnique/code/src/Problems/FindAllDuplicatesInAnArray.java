package Problems;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/
import java.util.ArrayList;
import java.util.List;

class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
    public static List<Integer> findDuplicates(int[] nums) {
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

        // search for dissapeared numbers int the array
        for(int index=0;index<nums.length;index++)
        {
            if(nums[index]!= index+1)
            {
                ans.add(nums[index]);
            }
        }


        return ans;
    }
}