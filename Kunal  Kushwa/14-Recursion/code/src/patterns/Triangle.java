package patterns;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        //triangle2(5,0);
        int[] arr = {7, 3, 89, 12, 4, 2, 1, 2};
        selectionSort(arr, arr.length, 0,0);
        System.out.println(Arrays.toString(arr));


    }

    static void triangle(int row, int col) {
        // base case
        if (row == 0)
            return;

        if (col < row) {
            System.out.print("* ");
            triangle(row, col + 1);
        } else {
            System.out.println();
            triangle(row - 1, 0);
        }
    }


    static void triangle2(int row, int col) {
        // base case
        if (row == 0)
            return;

        if (col < row) {
            triangle2(row, col + 1);
            System.out.print("* ");
        } else {
            triangle2(row - 1, 0);
            System.out.println();
        }
    }


    static void bubbleSort(int[] arr, int row, int col) {
        // base case
        if (row == 0)
            return;

        if (col < row) {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort(arr, row, col + 1);
        } else {
            bubbleSort(arr, row - 1, 0);
        }
    }


    static void selectionSort(int[] arr, int row, int col, int maxIndex) {
        // base case
        if (row == 0)
            return;

        if (col < row) {
            if (arr[col] > arr[maxIndex]) {
                selectionSort(arr,row, col + 1,col);
            }else{
                selectionSort(arr,row, col + 1,maxIndex);

            }
        } else {
            // swap max element with the last index (row-1);
            int temp = arr[row-1];
            arr[row-1] = arr[maxIndex];
            arr[maxIndex] = temp;
            selectionSort(arr,row-1, 0,0);
        }
    }

}
