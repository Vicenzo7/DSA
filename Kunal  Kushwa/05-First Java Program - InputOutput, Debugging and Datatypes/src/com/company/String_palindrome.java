package com.company;

import java.util.Scanner;

public class String_palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String str= input.nextLine();
        boolean flag= true;
         int i=0;int j=str.length()-1;
         while(i<j){
             if(str.charAt(i)!=str.charAt(j)){
                 flag=false;
             }
             i++;
             j--;
         }
         if(flag==true){
             System.out.println("palindrome");
         }
         else
             System.out.println("not Palindrome");


    }
}
