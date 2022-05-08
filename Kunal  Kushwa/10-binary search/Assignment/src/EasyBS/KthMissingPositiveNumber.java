package EasyBS;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr= {2,3,4,7,11};
        int k=5;
        System.out.println(findKthPositive(arr,k));
    }

    public static int findKthPositive(int[] arr, int k) {
        //11,14,15,16  k=5
//        if(arr[0]>k)
//            return k;
//        int nums=k;
//        for(int a:arr)
//        {
//            if(a<=nums)
//            {
//                nums++;
//            }
//            else{
//                break;
//            }
//        }
//        return nums;


        //another approach

//        if(arr[0]>k)
//            return k;
//
//        int idx=0;
//        int i=0;
//        while(i<arr.length && (arr[i]-i+1)<k)
//        {
//            idx=i+1;//zero index so adding 1;
//            i++;
//        }
//
//        return k+idx;
//

        if(arr[0]>k)
            return k;

        int lo=0;
        int hi=arr.length-1;
        int closeMid=0;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            //arr[mid]-mid+1 == missing numbers up to mid
            if(arr[mid]-(mid+1)<k)
            {
                closeMid=mid+1;
                lo=mid+1;
            }
            else
            {
                hi=mid-1;
            }
        }
        return k+closeMid;




    }
}
