package RecursionUnacedemy;
//https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/
public class MinimumNonZeroProductOfTheArrayElements {
    public static void main(String[] args) {
        int p=3;
        System.out.println(minNonZeroProduct(p));
    }

    static int  mod = 1_000_000_007;
    public static int minNonZeroProduct(int p) {
        //finding range
        long range = (long) Math.pow(2,p);

        long secondLast = range-2;
        long raised = range/2 -1;

        return (int)( (range-1)%mod * fastExpo(secondLast,raised)%mod);

    }


    public static long fastExpo(long x, long n)
    {
        long ans = 1;

        x = x % mod; // Update x if it is more than or
        // equal to mod


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
