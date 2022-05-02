package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        int results = largestAltitude(gain);
        System.out.println(results);
    }

    private static int largestAltitude(int[] gain) {
        int max=0;
        int sum=0;
        for (int i = 0; i < gain.length ; i++) {
            sum += gain[i];
            if(sum>max){
                max= sum;
            }

        }
        return max;
    }
}
