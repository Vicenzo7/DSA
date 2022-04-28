package ArraysProblems;

import java.util.HashMap;

public class Equal0and1Subarray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1};
        int size = maxLen(arr);
        System.out.println(size);
    }

    public static int maxLen(int[] arr) {

        //brute force approach
//        int n = arr.length;
//        int sum = 0, maxSize = -1, startIndex = 0, endIndex = 0;
//
//        for (int i = 0; i < n - 1; i++) {
//            if (arr[i] == 0) {
//                sum = -1;
//            } else {
//                sum = 1;
//            }
//            //loop for subarrays
//            for (int j = i + 1; j < n; j++) {
//                if (arr[j] == 0) {
//                    sum += -1;
//                } else {
//                    sum += 1;
//                }
//                //checking if subarray has equal 0's and 1's
//                if (sum == 0 && maxSize < j - i + 1) {
//                    maxSize = j - i + 1;
//                    startIndex = i;
//                }
//                endIndex = startIndex + maxSize - 1;
//            }
//        }
//        return maxSize;

        //optimized approach
        int n= arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0,ans=0;

        map.put(0,1);
        for (int i = 0; i < n; i++) {
            if(arr[i]==1)
            {
                sum += 1;
            }
            else // treating 0 as -1
            {
                sum += -1;
            }

            if(map.containsKey(sum))
            {
                ans += map.get(sum);
                map.put(sum,map.get(sum)+1);
            }
            else
            {
                map.put(sum,1);
            }
        }
        return ans;
    }
}
