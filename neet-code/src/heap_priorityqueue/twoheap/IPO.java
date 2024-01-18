package heap_priorityqueue.twoheap;

import util.CustomPair;

import java.util.PriorityQueue;
import java.util.Queue;

public class IPO {
    public static void main(String[] args) {
        int k = 1, w = 2;
        int[] profits = {1, 2, 3};
        int[] capital = {1, 1, 2};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        /*
            In the min heap we will store capital,profit sorted by capital
            In the max heap we will store capital,profit sorted by profit

            1.We will add all the object (capital,profit) to min heap, so we can start with the minimum capital investment
            2. We will iterate the minHeap and check if we can afford that project with the initial capital we have,
                if we can, we will take that project from min heap and put in maxHeap.
                Like this we will put as many project we can afford
            3. If the maxHeap is empty that means we can't afford any project and so, we will break out and return the profit
            4. If max heap is not empty then we will take the first project from the max heap and add to our initial profit.
            5. Like this we will do for K projects
        */
        Queue<CustomPair<Integer, Integer>> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.getKey(), o2.getKey())); // sorting by capital in ascending order
        Queue<CustomPair<Integer, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())); // sorting by profit in descending order

        // custom pair -> capital, profit
        for (int i = 0; i < profits.length; i++) {
            minHeap.offer(new CustomPair<>(capital[i], profits[i]));
        }

        while (k > 0) {
            // adding the projects that we can afford
            while (!minHeap.isEmpty() && minHeap.peek().getKey() <= w) {
                maxHeap.offer(minHeap.poll());
            }

            // means we can't afford any project
            if (maxHeap.isEmpty()) {
                break;
            }

            // means we can afford some project, and we will take the project with the highest profit and add that profit to our
            // initial investment for we can take more projects
            w += maxHeap.poll().getValue();
            k--;
        }

        return w;
    }


}
