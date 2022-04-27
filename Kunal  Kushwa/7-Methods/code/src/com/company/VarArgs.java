package com.company;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
//       fun(2,3,45,8,79,754,5,45,5,45,6,26,44);
//         multiple(2 ,3,"deepraj", "hsbdhb","jhdcsdhci");

        //        demo(56,89,45,75);
        demo("deepraj ","DSA","Core Programming");
    }


    static void demo(int ...v){
        System.out.println(Arrays.toString(v));
    }


    static void demo(String ...v){
        System.out.println(Arrays.toString(v));
    }

    static void multiple(int a, int b, String ...v){
        System.out.println(a+" "+b);
        System.out.println(Arrays.toString(v));
    }


    static void fun(int...v){
        System.out.println(Arrays.toString(v));
    }
}
