package Problems;

public class CeilingAndFloorOfANumber {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        int target=15;
        System.out.println("Ceiling "+findCeiling(arr,target));
        System.out.println("Floor "+findFloor(arr,target));
    }


    /**
     * finding ceiling of number
     * ceiling =the smallest number in array greater or = target
     */
    private static int findCeiling(int[] arr, int target) {
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
        return arr[start];
    }


    /**
     *
     *finding floor of number
     * floor=the greatest number smaller or = target
     */

    private static int findFloor(int[] arr, int target) {
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
        return arr[end];
    }
}
