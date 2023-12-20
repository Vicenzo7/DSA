package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        /*
            Input: s = "ADOBECODEBANC", t = "ABC"
            Output: "BANC"
            Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
        */

        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Brute :" + bruteForceMinWindow(s, t));
        System.out.println("Optimal :" + minWindow(s, t));
    }


    public static String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            tMap.put(key, tMap.getOrDefault(key, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        int minimumLength = Integer.MAX_VALUE;
        String ans = "";
        int have = 0, need = tMap.size();

        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);
            sMap.put(key, sMap.getOrDefault(key, 0) + 1);

            if (tMap.containsKey(key) && sMap.get(key).equals(tMap.get(key))) {
                have += 1;
            }

            while (have == need) {
                // update our result
                if (right - left + 1 < minimumLength) {
                    minimumLength = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                // shrink the window, pop from left of the window
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar)) {
                    have -= 1;
                }
                left++;
            }
        }

        return ans;
    }

    private static boolean isValid(String substring, String t, Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for (char c : t.toCharArray()) {
            if (substring.contains(c + "")) {
                if (!tMap.get(c).equals(sMap.get(c))) {

                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }


    public static String bruteForceMinWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        String ans = "";
        int minimumLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (minimumLength > substring.length() && valid(substring, t)) {
                    minimumLength = substring.length();
                    ans = substring;
                }

            }
        }

        return ans;
    }

    private static boolean valid(String substring, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : substring.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (substring.contains(c + "")) {
                Integer i = map.getOrDefault(c, 0);
                if (i > 0) {
                    map.put(c, i - 1);
                } else {
                    return false;
                }

            } else {
                return false;
            }

        }
        return true;
    }
}
