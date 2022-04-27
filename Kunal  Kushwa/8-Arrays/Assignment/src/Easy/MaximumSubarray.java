package Easy;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarray(input));
    }

    private static int maxSubarray(int[] input) {

        int sum=0;
        int maxi = input[0];
        for (int i=0; i< input.length;i++) {
            sum = sum+input[i];
            maxi= Math.max(sum,maxi);
            if(sum<0)
            {
                sum=0;
            }
        }
        return maxi;
    }
}
