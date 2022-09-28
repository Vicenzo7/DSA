package easy;

public class Palindrome {
    static int reverse = 0;

    static void rev1(int n) {
        if (n == 0) {
            return;
        }
        int lastDigit = n % 10;
        reverse = reverse * 10 + lastDigit;
        rev1(n / 10);
    }


    static int rev2(int n) {

        // the below formula will give no of digits in number n;
        int digits = (int) Math.log10(n) + 1;
        return helper(n, digits);

    }

    private static int helper(int n, int digits) {
        if (n == 0) {
            return 0;
        }
        int rem = n % 10;

        return rem * (int)(Math.pow(10,digits-1)) +helper(n/10,digits-1);

    }


    static boolean palindrome(int n){
        return n == rev2(n);
    }


    static boolean palindromCompleteRec(String  n,int s, int e){
        if(s >= e)
            return true;

        if(n.charAt(s) != n.charAt(e)){
            return false;
        }
        return palindromCompleteRec(n,s+1,e-1);

    }

    public static void main(String[] args) {
        int n = 1234321;
//        System.out.println(palindrome(n));

        String s = n+"";
        System.out.println(palindromCompleteRec(s,0,s.length()-1));
    }


}
