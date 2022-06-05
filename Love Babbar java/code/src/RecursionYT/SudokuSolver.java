package RecursionYT;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudoku = {
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };

        solveSudoku(sudoku);

        for (int i = 0; i <sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void solveSudoku(int[][] sudoku) {

        solve(sudoku);
    }

    public static boolean solve(int[][] board)
    {
        int n = board.length;

        for(int row=0;row<n;row++)
        {
            for(int col=0;col<n;col++)
            {
                //if cell empty
                if(board[row][col] == 0)
                {
                    for(int val=1;val<=9;val++)
                    {
                        if(isSafe(row,col,board,val))
                        {
                            board[row][col] = val;
                            boolean futureSolutionPossible = solve(board);
                            if(futureSolutionPossible)
                                return true;
                            else{
                                //backtrack
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSafe(int row,int col,int[][]board,int val)
    {
        for(int i=0;i<board.length;i++)
        {
            //row check
            if(board[row][i] == val)
                return false;

            //col check
            if(board[i][col] == val)
                return false;

            //3x# matrix check
            //col check
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == val)
                return false;
        }
        return true;
    }
}
