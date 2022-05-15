package BasicMath;

public class PrimeNumber {
    public static void main(String[] args) {
        int n=53;
        System.out.println(isPrime(n));
    }

    private static boolean isPrime(int n) {

//        for (int i = 2; i < n; i++) {
//            if (n%i==0)
//                return false;
//        }
//        return true;


        // by n/2 approach

//        for (int i = 2; i < n/2; i++) {
//            if (n%i==0)
//                return false;
//        }
//        return true;

        // square root method
        for (int i = 2; i *i < n ; i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
