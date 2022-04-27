package com.company;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter a 2 three digit number ");
        System.out.println("enter 1st number ");
        int num1 = input.nextInt();
        System.out.println("enter 2st number ");
        int num2=input.nextInt();

        for(int i=num1;i<num2;i++ ){
            int r,sum=0,check=i;
            while(check!=0){
                r=check%10;
                sum=sum+(r*r*r);
                check=check/10;
            }
            if(i==sum){
                System.out.println(i+" is armstrong number");
            }
        }
    }
}
