package Easy;

public class EvenNumberOfDigits {
    public static void main(String[] args) {
        int[] nums={15,178,6365,44444,123523};
        int ans= isDigitEven(nums);
        System.out.println(ans);
    }

    private static int isDigitEven(int[] nums) {
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
            int sum=0;
            while(nums[i]>0)
            {
                sum++;
                nums[i] /= 10;
            }
            if(sum%2 == 0)
            {
                count++;
            }
        }
        return count;
    }
}
