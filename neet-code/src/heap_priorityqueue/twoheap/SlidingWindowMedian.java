package heap_priorityqueue.twoheap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] nums = {7, 0, 3, 9, 9, 9, 1, 7, 2, 3};
        int k = 6;
        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }


    public static double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> small = new PriorityQueue<>(1, Collections.reverseOrder());
        PriorityQueue<Integer> large = new PriorityQueue<>();
        int counter = 0;
        double[] result = new double[nums.length - k + 1];
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // maintain window size
            if (right - left + 1 > k) {
                if (nums[left] > small.peek()) {
                    large.remove(nums[left]);
                } else {
                    small.remove(nums[left]);
                }
                left++;
                balanceHeap(small, large);
            }

            // Add element to the small heap and if needed shift to large heap
            small.add(nums[right]);
            if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
                Integer val = small.poll();
                large.offer(val);
            }

            // balance the heap so the difference between <= 1 to find median
            balanceHeap(small, large);

            if (right - left + 1 == k) {
                if (small.size() > large.size()) {
                    result[counter++] = small.peek();
                } else if (large.size() > small.size()) {
                    result[counter++] = large.peek();
                } else {
                    result[counter++] = small.peek() / 2.0 + large.peek() / 2.0;
                }
            }

        }

        return result;
    }

    private static void balanceHeap(PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        if (small.size() - large.size() > 1) {
            Integer val = small.poll();
            large.offer(val);
        } else if (large.size() - small.size() > 1) {
            Integer val = large.poll();
            small.offer(val);
        }
    }
}
