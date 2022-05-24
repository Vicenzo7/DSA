package RecursionYT;
//https://leetcode.com/problems/climbing-stairs/
/**
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
class ClimbingStairs {

    public static void main(String[] args) {
        int n =5;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        //base case
        if(n < 0)
            return 0;
        
        if(n == 0)
            return 1;
        
        //R.C
        int ans = climbStairs(n-1) + climbStairs(n-2);
        return ans;
    }
}