package BasicMath;

public class FastExponentiation {
    public static void main(String[] args) {
        int  a=2;
        int  b=16;

        double x=34.00515;
        int y=-3;

        System.out.println(exponentiation(a,b));
        System.out.println(fastExponentiation(x,y));

    }

    private static int exponentiation(int  x, int n) {
        int ans=1;
//        for (int i = 0; i < n; i++) {
//            ans=  (ans*x);
//        }

        //fast exponentiation only for positive powers
        while(n>0)
        {
            //checking if odd
            if((n & 1)==1){
                ans =ans*x;
            }

            x =x*x;

            //dividing by 2
            n=n>>1;
        }
        return ans;
    }


    //for negative power as well
    public static  double fastExponentiation(double x,int n)
    {
        double ans=1;
        long nn =n;
        //if its negative we are turning it into positive
        if(nn<0)
        {
            nn = -nn;
        }
        while(nn>0)
        {
            //checking if it's odd
            if(nn%2==1)
            {
                ans= ans*x;
                nn--;
            }else{
                x *= x;
                nn /=2;
            }
        }

        if(n<0)
            return (double)1/ ans;

        return ans;

    }
}
