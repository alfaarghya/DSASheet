class LinkedList{
        //----Node Creation----//
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;   //data add to Node
            this.next = null;   //every Node's next will point to null
        }
    }
            //----------//

    public static Node head;    //this will point to the first Node of LinkedList (head Node)
    public static Node tail;    //this will point to the last Node of LinkedList (tail Node)
    public static int size; //this will track size of LinkedList

        //----this will print LinkedList----//
    public void print(){
            //corner case -> when LinkedList is empty
        if(head == null){
            System.out.println("LinkedList is Empty.......");
            return;
        }
            //step 1 -> must create a new node and point to the first Node of LinkedList(because if we use head node to print, head will not point to the first Node)
        Node temp = head;
        while(temp != null){    //when temp == null, this loop will stop running
            System.out.print("|"+temp.data+"|*|->");
                //step 2 -> temp point to the next node
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
                //----------//

        //----add a node at the first of LinkedList----//
    public void addFirst(int data){
            //step 1 -> create a new Node
        Node newNode = new Node(data);
            //corner case -> when LinedList is empty
        if(head == null){
            head = tail = newNode;
            size++; //when newNode is connected to LinkedList size will increase
            return;
        }
            //step 2 -> newNode must point to head Node
        newNode.next = head;
        size++; //when newNode is connected to LinkedList size will increase
            //step 3 -> now head will reassigned to newNode
        head = newNode;

    }
                        //----------//

        //----add a new node at last of LinkedList----//
    public void addLast(int data){
            //step 1 -> create a new node
        Node newNode = new Node(data);
            //corner case -> when LinkedList is empty
            if(head == null){
                head = tail = newNode;
                size++; //when newNode is connected to LinkedList size will increase
                return;
            }
            //step 2 -> last node point to the new Node
        tail.next = newNode;
        size++; //when newNode is connected to LinkedList size will increase
            //step 3 -> now tail is reassigned to newNode
        tail = newNode;
    }
                        //---------//
}
public class DS01_LinkedList{
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addLast(5);
        ll.addLast(4);
        ll.addFirst(0);

        ll.print();
    }
}
