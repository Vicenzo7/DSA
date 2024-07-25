package dp.onedimension.batchII;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToDivideALongCorridor {
    public static void main(String[] args) {
        String corridor = "PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPS" +
                "PPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS";
        System.out.println(numberOfWays(corridor));
    }

    static
    public int numberOfWays(String corridor) {
//        return dfs(0, 0, corridor, new Integer[corridor.length() + 1][3]);
        return combinationMethod(corridor);
    }

    /*
        TC = O(n)
    */

    static
    public int dfs(int index, int seatCount, String corridor, Integer[][] cache) {
        int MOD = (int) (1e9 + 7);

        // if we have 2 seat at the end return 1
        if (index == corridor.length()) {
            return seatCount == 2 ? 1 : 0;
        }

        if (cache[index][seatCount] != null) {
            return cache[index][seatCount];
        }

        int result = 0;
        if (seatCount == 2) {
            if (corridor.charAt(index) == 'S') {
                result = dfs(index + 1, 1, corridor, cache); // found 3 seat so reset seat to 1
            } else {
                result = (dfs(index + 1, 0, corridor, cache) // added a divider
                        + dfs(index + 1, seatCount, corridor, cache) // did not add a divider
                ) % MOD;
            }
        } else {
            seatCount += corridor.charAt(index) == 'S' ? 1 : 0;
            result = dfs(index + 1, seatCount, corridor, cache);
        }

        return cache[index][seatCount] = result;
    }


     /*
        The basic idea is to calculate the distance between
        2nd seat of a section first seat of another section
             0 1 2 3 4 5 6
        eg = S S P P S P S

        so how many ways to place a divider between s at index 1 and s at index 4
        4-1 = 3 so total is 3 ways
    */

    static
    private int combinationMethod(String corridor) {
        int MOD = (int) (1e9 + 7);
        List<Integer> seatsIndex = new ArrayList<>();
        // calculate the seat index
        char[] charArray = corridor.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 'S') {
                seatsIndex.add(i);
            }
        }

        if (seatsIndex.isEmpty() || seatsIndex.size() % 2 == 1) {
            return 0;
        }

        // starting from 1, so we have two seats
        // and jumping two lengths, so we can calculate length between current ending seat and next starting seat
        int result = 1;
        for (int i = 2; i < seatsIndex.size(); i += 2) {
            result = (result * (seatsIndex.get(i) - seatsIndex.get(i - 1))) % MOD;
        }
        return result;
    }
}
