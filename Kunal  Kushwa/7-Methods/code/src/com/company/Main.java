package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Q: take input of 2 numbers and print the sum using methods
        Scanner in  =new Scanner(System.in);
        int num1,num2,sum;
        System.out.println("Enter num 1:");
        num1 = in.nextInt();
        System.out.println("Enter num 2:");
        num2 = in.nextInt();
        sum =num1+num2;
        System.out.println("The Sum = "+sum);

    }
}
