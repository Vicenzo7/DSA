package greedy.a2z;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
//        int[] g = {1, 2}, s = {1, 2, 3};
        int[] g = {1, 2, 3}, s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        // just assign cookies to the children from min greediness to max
        Arrays.sort(g);
        Arrays.sort(s);

        // iterate the cookies and give them to less greediness child first, if we are able to give,
        // then ony we move to next child
        int i = 0;
        for(int j = 0;j < s.length && i < g.length;j++) {
            if(s[j] >= g[i]) {
                i++;
            }
        }

        return i;
    }
}
