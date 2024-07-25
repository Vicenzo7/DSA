package dp.onedimension.batchII;

public class CountWaysToBuildGoodStrings {
    public static void main(String[] args) {
        int low = 3, high = 3, zero = 1, one = 1;
//        int low = 2, high = 3, zero = 1, one = 2;
        System.out.println(countGoodStrings(low, high, zero, one));
    }

    // not using the commented part as using too much memory for string creation

//    public int countGoodStrings(int low, int high, int zero, int one) {
//        return bruteForce("", low, high, zero, one);
//    }
//
//    public int bruteForce(String s, int low, int high, int zero, int one) {
//        if (s.length() > high) {
//            return 0;
//        }
//
//        int count = 0;
//
//        if (low <= s.length()) {
//            count = 1;
//        }
//
//        // append 0 zero times
//        String zeroStr = s + "0".repeat(zero);
//        count += bruteForce(zeroStr, low, high, zero, one);
//
//        // append 1 one times
//        String oneStr = s + "1".repeat(one);
//        count += bruteForce(oneStr, low, high, zero, one);
//
//        return count;
//    }


    static int mod = (int) 1e9 + 7;

    public static int countGoodStrings(int low, int high, int zero, int one) {
//        return bruteForce(0, low, high, zero, one);
        return memoization(0, low, high, zero, one, new Integer[high + 1]);
    }

    private static int bruteForce(int length, int low, int high, int zero, int one) {

        if (length > high) {
            return 0;
        }

        int count = 0;

        if (low <= length) {
            count = 1;
        }

        // append 0 zero times
        count += bruteForce(length + zero, low, high, zero, one);

        // append 1 one times
        count += bruteForce(length + one, low, high, zero, one);

        return count;
    }

    private static int memoization(int length, int low, int high, int zero, int one, Integer[] cache) {

        if (length > high) {
            return 0;
        }

        if (cache[length] != null) {
            return cache[length];
        }

        int count = low <= length ? 1 : 0;


        // append 0 zero times
        count += memoization(length + zero, low, high, zero, one, cache) % mod;

        // append 1 one times
        count += memoization(length + one, low, high, zero, one, cache) % mod;
        count %= mod;
        cache[length] = count;
        return count;
    }
}

