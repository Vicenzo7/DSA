package heap_priorityqueue;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    /*
        Intuition: Min Heap of size K

        We will create a min heap and in the min heap we will put element of k size,
        so we can get the kth Largest element

        While adding in heap, if the size of heap is less than k, keep adding
        if the heap size is equal to k, then  while adding the element check if the element is
        greater than the kth largest element

        If it is greater, remove the kth largest element and add the current element so it becomes the kth largest
        element.


        TC = O(n * log(k))
        SC = O(k)

        adding n elements and to add an element in PriorityQueue TC is O(log(n))
    */

    private PriorityQueue<Integer> heap;

    private int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.add(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});

        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}