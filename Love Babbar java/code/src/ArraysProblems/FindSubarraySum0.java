package ArraysProblems;

import java.util.HashSet;

public class FindSubarraySum0 {
    public static void main(String[] args) {
        int[] arr = {4, 2,-1 ,1, 6};
        System.out.println(findSum(arr));
    }

    private static boolean findSum(int[] arr) {
        int n= arr.length;
//        for (int i = 0; i < n ; i++) {
//            if(arr[i]==0)
//            {
//                return true;
//            }
//            int sum =arr[i];
//            for (int j = i+1; j < n ; j++) {
//                 sum = sum +arr[j];
//                if(sum==0)
//                {
//                    return true;
//                }
//            }
//            sum =0;
//        }
//        return false;

        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <n ; i++) {

            sum += arr[i];

            if(arr[i]==0 || sum ==0 || set.contains(sum))
            {
                return true;
            }
            set.add(sum);
        }
        return false;
    }
}
