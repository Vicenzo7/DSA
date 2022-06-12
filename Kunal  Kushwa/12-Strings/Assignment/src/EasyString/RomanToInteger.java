package EasyString;

public class RomanToInteger {
    public static void main(String[] args) {
        String s= "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {

        int sum=0;
        for (int i = 0; i < s.length()-1 ; i++) {
            System.out.println(s.charAt(i));
            if(getRoman(s.charAt(i)) >= getRoman(s.charAt(i+1)))
            {
                sum += getRoman(s.charAt(i));
            }else{
                sum -= getRoman(s.charAt(i));
            }
        }

        // to get last char element
        sum += getRoman(s.charAt(s.length()-1));

        return sum;
    }


    public static int getRoman(char ch) {
        if(ch == 'I')
            return 1;
        else if(ch == 'V')
            return 5;
        else if(ch == 'X')
            return 10;
        else if(ch == 'L')
            return 50;
        else if(ch == 'C')
            return 100;
        else if(ch == 'D')
            return 500;
        else
            return 1000;
    }

}
