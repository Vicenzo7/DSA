package slidingwindow;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
        System.out.println(checkInclusionOptimised(s1, s2));
    }

    // TC = O(n)
    public static boolean checkInclusionOptimised(String s1, String s2) {
        // if s2 < s1 return false
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        int matches = 0; // note if matches == 26 means frequency matches
        for (int i = 0; i < 26; i++) {
            matches += s1Freq[i] == s2Freq[i] ? 1 : 0;
        }

        // starting from s1.length because we have created a window
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            // note if matches == 26 means frequency count matches
            if (matches == 26) {
                return true;
            }

            // if no match then increase the window
            int index = s2.charAt(right) - 'a';
            s2Freq[index]++;
            // by increasing the frequency in s2Freq,caused the character frequency in both array to be same then increase the match
            if (s1Freq[index] == s2Freq[index]) {
                matches += 1;
            } else if (s1Freq[index] + 1 == s2Freq[index]) { // by increasing the frequency in s2Freq,caused the character frequency in s1Freq array to be less than s2Freq
                // decrease the match
                matches -= 1;
            }


            index = s2.charAt(left) - 'a';
            s2Freq[index]--;
            // by decreasing the frequency in s2Freq,caused the character frequency in both array to be same then increase the match
            if (s1Freq[index] == s2Freq[index]) {
                matches += 1;
            } else if (s1Freq[index] - 1 == s2Freq[index]) { // by decreasing the frequency in s2Freq,caused the character frequency in s1Freq array to be more than s2Freq
                // decrease the match
                matches -= 1;
            }
            left += 1;
        }

        return matches == 26;
    }


    // TC = O(26.n) = O(n)  SC = O(26) = O(1)
    public static boolean checkInclusion(String s1, String s2) {
        // if s2 < s1 return false
        if (s2.length() < s1.length()) {
            return false;
        }

        // calculate frequency of s1 characters
        int[] s1Frequency = new int[26];
        for (char ch : s1.toCharArray()) {
            s1Frequency[ch - 'a']++;
        }

        int left = 0, right = 0;
        int[] s2Frequency = new int[26];
        while (right < s2.length()) {
            s2Frequency[s2.charAt(right) - 'a']++;

            // check if window size is proper and if proper window size check if frequency match
            int windowSize = right - left + 1;
            if (windowSize == s1.length()) {
                if (Arrays.equals(s1Frequency, s2Frequency)) {
                    return true;
                }
//                if (frequencyMatch(s1Frequency, s2Frequency)) {
//                    return true;
//                }
            }
            // windowSize is >= s1 length but answer is not in this window
            if (windowSize >= s1.length()) {
                s2Frequency[s2.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return false;
    }

    public static boolean frequencyMatch(int[] s1Frequency, int[] s2Frequency) {
        for (int i = 0; i < 26; i++) {
            if (s1Frequency[i] != s2Frequency[i]) {
                return false;
            }
        }
        return true;
    }

}
