//find Common elements in three sorted  arrays;
package ArraysProblems;

import java.util.ArrayList;

public class CommonElementIn3Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80, 80 };
        int[] arr2 = {6, 7, 20, 80, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 80, 120};

        ArrayList<Integer> result =findCommon(arr1,arr2,arr3);
        for(int a:result)
        {
            System.out.println(a+" ");
        }
    }

    private static ArrayList<Integer> findCommon(int[] arr1, int[] arr2, int[] arr3) {

        ArrayList<Integer> list = new ArrayList<>();


        int i=0,j=0,k=0;

        while(i< arr1.length && j<arr2.length && k< arr3.length)
        {
            //skipping duplicates
            while(i>0 && i<arr1.length && arr1[i] == arr1[i-1])
            {
                i++;
            }
            while(j>0 && j<arr2.length && arr2[j] == arr2[j-1])
            {
                j++;
            }
            while(k>0 && k<arr3.length && arr3[k] == arr3[k-1])
            {
                k++;
            }

            if(i>= arr1.length || j>= arr2.length || k>= arr3.length)
            {
                break;
            }


            if(arr1[i]== arr2[j]  && arr2[j] == arr3[k])
            {
                list.add(arr1[i]);
                i++;
                j++;
                k++;
            }
            else if(arr1[i]<arr2[j])
            {
                i++;
            }
            else if(arr2[j]<arr3[k])
            {
                j++;
            }
            else
            {
                k++;
            }
        }
        return list;
    }
}
