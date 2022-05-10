package MediumBS;

public class SingleElementInaSortedArray {
    public static void main(String[] args) {
        int[] nums={1,1,2,3,3,4,4,8,8};
        int ans=singleNonDuplicate(nums);
        System.out.println(ans);
//        if(ans==0)
//        {
//            System.out.println("there is no single element");
//        }
//        else{
//            System.out.println("Single element is "+ans);
//        }
    }
    public static int singleNonDuplicate(int[] nums) {

//        int result=nums[0];
//        for(int i=1;i< nums.length;i++)
//        {
//            result = result^nums[i];
//        }
//        return result;

        /**
         * binary search
         */
//        int n=nums.length;
//        int start=0;
//        int end = n-2;
//
//        while(start<=end)
//        {
//            int mid= start+(end-start)/2;//we can also do (start+end)>>1 means divide by 2;
//
//            //check if in left half
//            if(nums[mid]==nums[mid^1])
//            {
//                start = mid+1;
//            }
//            else
//            {
//                end = mid-1;
//            }
//        }
//        return nums[start];




        //binary search good understanding
        int start=0;
        int end=nums.length-1;

        //boundary conditions
        if(end==0)
            return nums[0];
        else if(nums[0] !=nums[1])
            return nums[0];
        else if(nums[end]!=nums[end-1])
            return nums[end];


        while(start<=end)
        {
            int mid= start+(end-start)/2;
            //unique element confition
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1])
                return nums[mid];

            //mid%2 ==0 means we are at  starting index that  is even(starting) so comparing first an next elemnet
            //mid%2 ==1 means we are at ending index that is odd so comparing first and previous elemnet
            if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2==1 && nums[mid]==nums[mid-1]))
            {
                //the order even-odd is proper so we move right as there is no a single unique element at left
                start=mid+1;
            }
            else{
                end =mid-1;
            }
        }
        return -1;
    }
}
