package com.company.math;

public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        int n=5,k=2;
        System.out.println(findTheWinner(n,k));
    }

    public static int findTheWinner(int n, int k) {
       int ans = solve(n,k) +1;
       return ans;

    }

    public static int solve(int n,int k)
    {
        if(n == 1)
            return 0;

        return (solve(n-1,k) +k) % n;
    }
}
