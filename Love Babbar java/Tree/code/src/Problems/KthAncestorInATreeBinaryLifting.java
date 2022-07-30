package Problems;


/**
 * So, I tried it using the Brute Force way, but it gave TLE. The Brute Force was to move through the parent array one by one, till you got k parents up, and then return that.
 * This got me the hint of using Binary Lifting, what we do in Binary Lifting is basically we minimize the steps required to reach the kth parent of a node.
 * How do we do that? Using the properties of Binary Number System. So here goes a brief description of how we can use Binary Lifting to solve our problem.
 *
 * This technique is similar to Binary Exponentiation. What we do is, we store the parent of a node which are at power's of 2 above the node, i.e. we store the 1st parent (20), the 2nd parent (21), the 4th parent (22), the 8th parent (23), and so on till log(n) + 1 where n is the number of nodes, because in the worst case, the tree could be linear, and since you can represent any number in at max log(n) + 1 bits, hence we store till 2log(n) + 1.
 *
 * Now when we get a query to report the kth parent of a node, for example, let's say k = 11, we would use the magic of Binary Representation of k, which in this case is 1011. Now starting from the Least Significant bit, we would move right, and if a bit is 1, let's say at a position i, we would change our node to 2i th parent of that node, and repeat this process again. This way, we would be jumping up the tree, from parent to parent, not one parent at a time, but in powers of 2 which would drastically reduce our Time Complexity from O(n) to O(log n).
 *
 * If you wan't to learn more about Binary Lifting and the complete thinking and applying process behind it, there is wonderfully tutorial video by Algorithms Live.
 *
 * Below is the Java Code of the above approach.
 */


public class KthAncestorInATreeBinaryLifting {

    // ancestor[r][i] : 2^r-th ancestor or node i;
    int[][] ancestors;
    int rows;

    // initialization: Time: n * log(n)   Space: n * log(n)
    public  KthAncestorInATreeBinaryLifting(int n, int[] parent) {
        this.rows = (int)(Math.log(n) / Math.log(2)) + 1;
        this.ancestors = new int[rows][n];


        ancestors[0] = parent;
        for (int r = 1; r < rows; r++) {
            for (int i = 0; i < n; i++) {
                int temp = ancestors[r-1][i];
                ancestors[r][i] = (temp == -1) ? -1 : ancestors[r-1][temp];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int r = 0;
        while (k > 0) {
            if ((k & 1) == 1) node = ancestors[r][node];
            if (node == -1) break;

            r++;
            k >>= 1;
        }

        return node;
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        KthAncestorInATreeBinaryLifting obj = new KthAncestorInATreeBinaryLifting(7,parent);
        System.out.println(obj.getKthAncestor(5,1));
        System.out.println(obj.getKthAncestor(5,2));
        System.out.println(obj.getKthAncestor(5,5));
    }



}
