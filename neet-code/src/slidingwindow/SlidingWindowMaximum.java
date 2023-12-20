package slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // have take a deque, so we can remove elements from first and last also
        // first because that element is not in the window,
        // last because we want maximum and in deque we will be storing in monotonically decreasing order
        Deque<Integer> deque = new ArrayDeque<>(); // contains indices
        int[] output = new int[nums.length - k + 1];
        int counter = 0;

        // process the first window
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.add(i);
        }

        output[counter] = nums[deque.getFirst()];
        counter++;

        // process the remaining window
        for (int i = k; i < nums.length; i++) {
            // check if window size exceeds, if exceeds reduce window size
            while (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.removeFirst();
            }

            // pop smaller values from the deque
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.add(i);
            output[counter] = nums[deque.getFirst()];
            counter++;
        }
        return output;
    }
}
