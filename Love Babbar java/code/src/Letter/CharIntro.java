package Letter;

import java.util.Scanner;

public class CharIntro {
    public static void main(String[] args) {
        //creation

//        //scanner class to read input from the user
//        Scanner sc=new Scanner(System.in);
//        char[] name=new char[5];
//
//        //initializing value to the array
//        System.out.println("******Initializing array******");
//        System.out.println("Enter character values");
//
//        name=sc.next().toCharArray();
//        //Take character input
//
//        //displaying the array elements
//        System.out.println("\n******displaying array of characters******");
//        System.out.println("Entered Characters are");
//        for(int i=0; i<name.length; i++) {
//            System.out.print(name[i] + "\t");
//        }

        char[] arr={'d','d','d','e'};
        char[] arr2={'d','d','d','e'};

        System.out.println(arr.equals(arr2));
        System.out.println(arr==arr2);
        String name;
        Scanner sc=new Scanner(System.in);




    }


    static int getLength(char[] name){
        int length=0;
        int index=0;
        while(name[index]!='\0')
        {
            length++;
            index++;
        }
        return length;
    }
}
