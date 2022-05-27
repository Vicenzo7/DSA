package RecursionUnacedemy;

public class FastExponentiation {
    public static void main(String[] args) {
        System.out.println(expo(3,4));
    }

    public static int expo(int a,int b)
    {
        //base case
        if(b == 0)
        {
         return 1;
        }

        //recursive call
        int smallP= expo(a,b/2);

        //if b is odd
        if((b&1) == 1)
        {
            return smallP * smallP * a;
        }
        else
        {
            //if b is even
            return smallP*smallP;
        }
    }
}
