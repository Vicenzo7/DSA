package dp.onedimension.batchII;

public class CountAllValidPickupAndDeliveryOptions {
    public static void main(String[] args) {
        System.out.println(countOrders(8));
    }


    /*
        Math formula
        Result = Number of Permutation / Total number of invalid permutation

        eg: n = 1, we have two place  _ _
        _ _ -> P1 D1 or D1 P1

        applying the formula = 2!/2 = 1 valid slots

        for n = 2, we have 4 places _ _ _ _
        _ _ _ _ so number of ways to place each of these first is 4

        so it's like 4!/2^2


        NeetCode Explanation
        n = 2 , we have n*2 = X slots

        _ _ _ _

        So there are 4 places where we can place P1
        and there are 3 places where we can place D1
        how many are valid =>  (4*3) / 2 = 6 are valid

        P1 D1 D1 D1 -> 3 valid
        D1 P1 D1 D1 -> 2 valid 1 invalid
        D1 D1 P1 D1 -> 1 valid 2 invalid
        D1 D1 D1 P1 -> 0 valid 3 invalid

    */


    static
    public int countOrders(int n) {
        int MOD = (int) (1e9 + 7);
        /*
            x = n * 2
            count valid ways to arrange a pair P1D1
            x * (x-1) = choices
            x * (x-1) / 2 valid choices
        */

        int slots = n * 2;
        long output = 1;
        while (slots > 0) {
            int validChoices = (slots * (slots - 1)) / 2;
            output = (output * validChoices) % MOD;
            slots -= 2;
        }
        return (int) output;
    }
}
