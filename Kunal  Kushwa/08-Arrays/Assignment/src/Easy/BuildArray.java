package Easy;
import java.util.Arrays;

public class BuildArray {
    public static void main(String[] args) {
        /*
        Problem 1
        Build Array from Permutation
         */

        int[] nums = { 0,2,1,5,3,4};
        int[] result = buildArray(nums);
        System.out.println(Arrays.toString(result));
    }



    public static int[] buildArray(int[] nums) {

        int n= nums.length;
        int[] ans = new int[n];
        int count = 0;

        for(int i=0;i<n;i++)
        {
            ans[i]=nums[nums[count]];
            count++;
        }
        return ans;



    }
}
