package com.company;

import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the number ");
        int num=input.nextInt();
        int f=0;
        int s=1;
        System.out.print(f+" "+s);
        for(int i=2;i<num;i++){
            int next=f+s;
            System.out.print(" "+next);
            f=s;
            s=next;

        }
    }
}
