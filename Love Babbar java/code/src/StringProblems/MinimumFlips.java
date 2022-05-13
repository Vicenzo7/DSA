package StringProblems;

public class MinimumFlips {
    public static void main(String[] args) {
        String str="0010";
        int ans0=countFlips(str,'0');
        System.out.println(ans0);
        int ans1=countFlips(str,'1');
        System.out.println(ans1);
        int ans=Math.min(ans0,ans1);
        System.out.println(ans);


    }

    private static int countFlips(String str, char expected) {

        int cntFlips=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!=expected)
                cntFlips++;

            expected=flip(expected);
        }
        return cntFlips;
    }

    private static char flip(char expected) {
        if(expected=='0')
            return '1';
        return '0';
    }


}
