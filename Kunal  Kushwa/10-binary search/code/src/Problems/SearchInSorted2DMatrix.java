package Problems;

import java.util.Arrays;

public class SearchInSorted2DMatrix {
    public static void main(String[] args) {
        int[][] arr= {
                {1,5,9},
                {14,20,23},
                {30,34,43}
        };

        int target=1;
        System.out.println(Arrays.toString(search(arr,target)));

    }

    public static int[] search(int[][] matrix,int target){
        int start=0;
        int end= matrix.length-1;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(matrix[mid][0]<= target && target<=matrix[mid][matrix[mid].length-1])
            {
                int col=binarySearch(matrix,mid,target);
                if(col!=-1)
                {
                    return new int[]{mid,col};
                }else{
                    return new int[]{-1,-1};
                }

            }
            if(target<matrix[mid][0])
            {
               end=mid-1;
            }
            if(target>matrix[mid][matrix[mid].length-1]){
                start= mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int binarySearch(int[][] matrix, int row, int target) {
        int start=0;
        int end=matrix[row].length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(matrix[row][mid] == target)
            {
                return mid;
            }
            else if(matrix[row][mid]<target){
                start= mid+1;
            }
            else{
                end= mid-1;
            }
        }
        return -1;
    }
}
