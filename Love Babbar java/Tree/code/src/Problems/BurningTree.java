package Problems;

import java.util.*;

public class BurningTree {

    Scanner sc = new Scanner(System.in);
    public Node buildTree() {
        System.out.println("Enter the data");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        Node newNode = new Node(data);

        System.out.println("Enter the data for left child of " + data);
        newNode.left = buildTree();

        System.out.println("Enter the data for right child of " + data);
        newNode.right = buildTree();

        return newNode;
    }

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    public  int calculateTime(Map<Node,Node> map , Node start){
        //A visited map
        Map<Node,Integer> vis = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(start);
        vis.put(start,1);

        int time =0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean burned = false;
            for(int i=0;i<size;i++){
                Node cur = q.remove();

                //left child
                if(cur.left != null && vis.get(cur.left) == null){
                    burned = true;
                    vis.put(cur.left,1);
                    q.add(cur.left);

                }
                //right child
                if(cur.right != null && vis.get(cur.right) == null){
                    burned = true;
                    vis.put(cur.right,1);
                    q.add(cur.right);
                }

                //parent

                if(map.get(cur) != null && vis.get(map.get(cur)) == null){
                    burned = true;
                    vis.put(map.get(cur),1);
                    q.add(map.get(cur));
                }
            }

            if(burned)
            {
                time++;
            }

        }

        return time;

    }

    public  Node bfsToMapParent(Node root,Map<Node,Node> map , int start){
        Node res = new Node(-1);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            Node cur = q.remove();
            if(cur.value  == start ){
                res= cur;
            }
            if(cur.left !=null){
                map.put(cur.left,cur);
                q.add(cur.left);
            }

            if(cur.right!=null){
                map.put(cur.right,cur);
                q.add(cur.right);
            }

        }

        return res;
    }

    public  int minTime(Node root, int target)
    {
        Map<Node,Node> map = new HashMap<>();
        Node start = bfsToMapParent(root,map,target);
        int time = calculateTime(map ,start);
        return time;
    }


    public static void main(String[] args) {
        BurningTree tree = new BurningTree();
        Node root = tree.buildTree();

        //1 2 4 -1 7 -1 -1 -1 3 5 -1 -1 6 -1 -1
        System.out.println(tree.minTime(root,2));
    }
}
