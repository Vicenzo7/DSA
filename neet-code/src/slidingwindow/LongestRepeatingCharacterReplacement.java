package slidingwindow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int[] array = new int[26]; // to keep character frequency
        int left = 0;
        int maxLength = 0;
        int maxCharacterCount = 0; // to keep track of max character count till now
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            int index = ch - 'A';
            array[index]++;
            maxCharacterCount = Math.max(maxCharacterCount, array[index]);
            // means window is not of proper size, also it means to make this longest repeating
            // we have to do more than k replacement which does not permit, so we reduce the window size
            // and also the frequency of the character which was at left
            if ((right - left + 1) - maxCharacterCount > k) {
                array[s.charAt(left) - 'A']--;
                left += 1;
            }
            maxLength = Math.max(maxLength, (right - left + 1));
        }
        return maxLength;
    }
}
