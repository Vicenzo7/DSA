package Problems;

import java.util.Arrays;

public class KQueue {
    int k;
    int n;
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int freeSpot;

    public KQueue(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);

        next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }

        next[n - 1] = -1;

        freeSpot = 0;
    }

    void enqueue(int data, int qn) {

        //check for overflow
        if (freeSpot == -1) {
            System.out.println("No free space to enter element");
            return;
        }

        //find first free index
        int index = freeSpot;

        //update freeSpot
        freeSpot = next[index];

        //check if element to be entered is the first element in the queue
        if (front[qn - 1] == -1) {
            front[qn - 1] = index;
        } else {
            //link
            next[rear[qn-1]] = index;
        }

        //update index since its used
        next[index] = -1;

        //update rear
        rear[qn - 1] = index;

        //insert element
        arr[index] = data;
    }


    int dequeue(int qn) {
        // check for underflow
        if (front[qn-1] == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }

        //find index to pop
        int index = front[qn - 1];

        // move the front
        front[qn - 1] = next[index];


        //manage the freespot
        next[index] = freeSpot;
        freeSpot = index;
        return arr[index];
    }

    public static void main(String[] args) {
        KQueue q = new KQueue(10, 3);
        q.enqueue(10, 1);
        q.enqueue(15, 1);
        q.enqueue(20, 2);
        q.enqueue(25, 1);

        System.out.println(q.dequeue(1));
        System.out.println(q.dequeue(2));
        System.out.println(q.dequeue(1));

    }
}
