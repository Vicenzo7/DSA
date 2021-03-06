package StringProblems;

//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String str ="the sky is blue";
        String ans=reverseWords(str);
        System.out.println(ans);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");
        for(int i=s1.length-1;i>=0;i--)
        {
            String st = s1[i];
            if(!st.isEmpty())
            {
                if(sb.length()!=0)
                    sb.append(" ");
                sb.append(st);
            }
        }

        StringBuilder sa = new StringBuilder(sb);
        System.out.println(sa.reverse());
        return sb.toString();
    }
}
