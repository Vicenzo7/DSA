//Add to Array-Form of Integer
package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddtoArrayFormofInteger {
    public static void main(String[] args) {

        int[] input = {1,2,0,0};
        int k = 34;
        List<Integer>  ans = new ArrayList<>();
        ans = addToArrayForm(input,k);
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
       int n = num.length;
       int i=n;
       while(--i>= 0 || k>0){
           if(i>=0){
               result.add((num[i]+k)%10);
               k= (num[i]+k)/10;
           }
           else{
               result.add(k%10);
               k=k/10;
           }

       }
       Collections.reverse(result);
        System.out.println(result);

       return  result;
    }
}
