package strings.easy;

import java.util.Arrays;
import java.util.StringJoiner;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        System.out.println(reverseWordsOptimal(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");

        int start = 0, end = words.length - 1;
        while (start <= end) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : words) {
            joiner.add(word);
        }

        return joiner.toString();
    }

    /*
        Using a single for loop
        split the sentence into words by space
        traverse the words from backwards as we want to reverse the sentence,
        check if each word is not empty and append space to the answer only if answer is not empty
        or else append the words

        TC = O(n)
        SC = O(n)
    */
    public static String reverseWordsOptimal(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isBlank()) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }
}
