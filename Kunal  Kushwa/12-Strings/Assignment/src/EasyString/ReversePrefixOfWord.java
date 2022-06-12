package EasyString;

import java.util.Arrays;

public class ReversePrefixOfWord {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word,ch));

    }

    public static String reversePrefix(String word, char ch) {

        if(word.contains(String.valueOf(ch)))
        {
            int upto = word.indexOf(ch);
            return reverse(word.substring(0,upto+1)) + word.substring(upto+1);

        }else{
            return word;
        }

    }

    public static String reverse(String str)
    {
        char[] arr = str.toCharArray();

        int start =0;
        int end = str.length()-1;

        while (start<end)
        {
            char temp =arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return new String(arr);
    }
}
