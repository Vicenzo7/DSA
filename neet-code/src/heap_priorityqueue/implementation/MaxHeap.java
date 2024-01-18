package heap_priorityqueue.implementation;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
        heap.add(0); // for skipping the 0'th index
    }

    public void push(int val) {
        heap.add(val); //add at the end

        //percolate up
        int i = heap.size() - 1;
        while (i > 1 && heap.get(i) > heap.get(i / 2)) {
            int temp = heap.get(i / 2);
            heap.set(i / 2, heap.get(i));
            heap.set(i, temp);
            i = i / 2;
        }
    }

    public int pop() {
        // if heap is empty
        if (heap.size() == 1) {
            System.out.println("Heap is empty");
            return -1;
        }

        if (heap.size() == 2) {
            return heap.remove(heap.size() - 1);
        }

        int res = heap.get(1);
        // move last value to the root
        heap.set(1, heap.remove(heap.size() - 1));

        // percolate down only if left child exist
        int i = 1;
        percolateDown(i);

        return res;
    }

    private void percolateDown(int i) {
        while (2 * i < heap.size()) {
            /*  now we know left child is present, check if right child is present and
                right child is greater than left child and also greater than parent
                swap right child with parent and percolate right
            */
            if (2 * i + 1 < heap.size() && heap.get(2 * i) < heap.get(2 * i + 1)
                    && heap.get(i) < heap.get(2 * i + 1)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set(2 * i + 1, temp);
                i = 2 * i + 1;
            } else if (heap.get(i) < heap.get(2 * i)) { // left child > than parent
                int temp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i, temp);
                i = 2 * i;
            } else { // satisfies order property
                break;
            }
        }
    }

    public void heapify(List<Integer> list) {
        // correct the structure
        list.add(list.get(0));

        this.heap = list;

        //start from the node which has children
        int curr = (heap.size() - 1) / 2;

        while (curr > 0) {
            int i = curr;
            percolateDown(i);
            curr -= 1;
        }
    }
}
