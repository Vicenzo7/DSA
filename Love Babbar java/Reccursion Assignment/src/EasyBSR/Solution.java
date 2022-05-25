package EasyBSR;

class Solution {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2};
        int target =2;
        System.out.println(search(nums,target));
    }
    public  static int search(int[] nums, int target) {
        int pivot=findPivot(nums);
        if(pivot == -1)
        {
            return binarySearch(nums,0,nums.length-1,target);
        }
        
        if(nums[pivot] == target)
        {
            return pivot;
        }
        if(nums[0]<= target  && target<nums[pivot])
        {
            return binarySearch(nums,0,pivot-1,target);
        }
        else{
            return binarySearch(nums,pivot+1,nums.length-1,target);
        }
    }
    
    public static int findPivot(int[] arr)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1])
            {
                return mid;
            }
            if(mid>0 && arr[mid]<arr[mid-1])
            {
                return mid-1;
            }
            if(arr[mid]>=arr[start])
            {
                start= mid+1;
            }else{
                end=mid-1;
            }
        }

        return -1;
    }
    
    private static int binarySearch(int[] arr,int start,int end,int target)
    {
            //base case
            if(start>end)
                return -1;

            int mid = start + (end-start)/2;
            //BS conditions
            if(arr[mid] == target)
                return mid;
            else if(arr[mid]<target)
            {
                return binarySearch(arr,mid+1,end,target);
            }
            else{
                return binarySearch(arr,start,mid-1,target);
            }
    }
}