package EasyBSR;

class CountNegativeNumbersInASortedMatrix {
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
        int count=0;
        for(int[] g:grid)
        {
            count += binarySearch(g,0,g.length-1);
        }
        return count;
    }
    
    public static int binarySearch(int[] arr,int start,int end) {

        if(start>end)
            return arr.length-start;

        int mid = start + (end-start)/2;
        //BS conditions
        if(arr[mid]>=0)
        {
            return binarySearch(arr,mid+1,end);
        }
        else{
            return binarySearch(arr,start,mid-1);
        }
    }
}