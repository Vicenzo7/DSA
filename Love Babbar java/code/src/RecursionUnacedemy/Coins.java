package RecursionUnacedemy;

public class Coins {
    public static void main(String[] args) {
        int[] coins = {1,2};
        int amount =4;
        int size =2;

        int ans =solve(coins,size,amount,0);
        System.out.println(ans);
    }

    private static int solve(int[] coins, int size, int amount,int index) {
        //base case
        if(amount == 0)
            return 1;
        if(amount < 1)
            return 0;

        int ways = 0;
        for (int i = index; i < size; i++) {
            ways += solve(coins,size,amount -coins[i],i);
        }
        return ways ;
    }
}
