package ArraysProblems;

import java.util.ArrayList;

public class FactorialOfLargeNumberUsingArrayList {
    public static void main(String[] args) {
        int n=100;
        findFact(n);
    }

    private static void findFact(int n) {
        //declare a arrayList
        ArrayList<Integer> res = new ArrayList<>();
        int size=0,carry=0;
        //adding 1 to 0th index
        res.add(0,1);
        size=1;

        //declare a variable to traverse a number from 2 to n
        int val = 2;
        while(val<=n)
        {
            //traverse the array list from right to left
            for (int i = size-1; i >=0 ; i--) {
                //update value in the ArrayList
                int temp=res.get(i)* val+ carry;
                //store the last digit at index and add remaining to carry
                res.set(i,temp%10);
                //update carry
                carry= temp/10;
            }
            //insert carry digit to begining of ArrayList
            while(carry!=0)
            {
                int temp =carry%10;
                res.add(0,temp);
                carry= carry/10;
                size++;
            }
            val++;
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }


    }
}
