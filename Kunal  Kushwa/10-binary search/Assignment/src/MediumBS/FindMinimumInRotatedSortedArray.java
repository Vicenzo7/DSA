package MediumBS;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {11, 13, 15, 17};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int pivot = pivotIndex(nums);
        System.out.println(pivot);
        return nums[pivot];
    }

    static int pivotIndex(int[] nums) {
//        int start=0;
//        int end=nums.length-1;
//        while(start<=end)
//        {
//            int mid=start + (end-start)/2;
//            if(nums[mid]>=nums[0])
//            {
//                start=mid+1;
//            }else{
//                end=mid-1;
//            }
//        }
//        return start;

        int n=nums.length;
        int start = 0;
        int end = nums.length - 1;

        //check if its rotated array
        if(nums[0]<nums[n-1])
        {
            return 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if (nums[mid] > start) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
