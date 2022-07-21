package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        //process the first window
        for(int i=0;i<k;i++){;
            while(!q.isEmpty() && nums[q.peekLast()]<= nums[i]){
                q.removeLast();
            }

            q.addLast(i);
        }
        ans.add(nums[q.peekFirst()]);
        // Process rest of the Array elements
        for(int i=k;i<nums.length;i++){


            // Remove all elements which are out of this
            // window
            while(!q.isEmpty() && i-q.peekFirst() >=k){
                q.removeFirst();
            }

            // remove all previous smaller elements  that are
            // are useless
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.removeLast();
            }

            q.addLast(i);
            ans.add(nums[q.peekFirst()]);
        }


        int[] result = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }



        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
}
