package EasyBS;

import java.util.HashSet;

public class CheckIfNandItsDoubleExist {
    public static void main(String[] args) {
        int[] arr = {-8,-4,1,4,3};

//        Arrays.sort(arr);
//        int k=Arrays.binarySearch(arr,7);
//        System.out.println(k);
        System.out.println(checkIfExist(arr));
    }

    private static boolean checkIfExist(int[] arr) {
        int n = arr.length;




        //brute force
//        Arrays.sort(arr);
//        for (int i = 0; i < n; i++) {
//            int sum = 2 * arr[i];
//            for (int j = i+1; j < n; j++) {
//                if (arr[j] == sum) {
//                    return true;
//                }
//            }
//        }
//        return false;

//        brute force
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
//            //for positive number
//            int index=Arrays.binarySearch(arr,arr[i]*2);
//            if(index>=0 && i!=index)
//            {
//                return true;
//            }
//        }
//        return false;




//        Arrays.sort(arr);
//        for(int i=0; i<arr.length; i++) {
//            //positive number
//            if(arr[i] >= 0 && binarySearch(arr,i+1, arr.length-1, 2*arr[i]) )
//                return true;
//            //negative number
//            if( arr[i] < 0 && arr[i]%2 == 0 && binarySearch(arr, i+1, arr.length-1, arr[i]/2))
//                return true;
//        }
//        return false;
    }


    static boolean binarySearch(int[] arr, int s, int e, int target) {
        int mid = s + (e-s)/2;
        while(s <= e) {
            //cout << "value of mid " << mid << " and target " << target << endl;
            if(target == arr[mid])
                return true;

            if(arr[mid] < target)
                s=mid+1;
            else
                e = mid - 1;
            mid = s + (e-s)/2;
        }
        return false;
    }

}
