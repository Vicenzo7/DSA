package Arrays;

import java.util.Collections;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        reverseArray(arr);
        for(int a:arr)
        {
            System.out.print(a+" ");
        }
    }

    private static void reverseArray(int[] arr) {
        int n= arr.length;
//        for (int i = 0; i < n/2; i++) {
//            int temp=arr[i];
//            arr[i] = arr[n-i-1];
//            arr[n-i-1]=temp;
//        }

        int start=0,end=n-1;
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        /*
        we can swap without temp variable
        a=a+b
        b=a-b
        a=a-b
         */

    }
}
