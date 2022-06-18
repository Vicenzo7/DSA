package Problems;

public class Main {

    public static void main(String[] args) {

        SingleLL list = new SingleLL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
//        list.insertLast(6);
//        list.insertLast(7);


        list.display();
        //reverse a list
//        list.display2(list.reverseList(list.head));

        // middle element of LL02
//        list.display2(list.middleNode(list.head));

//        list.tail.next = list.head;
//        System.out.println(list.hasCycle(list.head));


        //Reverse LL in K groups
        list.display2(list.reverseKGroup(list.head,3));

    }
}
