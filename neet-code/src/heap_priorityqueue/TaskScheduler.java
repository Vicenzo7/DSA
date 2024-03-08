package heap_priorityqueue;

import util.CustomPair;

import java.util.*;


public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'C','C'};
        int n = 1;

        System.out.println(leastInterval(tasks, n));
    }

    /*
        TC = O(n) to count the frequency + O(log(26)) because we will get only upper case alphabets
        SC = (n)

    */


    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char task : tasks) {
            frequencyMap.put(task, frequencyMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(frequencyMap.values());

        int time = 0;
        Queue<CustomPair<Integer, Integer>> queue = new ArrayDeque<>();
        // above queue to store pair -> remaining task and when it can be processed(ideal time)

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time += 1;
            if (!maxHeap.isEmpty()) {
                Integer task = maxHeap.poll();
                task = task - 1;
                if (task != 0) {
                    queue.add(new CustomPair<>(task, time + n));
                }
            }

            if (!queue.isEmpty() && time == queue.peek().getValue()) {
                maxHeap.offer(queue.poll().getKey());
            }

        }
        return time;
    }
}
