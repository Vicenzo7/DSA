package Medium;

public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k=3;
        rotate(nums,k);
    }

    private static void rotate(int[] nums, int k) {
        //brute force approach
//        int n= nums.length;
//        if(k> nums.length)
//        {
//            k=k%n;
//        }
//        int[] ans = new int[nums.length];
//        //putting backward values
//        for (int i = n-k; i < n; i++) {
//            ans[i-(n-k)]=nums[i];
//        }
//
//        for (int i = k; i <n ; i++) {
//            ans[i]=nums[i-k];
//        }
//        for (int i = 0; i <n ; i++) {
//            nums[i]=ans[i];
//        }
//        for(int a:nums)
//        {
//            System.out.print(a+" ");
//        }

        //optimised approach
        int n= nums.length;
        if(k> nums.length)
        {
            k=k%n;
        }
        flip(nums,0,n-1);
        flip(nums,0,k-1);
        flip(nums,k,n-1);
        for(int a:nums)
        {
            System.out.print(a+" ");
        }



    }

    public static void flip(int[] nums, int start, int end)
    {
        //function to flip
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]= temp;
            start++;
            end--;
        }
    }
}
