package EasyString;

import java.util.Arrays;

public class SortingTheSentence {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        sortSentence(s);
        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {

        //Splitting the string and storing in String array
        String[]  str = s.split(" ");
        String[] arr = new String[str.length];

        // traversing each string
        for(String i: str)
        {
            //since the position is at last we will retrieve it in the pos
            int pos = (int) (i.charAt(i.length()-1) -'0');
            //now at that particular postion we will put the word in a new array arr
            arr[pos-1] = i.substring(0,i.length()-1);
        }

        StringBuilder sb = new StringBuilder();
        //appending each string in string builder up till second last string and adding space
        for(int i = 0; i < arr.length-1; i++)
            sb.append(arr[i]).append(" ");

        //adding last string in string builder and not adding space
        sb.append(arr[arr.length-1]);
        return sb.toString();
    }
}
