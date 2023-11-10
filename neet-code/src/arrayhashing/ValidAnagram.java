package arrayhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "rat", t = "car";


        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        // TC = O(s+t)  SC = O(s+t)

        if (s.length() != t.length()) return false;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i <= s.length(); i++) {
            char sChar = s.charAt(i);
            frequencyMap.put(sChar, frequencyMap.getOrDefault(sChar, 0) + 1);
        }

        for (int i = 0; i <= t.length(); i++) {
            char tChar = t.charAt(i);
            frequencyMap.put(tChar, frequencyMap.getOrDefault(tChar, 0) - 1);
        }

        for (Integer value : frequencyMap.values()) {
            if (value != 0) return false;
        }

        return true;
    }

//    public static boolean isAnagram(String s, String t) {
//
//        // TC = O(nlog(n))  SC O(1)
//        if (s.length() != t.length()) return false;
//        s = sortString(s);
//        t = sortString(t);
//        return s.equals(t);
//    }

    private static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
