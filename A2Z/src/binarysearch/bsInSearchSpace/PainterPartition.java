package binarysearch.bsInSearchSpace;

import java.util.ArrayList;
import java.util.Arrays;

public class PainterPartition {
    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10,20,30,40));
        int k = 2;
        System.out.println(findLargestMinDistance(boards, k));
    }

    /*
        This problem is similar to book allocation, aggressive cows, koko eating bananas
        The search space is low = maxElement and high = sum of all elements
        calculate the mid and check if mid is a possible answer.
        If mid is a possible answer store and move towards left as we want minimum
        if mid is not an answer move towards the right.

        How to check if mid is and possible answer
        iterate the elements and sum them up to mid
        if the sum goes above the mid, assign this to one painter, ie: increment the painter count


        10 20 30 40 , k = 2
        10 - 20 30 40 -> (10 ,90) = 90
        10 20 - 30 40 -> (30 ,70) = 70
        10 20 30 - 40 -> (60 ,40) = 60

    **/

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int ans = -1;
        int max = 0, sum = 0;
        for (Integer board : boards) {
            max = Math.max(max, board);
            sum += board;
        }

        int low = max, high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleSolution(boards, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossibleSolution(ArrayList<Integer> boards, int mid, int painters) {
        int paintersCount = 1;
        int sum = 0;
        for (Integer board : boards) {
            if (sum + board <= mid) {
                sum += board;
            } else {
                sum = board;
                paintersCount++;
                if (paintersCount > painters || board > mid) {
                    return false;
                }
            }
        }

        return paintersCount <= painters;
    }
}
