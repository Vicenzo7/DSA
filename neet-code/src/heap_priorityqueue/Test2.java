package heap_priorityqueue;

import heap_priorityqueue.implementation.MaxHeap;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("Max heap start");
        MaxHeap maxHeap = new MaxHeap();
        System.out.println(maxHeap.pop());
        maxHeap.push(20);
        maxHeap.push(30);
        maxHeap.push(40);
        maxHeap.push(50);

        System.out.println(maxHeap.pop()); // 50
        System.out.println(maxHeap.pop()); // 40
        System.out.println(maxHeap.pop()); // 30
        System.out.println(maxHeap.pop()); // 20


        List<Integer> list2 = new ArrayList<>();
        list2.add(30);
        list2.add(50);
        list2.add(30);
        list2.add(100);
        list2.add(29);
        list2.add(12);
        System.out.println("heapifying");
        maxHeap.heapify(list2);

        System.out.println(maxHeap.pop()); // 100
        System.out.println(maxHeap.pop()); // 50
        System.out.println(maxHeap.pop()); //30
        System.out.println(maxHeap.pop()); //30
        System.out.println(maxHeap.pop()); // 29
        System.out.println(maxHeap.pop()); // 12
    }
}
