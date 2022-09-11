package com.company.math;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        int n=4,k=3;
        System.out.println(kthGrammar(n,k));
    }

//    public static int kthGrammar(int n, int k) {
//
//        //base case
//        if(n==1 || k==1)
//            return 0;
//
//        int mid = (int)Math.pow(2,n-1)/2;
//
//        if(k <= mid)
//            return kthGrammar(n-1,k);
//        else
//            return kthGrammar(n-1,k-mid) ^  1;
//    }



    public static int kthGrammar(int n, int k) {

        //base case
        if(n==1 || k==1)
            return 0;

        int mid = (int)Math.pow(2,n-1)/2;

        if(k <= mid)
            return kthGrammar(n-1,k);
        else
            return  flip(kthGrammar(n-1,k-mid));
    }

    static int flip(int num){
        return num == 0 ? 1:0;
    }
}
