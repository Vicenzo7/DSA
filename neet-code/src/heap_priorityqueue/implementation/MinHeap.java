package heap_priorityqueue.implementation;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    // leftChild = heap[2 * i]
    // rightChild = heap[(2 * i) + 1]
    // parent = heap[i / 2]
    List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>() {{
            add(0); // for skipping the 0'th index
        }};
    }


    // TC = O(log(n)) = O(height of the tree)
    public void push(int val) {
        heap.add(val);

        // percolate up
        int i = heap.size() - 1;
        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int temp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, temp);

            i = i / 2;
        }
    }

    public int pop() {
        // check if heap is empty
        if (heap.size() == 1) {
            System.out.println("Heap is empty");
            return -1;
        }

        // check if heap has only one element
        if (heap.size() == 2) {
            return heap.remove(heap.size() - 1);
        }

        int res = heap.get(1);
        // move last value to the root
        heap.set(1, heap.remove(heap.size() - 1));
        int i = 1;
        // percolate down if at least left child exist
        percolateDown(i);

        return res;
    }

    private void percolateDown(int i) {
        while (2 * i < heap.size()) {
            /*
                now we know left child is present, check if right child is present and
                right child is smaller than left child and also smaller than parent
                swap right child with parent and percolate right
            */
            if (2 * i + 1 < heap.size() &&
                    heap.get(2 * i + 1) < heap.get(2 * i) &&
                    heap.get(2 * i + 1) < heap.get(i)) {
                // Swap right child
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set(2 * i + 1, tmp);
                i = 2 * i + 1;
            } else if (heap.get(2 * i) < heap.get(i)) { // means left child < parent
                // Swap left child
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i, tmp);
                i = 2 * i;
            } else { // satisfies order property
                break;
            }
        }
    }


    // Tc =  O(n)
    public void heapify(List<Integer> list) {
        // correct the structure
        list.add(list.get(0));

        this.heap = list;

        // start from the node which has children
        int curr = (heap.size() - 1) / 2;

        while (curr > 0) {
            int i = curr;
            percolateDown(i);
            curr -= 1;
        }
    }

}
