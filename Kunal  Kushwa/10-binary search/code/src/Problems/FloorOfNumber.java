package Problems;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        int target=1;
        System.out.println("Floor "+findFloor(arr,target));
    }

    /**
     *
     *finding floor of number
     * floor=the greatest number smaller or = target
     */
    //return the index: greatest number<=target
    private static int findFloor(int[] arr, int target) {

        //but what is the target is smaller than the smallest number in the array
        if(target<arr[0])
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
        return end;
    }
}
