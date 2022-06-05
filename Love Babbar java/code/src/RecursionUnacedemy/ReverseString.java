package RecursionUnacedemy;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }

    public static void reverse(char[] s ,int start,int end)
    {
        // base case
        if(start> end)
        {
            return ;
        }
        char ch = s[start];
        s[start] = s[end];
        s[end] = ch;
        start++;
        end--;
        reverse(s,start,end);
    }
}
