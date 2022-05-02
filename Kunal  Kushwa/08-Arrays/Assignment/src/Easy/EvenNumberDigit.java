//Find Numbers with Even Number of Digits
package Easy;

public class EvenNumberDigit {
    public static void main(String[] args) {
        int[] input = {12,345,2,6,7896,555,901,482,1771};
        int ans = findNumbers(input);
        System.out.println(ans);
    }

    private static int findNumbers(int[] nums) {
        int count=0;
        for (int i = 0; i < nums.length ; i++) {
            int sum=0;
            while(nums[i]>0)
            {
                sum++;
                nums[i]=nums[i]/10;
            }
            if (sum % 2 == 0)
            {
                count++;
            }
        }
        return count;
    }
}
