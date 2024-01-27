package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    //https://leetcode.com/problems/partition-labels/solutions/1868842/java-c-visually-explaineddddd/
    public static List<Integer> partitionLabels(String s) {
        //First we will keep a track of all character till where they have their last occurrence,with help of a map
        Map<Character, Integer> characterRangeMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            characterRangeMap.put(ch, i);
        }

        /*
            Now we will iterate the string again and get the max range
            then when the iteration i is at max eg
            a has last occurrence at 8, b at 5 c at 7
            so max is 8
            and partition will only occur when the pointer is at max
            8 - (-1) = 7 -> this is our first partition
            -1 is previous partition
            now previous partition will be max
        */
        List<Integer> result = new ArrayList<>();
        int maxRange = 0;
        int prevPartitionIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            maxRange = Math.max(maxRange, characterRangeMap.get(s.charAt(i)));
            if (maxRange == i) {
                // partition time
                result.add(maxRange - prevPartitionIndex);
                prevPartitionIndex = maxRange;
            }
        }

        return result;
    }
}
