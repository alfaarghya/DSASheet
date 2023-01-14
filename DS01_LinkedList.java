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

        //----add a new node with Index----//
    public void addWithIndex(int data, int index){
            //corner case -> when index is greater than size of LinkedList
        if(index > size){
            System.out.println("unable to put the node.......Cause index is greater than size");
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
            //step 1 -> create a new Node & tracking Node
        Node newNode = new Node(data);
        Node prev = head;   //track the previous index node
        int i = 0;
            //step 2 -> a loop will run until found the previous index Node
        while(i < index-1){
            prev = prev.next;   //provides previous index Node of Index
            i++;
        }
            //step 3 -> now newNode point to next index Node
        newNode.next = prev.next;
            //step 4 -> previous index Node points to newNode
        prev.next = newNode;

    }
                //----------//
        //----remove first node of LinkedList----//
    public int removeFirst(){
            //corner case 1 -> when linkedList is empty
        if(head == null){   //if(size == 0) -> we can also write this when we know the size
            System.out.println("No Node is there for remove");
            return Integer.MIN_VALUE;
        }
            //corner case 2 -> when there is single Node
        if(head.next == null){  //if(size == 1) -> we can also write this when we know size
            int removeValue = head.data;
            head = tail = null;
            size = 0; //no node is there
            return removeValue;
        }
            //step 1 -> create a temp Node and point it to the first Node
        Node temp = head;
        int removeValue = temp.data;
            //step 2 -> head point to next node of head
        head = temp.next;
        size--;
        return removeValue; //return the deleted data
    }
                    //----------//

        //----remove last node of LinkedList----//
    public int removeLast(){
            //corner case 1-> when LinkedList is empty
        if(head == null){   //if(size == 0) -> we can also write this when we know size
            System.out.println("No Node is there for remove");
            return Integer.MIN_VALUE;
        }
            //corner case 2-> when LinkedList have a single Node
        if(head.next == null){  //if(size == 1) -> we can also write this when we know size
            int removeValue = head.data;
            head = tail = null;
            return removeValue;
        }
        int removeValue = tail.data;
            //step 1 -> point to the first Node
        Node prev = head;
        Node temp = head.next.next;
            //step 2 -> run a loop and reach to the previous Node last node
        while(temp != null){
            prev = prev.next; // provide previous node of last node
            temp = temp.next;
        }
        /*    //step 2 -> run a loop and reach to the previous Node last node(we can use this when we know the size)
        for(int i = 0; i < size-2; i++){
            prev = prev.next;
        }*/
            //step 3 -> prev node point to null
        prev.next = null;
            //step 4 -> now tail will point to prev node
        tail = prev;
        size--;
        return removeValue;
    }
                    //---------//


}
public class DS01_LinkedList{
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addLast(5);
        ll.addLast(4);
        ll.addFirst(0);
        // ll.removeFirst();
        // ll.removeLast();
        // System.out.println(ll.removeLast());
        ll.addWithIndex(3, 4);

        ll.print();
    }
}
