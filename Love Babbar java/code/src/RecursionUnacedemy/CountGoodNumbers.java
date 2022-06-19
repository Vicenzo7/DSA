package RecursionUnacedemy;
//https://leetcode.com/problems/count-good-numbers/
public class CountGoodNumbers {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countGoodNumbers(n));
    }

    static int  mod = 1_000_000_007;
    public static int countGoodNumbers(long n) {

        long ans = 1;
        ans= (fastExpo(5,(n+1)/2)   *  fastExpo(4,n/2))% mod;

        return (int) ans;
    }

    public static long fastExpo(long x,long n)
    {
        long ans = 1;

        while(n>0)
        {
            //check if odd
            if((n&1) == 1)
            {
                ans = (ans *x)% mod;
            }

            x=(x*x) % mod;

            //dividing by 2
            n=n>>1;
        }
        return ans;
    }
}
