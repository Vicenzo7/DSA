package heap_priorityqueue.twoheap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    /*
        Q. Implement a median finder where new values are inserted into
        the set and you have to getMedian

    */

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());  // max heap
        large = new PriorityQueue<>();  // min heap
    }

    public void addNum(int num) {
        // push to max heap and swap to min heap if needed
        small.add(num);
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            Integer val = small.poll();
            large.add(val);
        }

        // handle the un even case
        if (small.size() - large.size() > 1) {
            Integer val = small.poll();
            large.add(val);
        }

        if (large.size() - small.size() > 1) {
            Integer val = large.poll();
            small.add(val);
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }


        return (small.peek() + large.peek()) / 2.0;
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());

    }
}