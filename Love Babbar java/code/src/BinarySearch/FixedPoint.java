package BinarySearch;

public class FixedPoint {
    public static void main(String[] args) {
        int[] nums={-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        int ans=fixedPoint(nums);
        System.out.println(ans);
    }

    //solved using binary search
    public static int fixedPoint(int[] nums) {
        int n= nums.length;
        int start=0;
        int end=n-1;
        while(start<= end)
        {
            int mid= start + (end-start)/2;
            if(nums[mid]==mid)
            {
                return mid;
            }
            else if(nums[mid]<mid)
            {
                start=mid+1;
            }
            else{ //nums[mid]>mid
                end=mid-1;
            }
        }
        return -1;
    }
}
