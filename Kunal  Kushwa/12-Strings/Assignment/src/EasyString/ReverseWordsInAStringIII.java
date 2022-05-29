package EasyString;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder output = new StringBuilder();
        String[] st = s.split(" ");

        for (int x = 0; x < st.length; x++) {
            String str = reverse(st[x]);
            output.append(str);

            if ( x != st.length-1)
                output.append(" ");
        }
        return output.toString();
    }

    private static String reverse(String x) {
        char[] ch = x.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }
}
