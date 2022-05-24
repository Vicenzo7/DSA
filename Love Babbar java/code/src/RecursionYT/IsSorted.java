package RecursionYT;

public class IsSorted {
    public static void main(String[] args) {
        int[] arr={2,4,6,9,11,11};
        int n= arr.length;
        boolean ans=isSorted(arr,n);
        if(ans)
        {
            System.out.println("Array is sorted");
        }
        else{
            System.out.println("Array not sorted ");
        }
    }

    static boolean isSorted(int[] arr, int size)
    {
        //base case
        if(size == 0 || size == 1)
            return true;

        //comparing last 2 elements of the array and then reducing the size by 1 of array
        if(arr[size-2]>arr[size-1])
            return false;
        else
        {
            boolean ans=isSorted(arr, size-1);
            return ans;
        }


    }
}
