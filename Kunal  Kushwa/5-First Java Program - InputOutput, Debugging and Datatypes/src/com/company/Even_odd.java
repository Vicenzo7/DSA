package com.company;

import java.util.Scanner;

public class Even_odd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter a number ");
        int a= input.nextInt();
        if(a%2==0)
        {
            System.out.println("Even");
        }
        else
            System.out.println("odd");
    }
}
