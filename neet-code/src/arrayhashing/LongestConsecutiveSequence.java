package arrayhashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        // TC = O(n)  SC = O(n)
        HashSet<Integer> set = new HashSet<>();
        int longestConsecutiveSequence = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (Integer num : set) {
            // check if its previous exist
            if (set.contains(num - 1)) continue;

            // its prev does not exist
            int currentConsecutiveSequence = 1;
            int currentNumber = num + 1;
            while (set.contains(currentNumber)) {
                currentConsecutiveSequence += 1;
                currentNumber += 1;
            }
            longestConsecutiveSequence = Math.max(longestConsecutiveSequence, currentConsecutiveSequence);
        }
        return longestConsecutiveSequence;
    }
}
