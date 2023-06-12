package binarysearch.bsInSearchSpace;

//https://practice.geeksforgeeks.org/problems/square-root/0
public class FindSquareRootOfANumber {
    /*Example 1:

    Input:
    x = 5
    Output: 2
    Explanation: Since, 5 is not a perfect
    square, floor of square_root of 5 is 2.
    Example 2:

    Input:
    x = 4
    Output: 2
    Explanation: Since, 4 is a perfect
    square, so its square root is 2.

    Expected Time Complexity: O(log N)
    Expected Auxiliary Space: O(1)


    */

    public static void main(String[] args) {
        int x = 80;
        System.out.println(floorSqrt(x));
    }


    /*
        Solution:
        Since the expected TC is log(n), we can think to apply binary search.
        But binarySearch can be applied on something that is sorted.
        So here we apply binary search on the search space between low = 0 and high = X
        the range is from 0 to X because the squareRoot cannot be greater than X.

        Also, we need to store the floor so this problem is somewhat similar to floor of a number.
    */

    public static long floorSqrt(long x) {
        // Your code here
        long low = 0, high = x;
        long floorAns = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                if (floorAns < mid) {
                    floorAns = mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return floorAns;
    }
}
