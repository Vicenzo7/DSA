package RecursionUnacedemy;

import java.util.Arrays;

public class BeautifulArrangement {
    public static void main(String[] args) {
        int n=3;
        System.out.println(countArrangement(n));
    }

    static int count=0;
    public static int countArrangement(int n) {

        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=i+1;
        }
        int index=0;
        solve(nums,index);

        return count;
    }

    public static void solve(int[] nums,int index)
    {
        // base case
        if(index == nums.length)
        {
            count++;
        }


        for(int i =index;i<nums.length;i++)
        {
            swap(nums,i,index);
            if((nums[index]%(index+1)== 0  ||  (index+1)% nums[index]==0))
                solve(nums,index+1);
            swap(nums,i,index);
        }
    }


    public static void swap(int[] nums,int i,int j)
    {
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]= temp;
    }

    public static boolean isValid(int[] nums)
    {
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i]%(i+1)== 0  ||  (i+1)% nums[i]==0))
                continue;
            else
                return false;
        }
        return true;
    }
}
