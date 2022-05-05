package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;

public class CheckIfNandItsDoubleExist {
    public static void main(String[] args) {
        int[] arr = {-2,0,10,-19,4,6,-8};

//        Arrays.sort(arr);
//        int k=Arrays.binarySearch(arr,7);
//        System.out.println(k);
        System.out.println(checkIfExist(arr));
    }

    private static boolean checkIfExist(int[] arr) {
        int n = arr.length;

        //brute force
//        for (int i = 0; i < n; i++) {
//            int sum = 2 * arr[i];
//            for (int j = 0; j < n; j++) {
//                if (i == j) {
//                    continue;
//                }
//                if (arr[j] == sum) {
//                    return true;
//                }
//            }
//        }
//        return false;


        //optimised
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int sum1=arr[i]*2;
            int sum2=arr[i]/2;
            if(set.contains(sum1))
            {
                return true;
            }
            else if(set.contains(sum2)){
                if(arr[i]%2==0)
                {
                    return true;
                }
            }
            else{
                set.add(arr[i]);
            }
        }
        return false;



        //Approach 3 TC: O(nlogn)
//        Arrays.sort(arr);
//        for (int i = 0; i < n; i++) {
//            int index=Arrays.binarySearch(arr,arr[i]*2);
//            if(index>=0 && i!=index)
//            {
//                return true;
//            }
//        }
//        return false;
    }

}
