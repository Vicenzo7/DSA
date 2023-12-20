package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwekw";
        String d = "c";
        System.out.println(lengthOfLongestSubstringOptimised(d));
    }


    public static int lengthOfLongestSubstringOptimised(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        Set<Character> window = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left += 1;
            }
            window.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        if (s.isBlank() || s.length() == 1) {
            return 1;
        }

        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            maxLength = Math.max(maxLength, set.size());
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }
}
