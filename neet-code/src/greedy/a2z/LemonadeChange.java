package greedy.a2z;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
        System.out.println(lemonadeChangeOptimised(bills));
    }

    /*
        Intuition:

        When the customer gives us $20, we have two options:
        1. To give three $5 in return
        2. To give one $5 and one $10.

        On insight is that the second option (if possible) is always better than the first one.
        Because two $5 in hand is always better than one $10

        Explanation:

        Count the number of $5 and $10 in hand.

        if (customer pays with $5) five++; if (customer pays with $10) ten++, five--;
        if (customer pays with $20) ten--, five-- or five -= 3;

        Check if five is positive, otherwise return false.

        Time Complexity

        Time O(N) for one iteration
        Space O(1)

    */

    public static boolean lemonadeChangeOptimised(int[] bills) {
        if (bills[0] > 5) {
            return false;
        }
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                ten++;
                five--;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }

            if (five < 0) return false;
        }
        return true;
    }

    public static boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5) {
            return false;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int bill : bills) {
            frequencyMap.put(bill, frequencyMap.getOrDefault(bill, 0) + 1);
            if (bill == 10) {
                Integer change = frequencyMap.getOrDefault(5, 0);
                if (change == 0) {
                    return false;
                } else {
                    frequencyMap.put(5, change - 1);
                }
            } else if (bill == 20) {
                Integer changeOfTen = frequencyMap.getOrDefault(10, 0);
                if (changeOfTen == 0) {
                    int changeOf5 = frequencyMap.getOrDefault(5, 0);
                    if (changeOf5 < 3) {
                        return false;
                    } else {
                        frequencyMap.put(5, changeOf5 - 3);
                    }
                } else {
                    int changeOf5 = frequencyMap.getOrDefault(5, 0);
                    if (changeOf5 == 0) {
                        return false;
                    } else {
                        frequencyMap.put(5, changeOf5 - 1);
                        frequencyMap.put(10, changeOfTen - 1);
                    }
                }
            }
        }
        return true;
    }
}
