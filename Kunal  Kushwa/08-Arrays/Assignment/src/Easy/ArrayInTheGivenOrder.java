//Create Target Array in the Given Order
package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayInTheGivenOrder {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        int[] results = createTargetArray(nums,index);
        System.out.println(Arrays.toString(results));

    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ans.add(index[i],nums[i]);
        }
//      int[] target = new int[ans.size()]; // can also be used
        int[] target = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            target[i] = ans.get(i);
        }
        return target;
    }
}
