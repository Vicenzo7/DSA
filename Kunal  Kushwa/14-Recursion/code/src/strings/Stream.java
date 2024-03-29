package strings;

public class Stream {
    public static void main(String[] args) {
        String s = "baccadah";
//        skip("", s);
//        System.out.println(skip(s));
//        System.out.println(skipApple("abababcdapplecdad"));
        System.out.println(skipAppNotApple("bcappappleappcd"));

    }


    public static void skip(String p, String up) {
        // base case
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if (ch == 'a') {
            skip(p, up.substring(1));
        } else {
            skip(p + ch, up.substring(1));
        }

    }


    public static String skip(String up) {
        // base case
        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);
        if (ch == 'a') {
            return skip(up.substring(1));
        } else {
            return ch + skip(up.substring(1));
        }

    }


    public static String skipApple(String up) {
        // base case
        if (up.isEmpty()) {
            return "";
        }


        if (up.startsWith("apple")) {
            return skipApple(up.substring(5));
        } else {
            return up.charAt(0)+ skipApple(up.substring(1));
        }

    }

    public static String skipAppNotApple(String up) {
        // base case
        if (up.isEmpty()) {
            return "";
        }


        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipAppNotApple(up.substring(3));
        } else {
            return up.charAt(0)+ skipAppNotApple(up.substring(1));
        }

    }
}
