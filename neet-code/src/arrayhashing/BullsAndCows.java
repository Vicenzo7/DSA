package arrayhashing;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public static void main(String[] args) {
        String secret = "1807", guess = "7810";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        Map<Character, Integer> secretCountMap = new HashMap<>();
        Map<Character, Integer> guessCountMap = new HashMap<>();

        int bullCount = 0;
        int cowCount = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bullCount++;
            } else {
                secretCountMap.put(s, secretCountMap.getOrDefault(s, 0) + 1);
                guessCountMap.put(g, guessCountMap.getOrDefault(g, 0) + 1);
            }
        }

        for (Character c : guessCountMap.keySet()) {
            if (secretCountMap.containsKey(c)) {
                cowCount += Math.min(secretCountMap.get(c), guessCountMap.get(c));
            }
        }
        return bullCount + "A" + cowCount + "B";
    }
}
