package Problems;

import java.util.Stack;

public class CelebrityProblem {

    public static void main(String[] args) {
        int[][] MATRIX = { {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0} };
        System.out.println(celebrity(MATRIX,MATRIX.length));
    }



    public static int knows(int a,int b,int[][] M){
        return M[a][b];
    }

    public static int celebrity(int[][]M , int n)
    {
        Stack<Integer> stack = new Stack<>();
        //step1: push all elements in the stack
        for (int i = 0; i < n; i++) {
            stack.add(i);
        }
        //find candidate for celebrity
        while(stack.size() != 1){
            int first = stack.pop();
            int second = stack.pop();

            if(knows(first,second,M) == 1 ){
                stack.push(second);
            }else{
                stack.push(first);
            }
        }

        //store candidate
        int candidate = stack.peek();

        //verification of candidate

        //check row for all 0's
        boolean checkRow = true;
        for (int i = 0; i < n; i++) {
            if(M[candidate][i] == 1)
            {
                checkRow = false;
                break;
            }
        }

        //check col for all 1's
        boolean checkCol = true;
        for (int i = 0; i < n; i++) {
            if(i!= candidate && M[i][candidate] == 0)
            {
                checkCol = false;
                break;
            }
        }


        if(checkRow && checkCol)
            return candidate;
        else
            return -1;
    }
}
