package StringProblems;

public class RotationOfEachOther {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";
        System.out.println(areRotations(s1,s2));
    }


    public static boolean areRotations(String s1, String s2 )
    {
        //if length of both strings are not equal return false
        if(s1.length()!= s2.length())
            return false;
        //concatenate String1 with String one
        String temp=s1+s1;
        System.out.println(temp);
//        if(temp.contains(s2))
//            return true;

        return substr(temp,s2);

    }

    static boolean substr(String s, String x) {
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
        return j == x.length() ? true : false;
    }


}
