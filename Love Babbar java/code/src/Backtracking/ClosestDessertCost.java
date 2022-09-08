package Backtracking;

//https://leetcode.com/problems/closest-dessert-cost/

public class ClosestDessertCost {
    public static void main(String[] args) {
       int[] baseCosts = {1,7}, toppingCosts = {3,4};
       int target = 10;

        System.out.println(closestCost(baseCosts,toppingCosts,target));

    }

    static int  targetGlobal = 0;
    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        targetGlobal = target;
        int ans =0;

        for(int i =0;i<baseCosts.length;i++){
            int sum = baseCosts[i];
            ans = closest(solve(toppingCosts,0,sum),ans);
        }

        return ans;
    }


    public static int solve(int[] toppingCosts,int index,int sum){
        if(index >= toppingCosts.length) {
            return sum;
        }

        int costToAdd = toppingCosts[index];
        int rule1 = solve(toppingCosts,index+1,sum);
        int rule2 = solve(toppingCosts,index+1,sum +costToAdd );
        int rule3 = solve(toppingCosts,index+1,sum + 2*costToAdd);

        int finalAns = closest(rule1,closest(rule2,rule3));
        return finalAns;
    }



   public static int closest(int a,int b){
        if(a == 0)
            return b;

        if(b == 0)
            return a;


        if(Math.abs(targetGlobal-a) < Math.abs(targetGlobal-b)){
            return a;
        }
        if(Math.abs(targetGlobal-a) > Math.abs(targetGlobal-b)){
            return b;
        }
        if(Math.abs(targetGlobal-a) == Math.abs(targetGlobal-b)){

            if(a>b)
                return b;
            else
                return a;

        }
        return -1;
    }
}
