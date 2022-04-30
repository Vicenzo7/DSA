package Medium;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums={2,1,1,2};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int n= nums.length;
//        int sum=0,sum2=0;
//        for (int i = 0; i < nums.length -1; i +=2) {
//            sum += nums[i];
//        }
//        for (int i = 1; i < nums.length ; i +=2) {
//            sum2 += nums[i];
//        }
//        return Math.max(sum,sum2);

        int maxSum=0;
        for (int i = 0; i <n ; i++) {
            int sum=nums[i];
            for (int j = i+2; j <n ; j +=2) {
                 sum += nums[j];
                maxSum= Math.max(sum,maxSum);
            }

        }
        return maxSum;
    }
}
