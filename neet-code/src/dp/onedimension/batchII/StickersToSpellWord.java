package dp.onedimension.batchII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StickersToSpellWord {
    public static void main(String[] args) {
//        String[] stickers = {"with", "example", "science"};
//        String target = "thehat";


        String[] stickers = {"notice", "possible"};
        String target = "basicbasic";

        System.out.println(minStickers(stickers, target));
    }

    public static int minStickers(String[] stickers, String target) {

        // create a character to count map for each sticker
        List<Map<Character, Integer>> stickerFrequency = new ArrayList<>();
        for (int i = 0; i < stickers.length; i++) {
            String sticker = stickers[i];
            Map<Character, Integer> map = new HashMap<>();
            for (char c : sticker.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            stickerFrequency.add(i, map);
        }

        Map<String, Integer> dp = new HashMap<>(); // key = subsequence of target, value = min sticker required

        int result = memoization(target, stickerFrequency, dp, new HashMap<>());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int memoization(String target, List<Map<Character, Integer>> stickersFrequencies,
                                   Map<String, Integer> dp,
                                   Map<Character, Integer> stickerFrequencyMap) {
        if (target.isEmpty()) {
            return 0;
        }

        if (dp.containsKey(target)) {
            return dp.get(target);
        }

        int result = stickerFrequencyMap.isEmpty() ? 0 : 1;
        StringBuilder remainingTarget = new StringBuilder();
        for (char c : target.toCharArray()) {
            // check if character is in sticker and if there use it or else put in remaining target
            if (stickerFrequencyMap.containsKey(c) && stickerFrequencyMap.get(c) > 0) {
                stickerFrequencyMap.put(c, stickerFrequencyMap.get(c) - 1);
            } else {
                remainingTarget.append(c);
            }
        }

        // if remaining target exist we need to use more stickers to find remaining target
        if (!remainingTarget.isEmpty()) {
            int used = Integer.MAX_VALUE;
            for (Map<Character, Integer> stickerFrequency : stickersFrequencies) {
                // check if the first character of remainingTarget is there in stickerFrequency to proceed further
                if (!stickerFrequency.containsKey(remainingTarget.charAt(0))) {
                    continue;
                }
                // pass a copy of stickerFrequency
                used = Math.min(used,
                        memoization(remainingTarget.toString(), stickersFrequencies, dp, new HashMap<>(stickerFrequency)));
            }
            dp.put(remainingTarget.toString(), used);
            result = used == Integer.MAX_VALUE ? used : result + used;
        }
        return result;
    }


}
