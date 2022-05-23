package RecursionYT;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        int n ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n=sc.nextInt();

        int ans=power(n);
        System.out.println(ans);
    }

    private static int power(int n) {
        //base condition;
        if(n == 0)
            return 1;

        return 2*power(n-1);
    }
}
