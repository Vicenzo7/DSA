package arrayhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("lint", "code", "love", "you");
        String encode = encode(list);
        System.out.println(encode);
        System.out.println(decode(encode));
    }

    public static String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str.length()).append("#").append(str);
        }
        return stringBuilder.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int wordLength = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j + 1, j + 1 + wordLength);
            result.add(word);
            i = j + 1 + wordLength;
        }
        return result;
    }
}
