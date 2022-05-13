package StringProblems;

public class BSubstringOfA {
    public static void main(String[] args) {
        String A= "gksrek";
        String B = "geeksforgeeks";
        System.out.println(isSubSequence(A,B));
    }

    static boolean isSubSequence(String A, String B){
        int j=0;
        for(int i=0;i<B.length();i++)
        {
            if(B.charAt(i)==A.charAt(j))
            {
                j++;
            }
            if(j==A.length())
            {
                return true;
            }
        }

        return false;
    }
}
