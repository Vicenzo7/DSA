package EasyString;

import java.util.Arrays;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int  lengthOfLastWord(String s) {
        s=s.trim();
        System.out.println(s);
        String[] str = s.split(" ");
        System.out.println(Arrays.toString(str));

        String result = str[str.length-1];
        System.out.println(result);
        return result.length();
    }
}
