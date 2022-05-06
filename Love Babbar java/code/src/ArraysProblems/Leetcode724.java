package ArraysProblems;

public class Leetcode724 {
    public static void main(String[] args) {
        int[] arr={2,1,-1};

        int result = pivot(arr);
        System.out.println(result);
    }

    public static int pivot(int[] arr) {
        //brute force
//        int n= arr.length;
//        for (int i = 0; i <n ; i++) {
//
//            int leftSum=0;
//            if(i>0)
//            {
//                for (int j = i-1; j >=0 ; j--) {
//                    leftSum += arr[j];
//                }
//            }
//
//            int rightSum=0;
//            if(i<n-1)
//            {
//                for (int j = i+1; j < n; j++) {
//                    rightSum +=arr[j];
//                }
//            }
//
//            if(leftSum==rightSum)
//            {
//                return i;
//            }
//        }
//        return -1;

        int sum=0;
        int leftSum=0;
        for(int x:arr)
            sum += x;

        for (int i = 0; i < arr.length ; i++) {
            //right sum = sum-leftSum-arr[i]
            if(leftSum== sum-leftSum-arr[i])
                return i;
            leftSum += arr[i];
        }
        return -1;
    }
}
