package MediumString;

public class RepeatedStringMatch {
    public static void main(String[] args) {
        String a = "a", b = "aa";
        System.out.println(repeatedStringMatch(a,b));
    }

    public static int repeatedStringMatch(String a, String b) {

        String pattern = a;
        if(pattern.contains(b))
            return 0;

        int count =1;

        while(a.length() <= 10000)
        {
            if(a.contains(b))
            {
                return count;
            }else{
                a = a+pattern;
                count++;
            }
        }

        return -1;



    }
}
