package Problems;
//
public class MergeNodesInBetweenZeros {
    public Node head;
    public Node tail;
    public int size;
    public MergeNodesInBetweenZeros() {
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

    public Node mergeNodes(Node head) {

        int count =0;
        int sum =0;
        Node start = head;
        Node dH = new Node(-1);
        Node dummy = dH;
        while(start != null){
            if(start.value !=0)
            {
                sum = sum + start.value;
            }else{
                count++;
            }

            if(count == 2){

                dummy.next = new Node(sum);
                dummy = dummy.next;
                sum = 0;
                count =1;
            }

            start = start.next;
        }

        return dH.next;

    }

    public Node mergeNodesOptimised(Node head) {

        Node cur = head;
        Node ans = head;
        int sum =0;

        while(cur != null)
        {
            if(cur.value == 0 && sum!=0)
            {
                ans = ans.next;
                ans.value= sum;
                sum=0;
            }else{
                sum += cur.value;
            }
            cur = cur.next;
        }

        ans.next = null;
        return head.next;



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
        MergeNodesInBetweenZeros list = new MergeNodesInBetweenZeros();

        list.insertLast(0);
        list.insertLast(3);
        list.insertLast(1);
        list.insertLast(0);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(2);
        list.insertLast(0);

        list.display();
        list.display2(list.mergeNodes(list.head));

        list.display2(list.mergeNodesOptimised(list.head));




    }
}
