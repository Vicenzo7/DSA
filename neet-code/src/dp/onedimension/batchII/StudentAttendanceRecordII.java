package dp.onedimension.batchII;

public class StudentAttendanceRecordII {
    public static void main(String[] args) {
        System.out.println(checkRecord(2));
    }


    static Integer[][][] cache;
    static int MOD = (int) 1e9 + 7;

    static
    public int checkRecord(int n) {
        cache = new Integer[n + 1][2][3];
        return dfs(n, 0, 0);
    }

    /*
        Actual TC = (3^n) -> because three decision is being made
        TC = O(n) -> due to caching
        SC = O(n*2*3) = O(6n) = O(n)

    */

    static
    public int dfs(int n, int absentCount, int consecutiveLateCount) {
        // he cannot be absent for 2 days in total
        // he cannot be late for 3 consecutive days
        if (absentCount == 2 || consecutiveLateCount == 3) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (cache[n][absentCount][consecutiveLateCount] != null) {
            return cache[n][absentCount][consecutiveLateCount];
        }

        int result = dfs(n - 1, absentCount + 1, 0) % MOD; // absent, cannot be late;
        result = (result + dfs(n - 1, absentCount, consecutiveLateCount + 1)) % MOD; // late
        result = (result + dfs(n - 1, absentCount, 0)) % MOD; // present, cannot be late

        return cache[n][absentCount][consecutiveLateCount] = result;
    }


}
