//Find N Unique Integers Sum up to Zero
package Easy;
import java.util.Arrays;

public class IntegersSumuptoZero {
    public static void main(String[] args) {
        int n=50;
        int[] ans =sumZero(n);
        for(int a:ans)
        {
            System.out.print(a+" ");
        }
    }

    public static int[] sumZero(int n){
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 2*i - n+1;
        }
        return result;
    }
}
