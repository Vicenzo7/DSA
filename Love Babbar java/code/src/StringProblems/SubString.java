package StringProblems;

public class SubString {
    public static void main(String[] args) {
        String A = "GeeksForGeeks";
        String B = "Fr";
        System.out.println(substr(A, B));
    }

    static int substr(String s, String x) {
        int i = 0;
        int j = 0;
        for (; i < s.length(); i++) {
            //check if j has reached the length of second array
            if (j == x.length()) {
                break;
            }
            if (s.charAt(i) == x.charAt(j)) {
                j++;
            } else {
                //if j is greater than zero and does not match next character start to search substring from i=i-j and initialise j=0
                if (j > 0) {
                    i = i - j;
                }
                j = 0;
            }
        }
        return j == x.length() ? i - j : -1;
    }
}
