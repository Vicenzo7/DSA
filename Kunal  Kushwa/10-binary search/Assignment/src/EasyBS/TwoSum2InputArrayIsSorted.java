package EasyBS;

public class TwoSum2InputArrayIsSorted {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] result =twoSum(nums,target);
        for(int x:result)
        {
            System.out.println(x+" ");
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        //brute force
//        int[] ans = new int[2];
//        int n=nums.length;
//        for (int i = 0; i < n; i++) {
//            int sum1=0;
//            sum1 += nums[i];
//            for (int j = 0; j <n ; j++) {
//                int sum2=0;
//                if(i!=j)
//                {
//                    sum2 =nums[j];
//
//                    if(sum1+sum2==target)
//                    {
//                        ans[0]=i+1;
//                        ans[1]=j+1;
//                        return ans;
//                    }
//                }
//            }
//        }
//        return new int[]{0,0};


        /**
         * This question straightforward uses two-pointer algo , but we can also use binary search within it, just to remove unwanted part of array (using unwanted part eliminate technique)
         whenever eliminated condition hit ,else normally executing by two pointer algo , that is help to reduce the overall time complexity .

         Basically binary search helps to removes that part of array which have element greater than target.
         and only left with element that are lesser than target, on which we apply two-pointer algo.

         Time - O(Logn) + O(N) = O(N)
         Space - O(1)
         */


        int start=0;
        int end=nums.length-1;

        while(start<=end)
        {
            int mid=start +(end-start)/2;
            //if our mid is greater than target we move our end pointer after mid ie end=mid-1;
            if(target>0 && nums[mid]>target)
            {
                end=mid-1;
            }else{
                //if starting element + mid element is greater we move our end pointer after mid ie end=mid-1;
                if(nums[start]+nums[mid]>target)
                {
                    end=mid-1;
                }
            }

            //checking if start element+ end element == target
            if(nums[start]+nums[end]==target)
            {
                return new int[]{start+1,end+1};
            }
            //checking if start element+ end element < target we move towards right
            if(nums[start]+nums[end]<target)
            {
                start++;
            }
            //checking if start element+ end element > target we move towards left
            if(nums[start]+nums[end]>target)
            {
                end--;
            }
        }
        return new int[]{-1,-1};
    }
}
