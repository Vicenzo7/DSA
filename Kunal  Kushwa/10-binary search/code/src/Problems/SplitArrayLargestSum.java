package Problems;

//https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums={7,2,5,10,8};
        int m=2;
        System.out.println(splitArray(nums,m));
        System.out.println(splitArrayLoveBabar(nums,m));
    }

    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        //storing in start max of array and in end the sum of entire array
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);// in the end of the loop this will contain max item from array
            end += nums[i];
        }

        //binary search
        while (start < end) {
            //try for the middle as potential ans
            int mid = start + (end - start) / 2;

            //calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    //you cannot add this in this sub array, make new one
                    //say you add this num in new sub array, the sum=num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            }else{
                end=mid;
            }
        }

        return end;//here start==end
    }



    //Love Babbar method
    public static int splitArrayLoveBabar(int[] nums, int m) {
        int start=0;
        int end=0;

        //storing in start max of array and in end the sum of entire array
        for(int i=0;i<nums.length;i++)
        {
            start= Math.max(start,nums[i]);
            end += nums[i];
        }
        int ans=-1;

        while(start<=end)
        {
            int mid=start + (end-start)/2;

            if(isPossible(nums,m,mid))
            {
                ans= mid;
                end= mid-1;
            }
            else{
                start = mid+1;
            }

        }
        return ans;
    }



    public static boolean isPossible(int[] nums,int m, int mid)
    {
        int sum=0;
        int pieces=1;

        for(int num:nums)
        {
            if(sum+num<=mid)
            {
                sum +=num;

            }else{
                pieces++;
                if(pieces>m || num >mid)
                {
                    return false;
                }
                sum = num;
            }
        }

        return true;
    }
}
