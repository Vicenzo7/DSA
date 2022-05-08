package EasyBS;

public class ArrangingCoins {
    public static void main(String[] args) {
        int n=15;
        int result = arrangeCoins(n);
        System.out.println(result);
    }

    private static int arrangeCoins(int n) {
        //brute force TC: O(n)
//        int i=0;
//        while (n>=i)
//        {
//            n=n-i;
//            i++;
//        }
//        return i-1;

        //binarySearch TC: O(log n)
        /**
         * n*(n+1)/2 formula
         */

//         long start=0;
//         long end=n;
//         long ans=-1;
//         while(start<=end) {
//             long mid = start + (end - start) / 2;
//             long possible = mid * (mid + 1) / 2;
//             if (possible == n) {
//                 return (int) mid;
//             } else if (possible < n) {
//                 start = mid + 1;
//             } else {
//                 //possible > n
//                 end = mid - 1;
//             }
//         }
//         return (int)end;



        //more optimized

        return (int)(Math.sqrt(2* (long)n +0.25) - 0.5);
    }
}
