package binarysearch.bsInSearchSpace;

public class FindNthRootOfM {
    public static void main(String[] args) {
        int n = 3, m = 9;
        System.out.println(NthRoot(n,m));
    }

    /*

    Optimal Solution : Binary Search
    This is also a search space problem, need to find out root.
    Root lies in a search space from 0 to M

    So calculate the mid and check if mid is the nth root of M.

    TC = O(log(n))
     */


    public static int NthRoot(int n, int m) {
        long low = 0, high = m;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            double pow = Math.pow(mid, n);
            if (pow == m) {
                return (int) mid;
            } else if (pow < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
