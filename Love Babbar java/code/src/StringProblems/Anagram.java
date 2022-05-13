package StringProblems;

import java.util.*;


public class Anagram {
    public static void main(String[] args) {
       String a="listen";
       String b="silent";

        System.out.println(checkAnagram(a,b));
    }

    private static boolean checkAnagram(String a, String b) {
        int[] frequency = new int[26];

        for (int i = 0; i <a.length() ; i++) {
            char ch=a.charAt(i);
            int index=ch-'a';
            frequency[index]++;
        }
        System.out.println(Arrays.toString(frequency));

        for (int i = 0; i <b.length() ; i++) {
            frequency[b.charAt(i)-'a']--;
        }

        for (int i = 0; i <26 ; i++) {
            if(frequency[i]!=0)
            {
                return false;
            }
        }
        return true;

    }
}
