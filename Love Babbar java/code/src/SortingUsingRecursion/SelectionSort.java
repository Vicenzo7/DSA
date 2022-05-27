package SortingUsingRecursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,8,1,2,66,75,14,62,99};
        selectionSort(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr,int index, int size) {
        //base condition
        if (index == size)
            return;


        int last = size - index - 1;
        int maxIndex = getMaxIndex(arr, 0, last);
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[last];
        arr[last] = temp;

        selectionSort(arr,index+1,size);

    }


    private static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
