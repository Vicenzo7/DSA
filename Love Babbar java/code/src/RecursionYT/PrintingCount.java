package RecursionYT;

import java.util.Scanner;

public class PrintingCount {
    public static void main(String[] args) {
        int n ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n=sc.nextInt();
        print(n);
    }

    private static void print(int n) {
        //base condition
        if(n == 0)
            return ;

        System.out.println(n);

        print(n-1);
    }
}
