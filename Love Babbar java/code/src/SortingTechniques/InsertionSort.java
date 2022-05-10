package SortingTechniques;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={7,5,4,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        int n=arr.length;
        for (int i = 1; i < n; i++) {
            int temp=arr[i];
            int j=0;
            for(j=i-1;j>=0;j--)
            {
                if(arr[j]>temp)
                {
                    arr[j+1]=arr[j];
                }
                else
                {
                    break;
                }
            }
            arr[j+1]=temp;
        }
    }
}
