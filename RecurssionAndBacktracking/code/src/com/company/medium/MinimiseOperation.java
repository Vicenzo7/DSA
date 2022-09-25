package com.company.medium;
// in complete
public class MinimiseOperation {
    public static void main(String[] args) {
        int a = 13;
        int b = 5;

        System.out.println(solve(a,b));
    }



    static int solve(int a,int b){

        if(a<0 || b<0)
            return 0;

        if(a==1 && b==1)
            return 0;

        if(a==b){
            return 1;
        }


        int ans1 = solve(a-1,b);
        int ans2 = solve(a,b-1);
        int ans=0;
        if(a%b ==0){
            ans = solve(a/b,b);
        }else if (b%a ==0){
            ans = solve(a,b/a);
        }

        return Math.min(ans1,Math.min(ans2,ans));

    }

}
