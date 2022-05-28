package EasyString;
//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
         String[] word1 = {"ab", "c"};
         String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();

        for(String x: word1)
            sb.append(x);

        String str1= sb.toString();

        sb.setLength(0);

        for(String x: word2)
            sb.append(x);

        String str2 = sb.toString();

        if(str1.equals(str2))
            return true;

        return false;


    }
}
