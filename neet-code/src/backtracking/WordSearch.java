package backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int k = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (canWordsStartFromHere(row, col, k, rows, cols, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean canWordsStartFromHere(int row, int col, int index, int maxRows, int maxCols, char[][] board, String word) {
        // base case
        // row and col not out of bound, not visited and
        if (row < 0 || row >= maxRows || col < 0 || col >= maxCols || board[row][col] == '#' || board[row][col] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        //mark as visited
        char ch = board[row][col];
        board[row][col] = '#';

        boolean left = canWordsStartFromHere(row, col - 1, index + 1, maxRows, maxCols, board, word);
        boolean right = canWordsStartFromHere(row, col + 1, index + 1, maxRows, maxCols, board, word);
        boolean up = canWordsStartFromHere(row - 1, col, index + 1, maxRows, maxCols, board, word);
        boolean down = canWordsStartFromHere(row + 1, col, index + 1, maxRows, maxCols, board, word);


        board[row][col] = ch;

        return left || right || up || down;
    }
}
