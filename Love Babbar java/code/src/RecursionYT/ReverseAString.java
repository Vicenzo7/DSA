package RecursionYT;


import java.util.Arrays;

public class ReverseAString {
    public static void main(String[] args) {
        String in = "Hello world";
        int size = in.length();
        StringBuilder op = new StringBuilder();
        System.out.println(reverse(in,size-1,op));
        char[] st = in.toCharArray();
        System.out.println(reverseStr(st,0));


    }

    private static String reverse(String in,int size,StringBuilder op) {
        //base case

        if(size <0)
            return op.toString();
        StringBuilder sb = new StringBuilder(op);
        char ch = in.charAt(size);
        sb.append(ch);
        return reverse(in,size-1,sb);

    }


    public static String reverseStr(char[] st ,int i)
    {
        int size= st.length;
        if(i>size/2)
            return String.valueOf(st);

        char temp =st[i];
        st[i] = st[size-i-1];
        st[size-i-1] =temp;
        i++;

        return reverseStr(st,i);
    }




}
