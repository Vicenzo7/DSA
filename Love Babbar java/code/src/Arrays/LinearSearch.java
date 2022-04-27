package Arrays;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("enter the size of array");
        n=in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }

        int k;
        System.out.println("enter the element you want to search");
       k=in.nextInt();
        boolean status=isPresent(arr,n,k);
        System.out.println(status);
    }

    private static boolean isPresent(int[] arr, int n, int k) {
        for(int i=0;i<n;i++)
        {
            if(arr[i]==k)
            {
                return true;
            }
        }

        return false;
    }

}
