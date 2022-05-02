//https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1
package ArraysProblems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Merge2WithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1={1, 3, 5, 7};
        int[] arr2= {0, 2, 6, 8, 9};

        merge(arr1,arr2);
    }

    private static void merge(int[] arr1, int[] arr2) {

        int n=arr1.length;
        int m=arr2.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <m ; j++) {
//                if(arr1[i] >arr2[j])
//                {
//                    int temp=arr1[i];
//                    arr1[i] =arr2[j];
//                    arr2[j]=temp;
//                }
//            }
//        }
//        Arrays.sort(arr2);



        //approach1
        //take a new array
//        int[] arr3 = new int[n+m];
//
//        int i=0,j=0,k=0;
//        //insert element of array 1 and array 2 into array 3
//        while(j<n)
//        {
//            arr3[i]=arr1[j];
//            j++;
//            i++;
//        }
//        while(k<m)
//        {
//            arr3[i]=arr2[k];
//            k++;
//            i++;
//        }
//        //sort array 3
//        Arrays.sort(arr3);
//        //put the array 3 elements in array1 and array 2
//        j=0;
//        i=0;
//        while(j<n)
//        {
//            arr1[j]=arr3[i];
//            i++;
//            j++;
//        }
//        k=0;
//        while(k<m)
//        {
//            arr2[k]=arr3[i];
//            i++;
//            k++;
//        }




        //insertion algo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                if(arr1[i] >arr2[j])
                {
                    int temp=arr1[i];
                    arr1[i] =arr2[j];
                    arr2[j]=temp;
                }
                //checking if array 2 is sorted if not we sort it;
                for(int k=0;k<m-1;k++)
                {
                    if(arr2[k]>arr2[k+1])
                    {
                        int temp=arr2[k];
                        arr2[k]=arr2[k+1];
                        arr2[k+1]=temp;
                    }
                }
            }
        }





        for (int a:arr1)
        {
            System.out.print(a+" ");
        }
        System.out.println();
        for (int a:arr2)
        {
            System.out.print(a+" ");
        }
    }
}
