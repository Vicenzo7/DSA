package RecursionYT;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int n ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n=sc.nextInt();

        int ans=fact(n);
        System.out.println(ans);
    }

    private static int fact(int n) {
        //base condition
        if( n == 0 || n==1)
            return 1;

//        int smallProblem =fact(n-1);
//        int bigProblem = n * smallProblem;

        return n * fact(n-1);

    }
}
