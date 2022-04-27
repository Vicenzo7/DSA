package Medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result =productExceptSelf(nums);
        for(int a:result)
        {
            System.out.print(a+" ");
        }
    }

    private static int[] productExceptSelf(int[] nums) {
//        int[] ans = new int[nums.length];
//        for (int i = 0; i < nums.length ; i++) {
//            int product =1;
//            for (int j = 0; j < nums.length ; j++) {
//                if(i==j)
//                {
//                    continue;
//                }
//                else{
//                    product *= nums[j];
//                }
//            }
//            ans[i]=product;
//        }

        //with using division
//        int n= nums.length;
//        int multiplyAll =1, countZero=0;
//        for(int i=0;i<n;i++)
//        {
//            if(nums[i]==0)
//            {
//                countZero++;
//            }
//            else
//            {
//                multiplyAll *= nums[i];
//            }
//        }
//        if(countZero==0)
//        {
//            for (int i = 0; i <n ; i++) {
//                nums[i]=multiplyAll/nums[i];
//            }
//        }
//        else if(countZero==1)
//        {
//            for (int i = 0; i <n ; i++) {
//                if(nums[i]==0)
//                {
//                    nums[i]=multiplyAll;
//                }
//                else
//                {
//                    nums[i]=0;
//                }
//            }
//        }
//        else{
//            for (int i = 0; i <n ; i++) {
//                nums[i]=0;
//            }
//        }

        //without division => postfix suffix methods
//        int n= nums.length;
//        int[] ans =new int[n];
//        int[] postfix = new int[n];
//        postfix[0]=1;
//        int[] suffix = new int[n];
//        suffix[n-1]=1;
//
//        for (int i = 1; i < n; i++) {
//            postfix[i] = postfix[i-1]* nums[i-1];
//        }
//
//        for (int i = n-2; i >= 0; i--) {
//            suffix[i] = suffix[i+1]* nums[i+1];
//        }
//
//        for (int i = 0; i <n ; i++) {
//            ans[i] = postfix[i] * suffix[i];
//        }

        //postfix and suffix more optimized with only one array
        int n= nums.length;
        int[] ans = new int[n];
        int cur =1;
        for (int i = 0; i < n; i++) {
            ans[i] = cur;
            cur *= nums[i];
        }
        cur =1;
        for (int i = n-1; i >=0 ; i--) {
            ans[i] *= cur;
            cur *= nums[i];
        }

        return ans;
    }
}
