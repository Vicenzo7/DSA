package RecursionUnacedemy;

import java.util.Arrays;

public class BinarySequence {
    public static void main(String[] args) {
        int n = 2;

        char[] ch = new char[2*n];
        findSequences(0,0,ch,0,2*n-1);

    }

    public static void findSequences(int leftSum,int rightSum,char[] output,int i,int j)
    {

        //base case
        if(i>j)
        {
            if(leftSum == rightSum)
            {
                System.out.println(String.valueOf(output));
            }
            return;
        }


        //put 0,0
        output[i] = '0';
        output[j] = '0';
        findSequences(leftSum,rightSum,output,i+1,j-1);

        //put 0,1
        output[i] = '0';
        output[j] = '1';
        findSequences(leftSum,rightSum+1,output,i+1,j-1);

        //put 1,0
        output[i] = '1';
        output[j] = '0';
        findSequences(leftSum+1,rightSum,output,i+1,j-1);
        //put 1,0
        output[i] = '1';
        output[j] = '1';
        findSequences(leftSum+1,rightSum+1,output,i+1,j-1);


    }
}
