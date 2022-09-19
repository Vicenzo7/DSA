package basic;

public class NumerPrintRecursion {

    public static void main(String[] args) {
        print(1);

    }

    private static void print(int n) {
        if(n==6)
            return;

        System.out.println(n);
        print(n+1);
    }
}