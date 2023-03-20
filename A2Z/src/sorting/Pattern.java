package sorting;

public class Pattern {
    public static void main(String[] args) {
        starReversePattern(0,5);
        starPattern(0,5);

//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <=i ; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
    }

    private static void starReversePattern(int col, int row) {
        if (row < 0)
            return ;
        if (col< row){
            System.out.print("* ");
            starReversePattern(col+1,row);
        } else {
            System.out.println();
            starReversePattern(0,row-1);
        }
    }

    private static void starPattern(int col, int row) {
        if (row < 0)
            return ;
        if (col< row){
            starPattern(col+1,row);
            System.out.print("* ");

        } else {
            starPattern(0,row-1);
            System.out.println();

        }
    }
}
