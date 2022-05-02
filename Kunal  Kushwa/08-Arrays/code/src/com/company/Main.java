package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        //syntax
        // datatypes[] variable_name = new datatype[size];

//        int[] rnos = new int[5];
//        //or directly
//        int[] rnos = {23,45, 48, 78, 56};


        int[] rnos;// declaration of array. ros is getting defined in the stack
        rnos = new int[5]; // initialization. actually here object is being created in memory(heap)

//        String[] arr = new String[4];
//        System.out.println(arr[0]);

         String str = "hello";
         int i=1;
         int index = str.charAt(i)- 'a';
        System.out.println(index);

    }


}
