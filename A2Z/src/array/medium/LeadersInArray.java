package array.medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};
        System.out.println(leaders(nums));
        System.out.println(leadersOptimal(nums));
    }

    /*
     * Leaders in array means an element which is greater than all the element on it right side*/

    public static ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> leaders = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (isLeader(nums, nums[i], i + 1)) {
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }

    private static boolean isLeader(int[] nums, int target, int start) {
        for (int j = start; j < nums.length; j++) {
            if (target < nums[j]) {
                return false;
            }
        }
        return true;
    }

    /*
     *
     * Optimal Approach
     * Since we know that last element is always going to be one of the answer lets add it into the answer.
     *
     * In the first approach we are again and again checking if the current element is the leader,
     * An Optimal approach would be if we carefully think
     * We can traverse from the back and for an element to be a leader instead of checking the whole right side
     * we could keep a track of the greatest element encountered till now from the back
     *
     * So here to check if the currentElement leader, currentElement should be greater than the greatest element
     *  encountered from the back
     * */


    public static ArrayList<Integer> leadersOptimal(int[] nums) {
        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(nums[nums.length - 1]);
        int greatestElementFromBack = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= greatestElementFromBack) {
                leaders.add(nums[i]);
                greatestElementFromBack = nums[i];
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
