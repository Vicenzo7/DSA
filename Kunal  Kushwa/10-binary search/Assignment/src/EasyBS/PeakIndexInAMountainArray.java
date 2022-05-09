package EasyBS;

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] arr= {9,55,66,69,77,88,44,22,11};
        int result=peakIndexInMountainArray(arr);
        System.out.println(result);
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            // mid is on left line so move right to reach peak;
            if(arr[mid]<arr[mid+1])
            {
                start=mid+1;
            }else{
                // mid is on right line so move left to reach peak;
                end=mid-1;
            }
        }
        return start;
    }
}
