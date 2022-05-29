package EasyString;

public class DecryptStringFromAlphabetToIntegerMapping {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));

    }
    public static String freqAlphabets(String s) {
        String code ="";
        String result="";

        for (int i = 10; i <=26 ; i++) {
            code =String.valueOf(i)+"#";
            result = String.valueOf((char)(96+i));
            s=s.replace(code,result);
        }
        for (int i = 1; i <=9 ; i++) {
            code =String.valueOf(i);
            result = String.valueOf((char)(96+i));
            s=s.replace(code,result);
        }
        return s;
     }
}
