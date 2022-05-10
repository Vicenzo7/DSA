package SortingTechniques;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={7,5,4,2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int minIndex=i;
            for (int j = i+1; j <n ; j++) {
                if(arr[minIndex]>arr[j])
                    minIndex=j;
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]= temp;
        }
    }

}
