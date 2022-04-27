
package Easy;
import java.util.Arrays;

public class RunningSumof1dArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] results = runningSum(nums);
        System.out.println(Arrays.toString(results));
    }

    public static int[] runningSum(int[] nums) {

        int n = nums.length;
        int sum = nums[0];
        int[] runSum = new int[n];
        runSum[0]=sum;
        for(int i = 1; i < n; i++ ){
            runSum[i] = sum + nums[i];
            sum = sum + nums[i];
        }
        return runSum;
    }
}
