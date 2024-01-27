package greedy;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

//        int[] gas = {2, 3, 4};
//        int[] cost = {3, 4, 3};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int position = 0;
        int total = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                total += sum;
                sum = 0;
                position = i + 1;
            }
        }

        total += sum;

        return total >= 0 ? position : -1;
    }
}
