package StringProblems;



public class ReverseString {
    public static void main(String[] args) {
        String str1 = "MADAM";
        System.out.println(reverseString(str1));

        //approach 1
        //Example - Without library method.
//        String str2 = "SATYA";
//        StringBuffer newStr =new StringBuffer();
//        for(int i = str2.length()-1; i >= 0 ; i--) {
//            newStr = newStr.append(str2.charAt(i));
//        }
//        if(str2.equalsIgnoreCase(newStr.toString())) {
//            System.out.println("String is palindrome");
//        } else {
//            System.out.println("String is not palindrome");
//        }
//
//
//        //Approach 2
//        //Example - With library method.
//        String str3 = "NITIN";
//        String reverse = new StringBuffer(str3).reverse().toString();
//        if (str3.equals(reverse))
//            System.out.println("String is palindrome");
//        else
//            System.out.println("String is not palindrome");

    }





    private static boolean reverseString(String str) {
        int start=0;
        int end=str.length()-1;
        StringBuffer newStr = new StringBuffer();

        for (int i = end; i >=0 ; i--) {
            newStr= newStr.append(str.charAt(i));
        }
        System.out.println(newStr);

        if(str.equalsIgnoreCase(newStr.toString()))
        {
            return true;
        }
        return false;
    }
}
