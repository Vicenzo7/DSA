package Problems;

// to search in 2D matrix that is sorted row and column wise
public class SearchIn2DMatrixRowColSorted {
    public static void main(String[] args) {
        int[][] arr= {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        int target=50;
//        System.out.println(Arrays.toString(search(arr,target)));

        System.out.println(grid(arr,target));



    }

    static int[] search(int[][] matrix, int target) {
        int r=0;
        int c= matrix.length-1;

        while(r< matrix.length && c>=0){
            if(matrix[r][c]== target){
                return  new int[]{r,c};
            }
            if(matrix[r][c]<target){
                r++;
            }
            else{
                c--;
            }
        }
        return  new int[]{-1,-1};
    }



    //Method passing a row at a time and searching target in it using BS
    public static boolean grid(int[][] matrix,int target)
    {
        for (int[] g:matrix)
        {

            if(gridSearch(g,target))
            {
                return true;
            }
        }
        return false;
    }


    public static boolean gridSearch(int [] row,int target)
    {
        int start=0;
        int end=row.length-1;
        while(start<= end){
            int mid =start+(end-start)/2;
            if(row[mid]== target){
                return true;
            }
            else if( row[mid]<target){
                start=mid+1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}
