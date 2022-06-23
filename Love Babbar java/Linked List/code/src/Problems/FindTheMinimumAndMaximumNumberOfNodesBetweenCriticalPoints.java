package Problems;
//https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
import java.util.Arrays;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public Node head;
    public Node tail;
    public int size;


    public FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints() {
        this.size =0;
    }

    //insert at head
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail= node;
        }

        size += 1;
    }


    //insert at tail
    public void insertLast(int val){
        // if tail is empty means no nodes
        if(tail == null){
            insertFirst(val);
            return;//we are returning because the below part should not execute or put it in else condition
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }


    //display function
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ->  ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //display function
    public void display2(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ->  ");
            temp = temp.next;
        }
        System.out.println("END");
    }




    public int[] nodesBetweenCriticalPoints(Node head) {
        //if list empy or only one element or two element we cant get ans
        if(head == null || head.next == null || head.next.next == null)
            return new int[] {-1,-1};

        Node prev = head;
        Node temp = head.next ;

        int firstPos = Integer.MAX_VALUE;
        int lastPos = Integer.MIN_VALUE;


        int maxDist=Integer.MIN_VALUE;
        int minDist =Integer.MAX_VALUE;
        //1 based indexing
        int index=1;

        //current critical point
        int cp =-1;
        //total critical point
        int totalCP = 0;


        while(temp.next !=null)
        {
            if(temp.value < prev.value  && temp.value < temp.next.value)
            {
                firstPos = Math.min(firstPos,index);
                lastPos = Math.max(lastPos,index);

                if(cp != -1)
                {
                    minDist = Math.min(minDist,index-cp);
                }

                //update critical point
                cp = index;
                totalCP++;
            }


            if(temp.value > prev.value  && temp.value > temp.next.value)
            {
                firstPos = Math.min(firstPos,index);
                lastPos = Math.max(lastPos,index);

                if(cp != -1)
                {
                    minDist = Math.min(minDist,index-cp);
                }

                //update critical point
                cp = index;
                totalCP++;
            }

            index++;
            prev = temp;
            temp = temp.next;
        }

        // if critical points are less than 2 ans cannot be found
        if(totalCP<2)
            return new int[] {-1,-1};

        maxDist = lastPos - firstPos;
        return new int[] {minDist,maxDist};
    }


    public class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints list = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints();

        list.insertLast(1);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(7);

        System.out.println(Arrays.toString(list.nodesBetweenCriticalPoints(list.head)));


    }
}
