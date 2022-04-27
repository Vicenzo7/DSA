package Easy;
import java.util.ArrayList;

public class PlusOne {
    public static void main(String[] args) {
        int[] input = {9,9,9};
        int [] result= plus0ne(input);
        for(int i:result)
        {
            System.out.print(i+" ");
        }
    }

    private static int[] plus0ne(int[] input) {
        int index = input.length-1;
       while(index >= 0)
       {
           if(input[index] == 9)
           {
               input[index] =0;

           }
           else
           {
               input[index] += 1;
               return input;
           }
           index--;
       }
       int[] ans = new int[input.length +1];
       ans[0]=1;
       return ans;
    }


}
