package easy;

public class CountZero {
    public static void main(String[] args) {
        int n = 20304;
        System.out.println(countZero(n));
    }


    static int countZero(int n){
        return helper(n,0);
    }

    // special pattern, how to pass a value to above calls
    private static int helper(int n, int count) {
        if(n == 0)
            return count;

        int lastDigit = n %10;
        if(lastDigit == 0)
            count++;
        return helper(n/10,count);
    }
}
