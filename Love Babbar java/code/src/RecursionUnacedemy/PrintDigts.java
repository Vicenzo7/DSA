package RecursionUnacedemy;

import java.util.Scanner;

public class PrintDigts {
    public static void main(String[] args) {
        int n ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n=sc.nextInt();
        print(n);
    }

    private static void print(int n) {
        if(n==0)
            return;

        int temp = n%10;
        n=n/10;
        print(n);
        System.out.print(temp+" ");
    }
}
