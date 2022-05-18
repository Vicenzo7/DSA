package HardBS;

public class CapacityToShipPacakgesInDDays {
    public static void main(String[] args) {
        int[] weight={1,2,3,4,5,6,7,8,9,10};
        int days=5;
        System.out.println(shipWithinDays(weight,days));
    }

    //Love Babbar method
    public static int shipWithinDays(int[] weights, int days) {
        int start =0;
        int end=0;
        int ans=-1;

        for(int x: weights)
        {
            start =Math.max(start,x);
            end += x;
        }

        while(start<=end)
        {
            int mid = start+(end -start)/2;

            if(isPossible(weights,days,mid))
            {
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }


    public static boolean isPossible(int[] arr,int days,int mid)
    {
        int daysCount=1;
        int weightSum=0;

        for(int x: arr)
        {
            if(weightSum+x<= mid)
            {
                weightSum += x;
            }
            else{
                daysCount++;
                if(daysCount>days || x> mid)
                {
                    return false;
                }
                weightSum = x;
            }
        }
        return true;
    }


    //Kunal Kushwa Method;
    public static int shipWithinDaysKunalKushwa(int[] nums, int days) {
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

            //calculate how many days you can carry   max weightSum
            int weightSum = 0;
            int daysCount = 1;
            for (int num : nums) {
                if (weightSum + num > mid) {
                    //you cannot add this weight in total weight, make new one
                    //say you add this num in new weight, the weightSum=num
                    weightSum = num;
                    daysCount++;
                } else {
                    weightSum += num;
                }
            }

            if (daysCount > days) {
                start = mid + 1;
            }else{
                end=mid;
            }
        }

        return end;//here start==end
    }
}
