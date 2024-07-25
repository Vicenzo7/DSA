package dp.onedimension.batchII;

public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
//        return bruteForce(1, n, n);
        return memoization(1, n, n, new Integer[n + 1][n + 1]);
    }

    private static int bruteForce(int i, int n, int staticN) {
        if (n == 0) {
            return 1;
        }

        if (i >= staticN) {
            return 1;
        }

        int maximumProduct = bruteForce(i + 1, n, staticN);
        int newN = n - i;
        if (newN >= 0) {
            int product = i * bruteForce(i, newN, staticN);
            maximumProduct = Math.max(maximumProduct, product);
        }

        return maximumProduct;
    }


    private static int memoization(int i, int n, int staticN, Integer[][] cache) {
        if (n == 0) {
            return 1;
        }

        if (i >= staticN) {
            return 1;
        }
        if (cache[i][n] != null) {
            return cache[i][n];
        }

        int maximumProduct = memoization(i + 1, n, staticN, cache);
        int newN = n - i;
        if (newN >= 0) {
            int product = i * memoization(i, newN, staticN, cache);
            maximumProduct = Math.max(maximumProduct, product);
        }

        return cache[i][n] = maximumProduct;
    }
}
