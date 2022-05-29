package RecursionUnacedemy;

public class ReverseNumber {
    public static void main(String[] args) {
        int num =123456789;
        System.out.println(reverse(num,0));
    }

    public static int reverse(int num, int value)
    {
        int result= value;

        if(num == 0)
            return result;

        int digit = num%10;
        result =result*10+digit;
        num = num/10;
        return reverse(num,result);
    }
}
