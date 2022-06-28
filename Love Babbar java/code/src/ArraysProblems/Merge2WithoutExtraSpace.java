//https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1
package ArraysProblems;

import java.util.Arrays;

public class Merge2WithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1={1, 3, 5, 7};
        int[] arr2= {0, 2, 6, 8, 9};

        merge(arr1,arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    static void merge(int[] arr1, int arr2[], int n, int m) {
        // code here
        int i, k;
        for (i = 0; i < n; i++) {
            // take first element from arr1
            // compare it with first element of second array
            // if condition match, then swap
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            // then sort the second array
            // put the element in its correct position
            // so that next cycle can swap elements correctly
            int first = arr2[0];
            // insertion sort is used here
            for (k = 1; k < m && arr2[k] < first; k++) {
                arr2[k - 1] = arr2[k];
            }
            arr2[k - 1] = first;
        }
    }
}
