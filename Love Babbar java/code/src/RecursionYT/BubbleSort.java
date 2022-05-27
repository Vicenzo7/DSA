package RecursionYT;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // write your code here

        int[] arr = {3,1,5,4,2};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr,int size) {

        //base case
        if(size == 0 || size == 1)
            return ;

        //solve for 1 case
        for (int i = 0; i < size-1 ; i++) {
            if(arr[i]>arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        //recursive call
        bubbleSort(arr,size-1);
    }
}
