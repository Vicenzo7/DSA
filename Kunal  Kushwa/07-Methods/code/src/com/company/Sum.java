package com.company;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
//        int ans =sum2();
//        System.out.println(ans);
        int ans = sum3(20,30);
        System.out.println(ans);
    }

    // PASS THE VALUE OF NUMBERS WHEN YOU ARE CALLING THE METHOD IN MAIN()
    static  int sum3(int a,int b){
        int sum=a+b;
        return sum;
    }




    // return the value
    static int sum2() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = in.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        return sum;
//       System.out.println("This will never execute");
    }



     static void sum(){
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


