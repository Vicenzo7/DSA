package StringProblems;

import java.util.Arrays;

public class RemoveAllOccurrencesOfASubstring {
    public static void main(String[] args) {
        String s = "aabababa", part = "aba";
        System.out.println(removeOccurrences(s,part));
    }

    public static String removeOccurrences(String s, String part) {
//            while(s.length()!=0 && s.contains(part))
//            {
//                s= s.replaceFirst(part,"");
//            }
//            return s;


        while(s.contains(part)){
            int x=s.indexOf(part);
            System.out.println(x);
            StringBuilder s1=new StringBuilder(s);
            s1.delete(x,x+part.length());
            s=s1.toString();
        }
        return s;
    }
}
