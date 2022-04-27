package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);

        // Syntax
        ArrayList<Integer> list = new ArrayList<>(5);
//        list.add(50);
//        list.add(655450);
//        list.add(845);
//        list.add(232);
//        list.add(55);
//        list.add(1523);
//
//        System.out.println(list.contains(58451));
//        System.out.println(list);
//        list.set(0,99);
//        list.remove(2);
//        System.out.println(list);

        //input
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }

        ///to get item at any index
        for (int i = 0; i < 5 ; i++) {
            System.out.println(list.get((i))); //pass index here, list[index] syntax will not work here
        }

//        System.out.println(list);





    }
}
