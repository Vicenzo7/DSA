package BasicMath;

/**
 * gcd(a,b)=gcd(a-b,b)
 * keep doing this until either a or b is zero and make sure 'a' is always greater.
 * when one of 'a' or 'b' is zero the other is the ans
 */
public class GCDwithEuclidsAlgo {

    public static void main(String[] args) {
        int a=0;
        int b=164;
//        System.out.println("gcd of "+a+" and "+b+" is " +gcd(a,b));
        System.out.println("gcd of "+a+" and "+b+" is " +gcdwithmod(a,b));

    }

    private static int gcd(int a, int b) {
        if(a==0)
            return b;
        if(b==0)
            return a;

        while(a!=b)
        {
            if(a>b)
                a=a-b;
            else
                b=b-a;
        }
        return a;// can return b also
    }


    private static int gcdwithmod(int a, int b) {


        while(a!=b)
        {
            if(a==0)
                return b;
            if(b==0)
                return a;
            if(a>b)
                a=a%b;
            else
                b=b%a;
        }
        return a;// can return b also
    }
}
