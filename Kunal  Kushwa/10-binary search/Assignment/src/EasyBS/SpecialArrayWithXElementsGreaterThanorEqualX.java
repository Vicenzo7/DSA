package EasyBS;

public class SpecialArrayWithXElementsGreaterThanorEqualX {
    public static void main(String[] args) {
        int[] nums={3,5};
        System.out.println(specialArray(nums));
    }
    public static int specialArray(int[] nums) {

//        int n= nums.length;
//        int x=0;
//        for(int i=0;i<1001;i++)
//        {
//            if(x>nums.length)
//            {
//                break;
//            }
//            int count=0;
//            for(int j=0;j<n;j++)
//            {
//                if(nums[j]>=x)
//                {
//                    count++;
//                }
//            }
//            if(count==x)
//            {
//                return x;
//            }
//            x++;
//        }
//        return -1;




//        int n= nums.length;
//        int x=0;
//        for(int i=0;i<1001;i++)
//        {
//            int count=0;
//            for(int num:nums)
//            {
//                if(num>=i)
//                {
//                    count++;
//                }
//            }
//            if(count==i)
//            {
//                return i;
//            }
//        }
//        return -1;








        int[] bucket = new int[1001];
        //counting frequency of each element
        for(int num:nums)
        {
            bucket[num]++;
        }
        int total=nums.length;
        for(int i=0;i<1001;i++)
        {
            if(i==total)
                return i;

            total -= bucket[i];
        }
        return -1;
    }
}
