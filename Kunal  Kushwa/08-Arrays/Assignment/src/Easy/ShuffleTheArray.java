package Easy;
import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = { 1,1,2,2};
        int[] result = shuffle(nums,2);
        System.out.println(Arrays.toString(result));
    }


    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int fh=0,sh=n;

        for (int i =0 ; i < 2*n; i++) {
                if(i%2==0){
                    ans[i] =nums[fh];
                    fh++;
                }
                else{
                    ans[i] =nums[sh];
                    sh++;

                }
        }





        return ans;
    }
}
