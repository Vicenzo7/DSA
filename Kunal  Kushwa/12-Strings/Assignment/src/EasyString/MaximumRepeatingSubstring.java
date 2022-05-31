package EasyString;


public class MaximumRepeatingSubstring {
    public static void main(String[] args) {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        System.out.println(maxRepeating(sequence, word));
    }

    public static int maxRepeating(String sequence, String word) {

        int count = 0;
        String original = word;
        while (sequence.contains(word)) {
            count++;
            word = word + original;
        }
        return count;
    }
}
