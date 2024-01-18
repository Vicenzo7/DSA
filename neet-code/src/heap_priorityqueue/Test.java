package heap_priorityqueue;

import heap_priorityqueue.implementation.MinHeap;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        System.out.println("Min Heap start");
        System.out.println(minHeap.pop());
        minHeap.push(120);
        minHeap.push(100);
        minHeap.push(80);

        System.out.println(minHeap.pop()); // 80
        System.out.println(minHeap.pop()); // 100
        System.out.println(minHeap.pop()); // 120


        List<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(50);
        list.add(30);
        list.add(100);
        list.add(29);
        list.add(12);
        System.out.println("heapifying");
        minHeap.heapify(list);

        System.out.println(minHeap.pop()); //12
        System.out.println(minHeap.pop()); //29
        System.out.println(minHeap.pop()); //30
        System.out.println(minHeap.pop()); //30
        System.out.println(minHeap.pop()); // 50
        System.out.println(minHeap.pop()); // 100

    }
}
