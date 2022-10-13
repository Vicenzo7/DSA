package strings;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        permutation("", str);
        ArrayList<String> ans = new ArrayList<>();
        permutation("", str, ans);
        System.out.println();
        System.out.println(ans);

        System.out.println(permutationList("", str));

        System.out.println(permutationCount("",str));
    }


    static void permutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutation(f + ch + s, up.substring(1));
        }
    }

    static void permutation(String p, String up, ArrayList<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutation(f + ch + s, up.substring(1), ans);
        }
    }

    static ArrayList<String> permutationList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationList(f + ch + s, up.substring(1)));
        }

        return ans;
    }


    static int permutationCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);
        int count =0;
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationCount(f + ch + s, up.substring(1));
        }

        return count;
    }

}
