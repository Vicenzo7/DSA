package RecursionUnacedemy;

import javax.sound.midi.Soundbank;

//https://leetcode.com/problems/decode-string/
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(s);
        System.out.println(decodeString(s));
    }

    //pointer
    static int index = 0;
    public static String decodeString(String s) {
        //to store digits;
        int cur = 0;
        StringBuilder sb = new StringBuilder();

        while(index<s.length())
        {
            char ch = s.charAt(index++);
            //checking if char is a digit
            if(ch>= '0' && ch<= '9')
            {
                // we are multiplying by 10 because what if there are many digits which makes it two or three digit number
                cur = cur*10+(ch -'0');
            }else if(ch == '['){
                String st = decodeString(s);
                // add this string cur number of times
                while(cur >0)
                {
                    System.out.println(cur);
                    sb.append(st);
                    System.out.println(sb);
                    cur --;
                }
                cur=0;
            }
            // if close bracket found return the words with in the bracket
            else if(ch == ']')
            {
                return sb.toString();
            }
            // if not found anything simply append the char to a stringBuilder
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }

}
