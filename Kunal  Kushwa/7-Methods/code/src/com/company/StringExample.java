package com.company;

import java.util.Scanner;

public class StringExample {
    public static void main(String[] args) {
//        String msg = greet();
//        System.out.println(msg);
        System.out.println("Enter your name ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        String personalized = myGreet(name);
        System.out.println(personalized);
    }

    static String myGreet(String name) {
        String message = "hello "+name;
        return message;
    }

    static String greet(){
        String greeting = "how are you";
        return  greeting;
    }
}
