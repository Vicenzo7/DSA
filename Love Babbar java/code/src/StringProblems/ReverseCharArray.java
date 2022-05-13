package StringProblems;

import java.util.Arrays;

public class ReverseCharArray {
    public static void main(String[] args) {
        char[] name={'d','e','e','p'};
        reverse(name);
        System.out.println(Arrays.toString(name));
        for(char x:name)
        {
            System.out.print(x+" ");
        }

    }

    static void reverse(char[] name)
    {
        int n=name.length;
        int start=0;
        int end=n-1;

        while(start<=end)
        {
            char temp=name[start];
            name[start]=name[end];
            name[end]=temp;
            start++;
            end--;
        }
    }
}
