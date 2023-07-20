package binarysearch.bsInSearchSpace;

import java.util.*;

public class MinimizeMaxDistanceToGasStation {
    public static void main(String[] args) {
        int[] stations = {1, 13, 17, 23};
        int K = 5;
        System.out.println(minimiseMaxDistance(stations, K));
//        System.out.println(minimiseMaxDistance2(stations, K));
        System.out.println(findSmallestMaxDist(stations, K));
    }


    public static double findSmallestMaxDist(int[] stations, int K) {
        double low = 0, high = stations[stations.length - 1] - stations[0];

        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;

            if (isPossible(stations, mid, K)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;

    }

    private static boolean isPossible(int[] stations, double distance, int k) {
        int newStationsToBeAdded = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            newStationsToBeAdded += Math.floor((stations[i + 1] - stations[i]) / distance);
        }

        return newStationsToBeAdded <= k;
    }

    /*
        [1, 2, 3, 4, 5] k = 4

        adding stations randomly
        1 2 3 4 5 6 7 8 9

        so difference between any two station is 1

        can we minimize this distance;

        Now placing at decimal co-ordinates

        1 1.25 1.5 1.75 2 3 4 4.5 5

        difference between the gas station is
        0.25, 0.25, 0.25 ,0.25, 1 , 1, 0.5, 0.5 -> so max among this is 1

        now again lets try
        1 1.5 2 2.5 3 3.5 4 4.5 5
        difference between the gas station is
        0.5 0.5 0.5 0.5 0.5 0.5 0.5 0.5 -> max is 0.5

        can we do it better: no
           because if we pick up any two the max distance must be minimized


        0.5 was simple,what if the answer was 0.635625682
        In this case there is a note
        Answer within 10^-6 of the actual answer will be accepted

        Now lets take another example

        [1 7]  k = 2
        placing outside the boundary
        1 7 8 9
        difference 6, 1, 1. -> max is 6
        we didn't minimize the max distance between the existing gas station
        from this example it is clear that there is no use to place new gas station outside the boundary

        The ideal scenario is to place it between the boundaries

        let's place it like this
        1 2 4 7
        difference
        1 2 3 -> max is 3

        We want to minimize all distance between the gas station

        difference between 1 and 7 is 6 and 6/3 = 2
        1 3 5 7
        difference is 2 max = 2. So ideal solution is 2



        Another example is
        [1 13 17 23] k = 5

        so there are 3 section where we need to place the 5 new gas stations
        Now the distance between gas station is
        12 4 6

        let's place 1 gas station at 7

        1 7 13 17 23
        difference
        6 6 4 6

        let's minimize the 6 so lets place between 17 and 23
        1 7 13 17 20 23

        difference is 6 6 4 3 3 lets reduce the 6

        Now if we place the third station at 1 ,7 or 7,13
        7-1 = 6/2 = 3

        its 1 4 7 13 17 20 23 but the max is still 6

        same if we place between 7 and 13 it will result in the same.

        let's say instead of placing the first at 7, we don't place it there we
        now have 2 gas station to be place we get
        1 13 17 20 23

        13-1 = 12/3 = 4
       divided by 3 because we will place 2 gas stations
       between 1 and 13
       1 <-> _ <-> _ <-> 13

       So the number of distance between gas station is 3
       1 5 9 13 17 20 23
       difference is 4 4 4 4 3 3 max distance is 4


       now 1 13 17 23 originally has difference

       4 4 3 lets minimize 4

       1 13 15 17 23
       difference is 4 2 2 3  so out of 5 4 gas stations are placed

       now at 1 and 13 there are already 2 there at 5 and 9
        if we want to add one more it is 3 station so the number of distance between gas station is 4
        13 - 1 = 12
        12/4 = 3
        1 4 7 10 13 15 17 20 23
        difference is 3 3 3 3 2 2 3

        So the ideal solution is this and its max distance is 3

        Brute force
        TC = O(k*n +n)

        Section length is the distance between the two station
        eg 1 <-> 13
        13 -1 = 12 is the distance between 1 and 13 gas station and if we plan to place 5 new gas station between 1 and 13
        then section length is 12/(5+1) = 2

       */


    public static double minimiseMaxDistance(int[] arr, int K) {
        int n = arr.length;
        List<Integer> howMany = new ArrayList<>(Collections.nCopies(arr.length - 1, 0));
        for (int gasStation = 1; gasStation <= K; gasStation++) {
            double maxSection = -1;
            int maxIndex = -1;
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (howMany.get(i) + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }
            howMany.set(maxIndex, howMany.get(maxIndex) + 1);

        }

        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (howMany.get(i) + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }

    /*
        Let's reduce the time complexity using max heap -> priority queue
    */
//    public static double minimiseMaxDistance2(int[] arr, int K) {
//        List<Integer> howMany = new ArrayList<>(Collections.nCopies(arr.length - 1, 0));
//        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> {
//            // Compare by the first element in reverse order
//            int firstComparison = Double.compare(p2.sectionLength, p1.sectionLength);
//
//            // If the first elements are equal, compare by the second element in ascending order
//            if (firstComparison == 0) {
//                return Integer.compare(p2.index, p1.index);
//            }
//
//            return firstComparison;
//        });
//
//        // initially fill the original section length
//        for (int i = 0; i < arr.length - 1; i++) {
//            maxHeap.add(new Pair((double) arr[i + 1] - arr[i], i));
//        }
//        for (int gasStation = 1; gasStation <= K; gasStation++) {
//            Pair pair = maxHeap.poll();
//            int sectionIndex = pair.index;
//            howMany.set(sectionIndex, howMany.get(sectionIndex) + 1);
//            double initialDifference = arr[sectionIndex + 1] - arr[sectionIndex];
//            double newSectionLength = initialDifference / howMany.get(sectionIndex) + 1;
//            maxHeap.add(new Pair(newSectionLength, sectionIndex));
//        }
//
//
//        return maxHeap.peek().sectionLength;
//    }

}

//class Pair {
//    double sectionLength;
//    int index;
//
//    public Pair(double sectionLength, int index) {
//        this.sectionLength = sectionLength;
//        this.index = index;
//    }
//
//}
