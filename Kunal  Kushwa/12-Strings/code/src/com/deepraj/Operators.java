package com.Popatlal;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a'-'b');
        System.out.println("a"+"b");
        System.out.println('a' + 3);
        System.out.println((char)('a' + 3));
//Jai Kunal ji
        System.out.println("a" + 1);
        // this will be same as after a few steps: "a" + "1"
        // integer will be converted to Integer that will call toString()

        System.out.println("Popatlal" + new ArrayList<>());
        System.out.println("Popatlal" + new Integer(56));
        String ans = new Integer(56)+""+new ArrayList<>();
        System.out.println(ans);

        System.out.println("a" +'z');


    }
}
