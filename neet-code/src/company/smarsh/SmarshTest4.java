package company.smarsh;

public class SmarshTest4 {

    public static void main(String[] args) {
        /*
            Smarsh
            You are given coins of different values you need to find the
           total ways to achieve the desired sum

        */

        int[] coins = {2, 5};
        int sum = 0;
        int count = combinationCount(0, coins,sum);
        System.out.println(count);
    }

    public static int combinationCount(int index, int[] coins, int sum) {
        if(sum == 0) {
            return 1;
        }

        if(index == coins.length ||  sum < 0) {
            return 0;
        }

        // include
        int option1 = combinationCount(index,coins,sum - coins[index]);

        // exclude
        int option2 = combinationCount(index+1,coins,sum);

        return option1+option2;
    }
}
