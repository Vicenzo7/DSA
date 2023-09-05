package strings.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "aa", t = "bb";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagramOptimal(s, t));
    }


    /*
        Intuition
        Step1 : Both length should have equal length
        Step2 : Sort both the string
        Step3 : Check is both strings are equal, if not equal not an anagram

        TC = O(nlog(n)) -> time taken to sort the array

    */

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        s = sortString(s);
        t = sortString(t);

        return s.equals(t);
    }

    public static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    /*
        Optimal Intuition
        Step1 : Both length should have equal length
        Step2 : Take a map <char,int> and store in it the count of each variable, of s
        Step3 : In same map <char,int> , decrease the count of each variable, of t
        Step4 : Iterate the map and check if the count is zero, if they aren't return false


        if the strings are anagram, both of them will have same alphabet frequency;
           eg s = "anagram", t = "nagaram"

           s and t have equal number of a,n,g,r,m
           and hence the map values will eventually be zero at the end if the are anagram
        TC = O(n)
        SC = O(n+m) or O(26) -> as alphabets are 26;

        Instead of map we can take array also arr[26] and in this we can store the frequency

    */

    public static boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            frequencyMap.put(t.charAt(i), frequencyMap.getOrDefault(t.charAt(i), 0) - 1);
        }


        for (Integer frequency : frequencyMap.values()) {
            if (frequency != 0) return false;
        }
        return true;
    }
}
