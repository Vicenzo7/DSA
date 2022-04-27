package com.company;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your roll no :");
        int rollno = input.nextInt();
        System.out.println("your roll no is "+ rollno);
    }
}
