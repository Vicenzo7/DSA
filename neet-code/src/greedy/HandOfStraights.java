package greedy;

import java.util.*;

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
//        int[] hand = {2, 1};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
        System.out.println(isNStraightHandS(hand, groupSize));
    }

    public static boolean isNStraightHandS(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> cardFrequencyMap = new HashMap<>();
        for (int card : hand) {
            cardFrequencyMap.put(card, cardFrequencyMap.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);
        for (int card : hand) {
            Integer cardCount = cardFrequencyMap.get(card);
            if (cardCount <= 0) {
                continue;
            }
            for (int i = 1; i < groupSize; i++) {
                int sequenceCard = card + i;
                Integer sequenceCardCount = cardFrequencyMap.getOrDefault(sequenceCard, 0);
                if (sequenceCardCount > 0) {
                    cardFrequencyMap.put(sequenceCard, sequenceCardCount - 1);
                } else {
                    return false;
                }
            }
            cardFrequencyMap.put(card, cardCount - 1);
        }

        return true;
    }


    /*
         Using Priority Queue
         1. Add all the cards in the queue
         2. Iterate the min heap and remove the smallest element (i.e. root)
         3. Check if the minHeap contains smallest+1, if yes remove that from the heap.
         If not present return false;
    */
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i : hand) {
            minHeap.offer(i);
        }

        while (!minHeap.isEmpty()) {
            Integer smallest = minHeap.poll();
            for (int i = 1; i < groupSize; i++) {
                if (minHeap.contains(smallest + i)) {
                    minHeap.remove(smallest + i);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}
