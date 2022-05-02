package Easy;
import java.util.Arrays;

public class SmallerThantheCurrentNumber {
    public static void main(String[] args) {
        int[] arr ={8,1,2,2,3};
        int[] results = smallerNumbersThanCurrent(arr);
        System.out.println(Arrays.toString(results));

    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] results = new int[nums.length];
        int count ;

        for(int i=0; i < nums.length; i++){
            count=0;
            for(int j=0; j < nums.length; j++){

                if(j != i && nums[j] < nums[i])
                {
                    count++;
                }
            }
            results[i]= count;
        }
        return results;
    }
}
