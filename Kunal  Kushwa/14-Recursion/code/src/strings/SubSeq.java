package strings;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        String s = "abc";
//        subseq("", s);
//        ArrayList<String> ans = new ArrayList<>();
//        subseq("", s, ans);
//        System.out.println(ans);

        System.out.println(subseqReturn("",s));
    }



    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        //include
        subseq(p + ch, up.substring(1));
        //exclude
        subseq(p, up.substring(1));
    }

    private static void subseq(String p, String up, ArrayList<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }

        char ch = up.charAt(0);
        //include
        subseq(p + ch, up.substring(1), ans);
        //exclude
        subseq(p, up.substring(1), ans);

    }


    static ArrayList<String> subseqReturn(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        //include
        ArrayList<String> left = subseqReturn(p + ch, up.substring(1));
        //exclude
        ArrayList<String> right = subseqReturn(p, up.substring(1));

        left.addAll(right);
        return left;

    }
}
