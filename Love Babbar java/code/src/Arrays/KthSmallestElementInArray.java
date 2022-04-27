package Arrays;

import java.util.Arrays;

public class KthSmallestElementInArray {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k=3;
        int min=kthSmallest(arr,k);
        System.out.println("The Third Smallest is : "+min);
        int max =kthLargest(arr,k);
        System.out.println("The Third Largest is : "+max);

    }

    private static int  kthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        int len= arr.length;
        for (int n:arr)
        {
            System.out.print(n+" ");
        }
        System.out.println();
        int min =arr[k-1];
        return min;
    }
    private static int  kthLargest(int[] arr, int k) {
        Arrays.sort(arr);
        int len= arr.length;
        for (int n:arr)
        {
            System.out.print(n+" ");
        }
        System.out.println();
        int max =arr[len-k];
        return max;
    }


}
