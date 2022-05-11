package Problems;

public class CeilingofNumber {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        int target=19;
        System.out.println("Ceiling "+findCeiling(arr,target));
    }


    /**
     * finding ceiling of number
     * ceiling =the smallest number in array greater or = target
     */
    //return the index: smallest number>=target
    private static int findCeiling(int[] arr, int target) {

        //but what is the target is greater than the greatest number in the array
        if(target>arr[arr.length-1])
        {
            return -1;
        }
        int start =0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return arr[mid];
            else if(arr[mid]<target)
                start=mid+1;
            else
                end =mid-1;
        }
        return start;
    }



}
