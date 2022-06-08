package RecursionUnacedemy;

import java.util.ArrayList;

//https://leetcode.com/problems/word-search/
public class WordSearch {

    public static void main(String[] args) {
        char[][]  board = {
                {'A', 'B','C', 'E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word="FCED";
        System.out.println(exist(board,word));

    }

    public static boolean exist(char[][] board, String word) {

        int row = board.length;
        int col= board[0].length;

        int k=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col ; j++) {
                if(solve(i,j,k, board,word))
                {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean solve(int i,int j,int k,  char[][] board, String word)
    {
        // if not safe
        if((i <0 || i>=board.length)  || (j <0 || j>=board.length) || board[i][j] == '*' || word.charAt(k) != board[i][j] )
        {
            return false;
        }

        //base case
        if(k == word.length()-1)
            return true;

        char ch = board[i][j];

        //mark visited
        board[i][j]= '*';

        //traverse LRUD

        boolean left = solve(i,j-1,k+1,board,word);

        boolean right = solve(i,j+1,k+1,board,word);

        boolean up = solve(i-1,j,k+1,board,word);

        boolean down = solve(i+1,j,k+1,board,word);

        //back track
        board[i][j]= ch;

        return left || right || up || down;

    }


}
