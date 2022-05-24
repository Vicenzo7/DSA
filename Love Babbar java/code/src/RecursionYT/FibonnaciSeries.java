package RecursionYT;

public class FibonnaciSeries {
    public static void main(String[] args) {
        int n=5;

        int ans=fibo(n);
        System.out.println(ans);
    }

    private static int fibo(int n) {
        //base case
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
             return 1;
        }

        //RR

        return fibo(n-1)+fibo(n-2);

    }

}

