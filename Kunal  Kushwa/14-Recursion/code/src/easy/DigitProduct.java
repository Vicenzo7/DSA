package easy;

public class DigitProduct {
    public static void main(String[] args) {
        int n = 13042;
        int ans = productOfDigit(n);
        System.out.println(ans);
    }

    static int productOfDigit(int n) {
        if (n == 0) {
            return 1;
        }

//        int lastDigit = n % 10;
//        n = n / 10;

        return (n % 10) * productOfDigit(n / 10);
        //return lastDigit*productOfDigit(n);
    }
}
