package com.company;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int rev,sum=0;
        while(num!=0){
            rev=num%10;
            sum=sum*10+rev;
            num /=10;
        }
        System.out.println(sum);
    }
}
