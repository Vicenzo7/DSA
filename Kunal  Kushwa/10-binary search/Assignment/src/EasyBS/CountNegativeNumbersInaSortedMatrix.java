package EasyBS;

public class CountNegativeNumbersInaSortedMatrix {
    public static void main(String[] args) {
        int[][] grid={
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        int ans=countNegatives(grid);
        System.out.println(ans);
    }
    public static int countNegatives(int[][] grid) {
        int result=0;
        //traversing one row at a time
        for(int[] g:grid)
        {
            // passing one row at a time to BS and finding the number of negative numbers and adding to result
            result += binarySearch(g);
        }
        return result;
    }

    public static int binarySearch(int[] row)
    {
        int start=0;
        int end=row.length-1;

        while(start<=end)
        {
            int mid = start+(end-start)/2;
            //if mid element is < 0 all the elements after mid are < 0 so move end pointer before mid
            if(row[mid]<0)
            {
                end=mid-1;
            }
            //if mid element is > 0 all the elements before mid are > 0 so move start pointer after mid
            else{
                start=mid+1;
            }
        }
        return row.length-start;
    }
}
