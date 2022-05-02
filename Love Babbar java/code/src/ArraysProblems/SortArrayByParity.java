package ArraysProblems;
//https://leetcode.com/problems/sort-array-by-parity/
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr={3,1,2,4};
        int[] ans = sortArrayByParity(arr);

        for(int a:ans)
        {
            System.out.print(a);
        }

    }
    public static int[] sortArrayByParity(int[] nums) {

        if(nums.length==0)
        {
            return new int[]{0};
        }
        int start =0;
        int end =nums.length-1;

        while(start<=end)
        {
            if(nums[start]%2 ==0  && nums[end]%2==0)
            {
                start++;
            }
            else if(nums[start]%2 !=0  && nums[end]%2==0)
            {
                int temp =nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
                end--;
            }
            else if(nums[start]%2 !=0  && nums[end]%2!=0)
            {
                end--;
            }
            else
            {
                start++;
                end--;
            }
        }
        return nums;
    }
}
