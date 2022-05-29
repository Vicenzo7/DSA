package EasyString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/determine-if-string-halves-are-alike/
public class DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        String str = "book";
        System.out.println(halvesAreAlike(str));

        System.out.println(moreOptimised(str));
    }

    public static boolean halvesAreAlike(String s) {
        s = s.toLowerCase();

        String str1 = s.substring(0, s.length() / 2);
        String str2 = s.substring(s.length() / 2);

        int count1 = find(str1);
        int count2 = find(str2);

        if (count1 == count2)
            return true;
        return false;
    }

    private static int find(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static boolean moreOptimised(String s){
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        int count=0;
        int start=0;
        int end= s.length()-1;

        do {
            if(vowels.contains(s.charAt(start++)))count++;
            if(vowels.contains(s.charAt(end--)))count--;
        }while(start<end);

        return count==0;


    }
}
