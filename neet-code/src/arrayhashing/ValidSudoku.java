package arrayhashing;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        // TC = O(9^2) SC = O(9^2)
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isValid(i, j, board)) return false;
            }
        }
        return true;
    }

    private static boolean isValid(int row, int column, char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char ch = board[i][column];
            if (ch == '.') continue;

            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }

        set.clear();

        for (int i = 0; i < 9; i++) {
            char ch = board[row][i];
            if (ch == '.') continue;
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }

        set.clear();

        // block check
        if (row % 3 == 0 && column % 3 == 0) {
            for (int i = row; i < row + 3; i++) {
                for (int j = column; j < column + 3; j++) {
                    char ch = board[i][j];
                    if (ch == '.') continue;
                    if (set.contains(ch)) {
                        return false;
                    }
                    set.add(ch);
                }
            }
        }

        return true;
    }
}
