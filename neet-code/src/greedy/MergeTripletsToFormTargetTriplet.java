package greedy;

import java.util.ArrayList;
import java.util.List;

public class MergeTripletsToFormTargetTriplet {
    public static void main(String[] args) {
        int[][] triplets = {
//                {2, 5, 3},
//                {1, 8, 4},
//                {1, 7, 5}
//                {3, 4, 5}, {4, 5, 6},
                {2, 5, 3}, {2, 3, 4}, {1, 2, 5}, {5, 2, 3}
        };
        int[] target = {5, 5, 5};
        System.out.println(mergeTriplets(triplets, target));
        System.out.println(mergeTripletsOptimised(triplets, target));
    }

    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> list = new ArrayList<>();

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            list.add(triplet);
        }

        boolean[] present = new boolean[3];
        for (int[] triplet : list) {
            if (triplet[0] == target[0]) {
                present[0] = true;
            }
            if (triplet[1] == target[1]) {
                present[1] = true;
            }
            if (triplet[2] == target[2]) {
                present[2] = true;
            }
        }

        return present[0] && present[1] && present[2];
    }

    public static boolean mergeTripletsOptimised(int[][] triplets, int[] target) {
        boolean[] present = new boolean[3];
        for (int[] triplet : triplets) {
            // If any triplet is highest then target discarding it
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            // checking if any triplet have value equal to target, the marking it present
            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    present[i] = true;
                }
            }
        }


        // is all target value are present means we can form a answer.
        return present[0] && present[1] && present[2];
    }
}
