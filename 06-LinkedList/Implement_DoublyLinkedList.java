class DoublyLinkedList {
    /*----Create a Node----*/
    //step 1 -> create a class
    class Node{
            //step 2 -> create a data type and 2 pointer
        int data;
        Node next;
        Node prev;
            //step 3 -> create a constructor
        Node(int data){
            this.data = data;
            this.next = null;   //by default next point to null
            this.prev = null;   //by default prev point to null
        }
    }
        /*---- ----*/

    public static Node head;    //head point to the first node of LinkedList
    public static Node tail;    //tail point to the last node of LinkedList
    public static int size; //size will track the size of LinkedList

    /*----print LinkedList----*/
    public void printForward(){ //using next pointer
            //corner case -> LinkedList is empty
        if(head == null){
            System.out.println("LinkedList is empty........");
            return;
        }
            //step 1 -> a temp node point to the head Node
        Node temp = head;
            //step 2 -> run a loop until temp is null
        while(temp != null){
            System.out.print("|p|"+temp.data+"|n|<->");
                //step 3 -> temp point to next node
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void printBackward(){    //using prev pointer
            //corner case -> linkedList is Empty
        if(tail == null){
            System.out.println("LinkedList is Empty...........");
            return;
        }
            //step 1 -> create a temp node & point to tail
        Node temp = tail;
        System.out.print("null");
            //step 2 -> run a loop until temp = null
        while(temp != null){
            System.out.print("<->|p|"+temp.data+"|n|");
                //step 3 -> temp point to it's prev Node
            temp = temp.prev;
        }
        System.out.println();
    }
            /*---- ----*/

    /*----Add a node at first of LinkedList----*/
    public void addFirst(int data){
            //step 1 -> create a newNode
        Node newNode = new Node(data);

            //corner case -> Linked List is empty
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        
            //step 2 -> Connect the Node [newNode point to head Node(using next pointer) & head node point to the NewNode(using prev pointer)]
        newNode.next = head;
        head.prev = newNode;
        //step 3 -> head reinitialize to the first Node of LinkedList
        head = newNode;
        size++; //increase size when new Node connect to LinkedList
    }
                /*---------*/

    /*----Add a Node at last of LinkedList----*/
    public void addLast(int data){
            //step 1 -> create a new Node
        Node newNode = new Node(data);
            //corner case -> when LinkedList is Empty
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
            //step 2 -> connect the Node [tail point to the newNode & newNode point to  the tail Node]
        tail.next = newNode;
        newNode.prev = tail;
        //step 4 -> tail reinitialize to the last Node of LinkedList
        tail = newNode;
        size++; //increase size when newNode is connected to the LinkedList
    }
                /*--------*/

    /*----Add a Node with Index----*/
    public void addWithIndex(int data, int index){
            //corner case 1 -> add a node at 0th index
        if(index == 0){
            addFirst(data);
            return;
        }
            //corner case 2 -> add a node at the last of LinkedList
        if(index == size){
            addLast(data);
            return;
        }
            //corner case 3 -> when index is grater than size pf LinkedList
        if(index > size){
            System.out.println("unable to put the node.......\nCause >> index is greater than size");
            return;
        }

            //step 1 -> create a new Node
        Node newNode = new Node(data);
            //step 2 -> create another 2 nodes to track the previous node and current index node
        Node prevNode = head;
        Node temp = head.next;
        int i = 0;
            //step 3 -> run a loop until find out previous index node
        while(i < index-1){
            prevNode = prevNode.next;
            temp = temp.next;
            i++;
        }
            //step 4 -> using next pointer >> connect prevNode to newNode & then newNode to temp
        prevNode.next = newNode;
        newNode.next = temp;
            
            //step 5 -> using prev pointer >> connect temp to newNode & then newNode to prevNode
        temp.prev = newNode;
        newNode.prev = prevNode;
        size++; //increase size when newNode is connected to the LinkedList
    }
                /*---- ----*/

    /*----Remove the first Node of LinedList----*/
    public int removeFirst(){
            //corner case 1 -> when LinedList is empty
        if(head == null){
            System.out.println("LinkedList is empty.......can not perform remove operation!!");
            return Integer.MIN_VALUE;
        }
            //corner case 2 -> when LinkedList have only 1 element
        if(head.next == null){
            int removeValue = head.data;
            head = tail = null;
            return removeValue;
        }
            //step 1 -> create a temp node and point it to the first Node
        Node temp = head;
        int removeValue = head.data;
            //step 2 -> head point to head's next Node OR head is reinitialized to the 2nd node
        head = head.next;
            //step 3 -> now head's prev point to null
        temp.next = head.prev = null;
        size--; //when a Node is disconnected from LinkedList decrease the size
        return removeValue;
    }
                /*---- ----*/

    /*----Remove the last Node of LinkedList----*/
    public int removeLast(){
            //corner case 1 -> when LinedList is empty
        if(head == null){
            System.out.println("LinkedList is empty.......can not perform remove operation!!");
            return Integer.MIN_VALUE;
        }
            //corner case 2 -> when LinkedList have only 1 element
        if(head.next == null){
            int removeValue = head.data;
            head = tail = null;
            return removeValue;
        }
            //step 1 -> create a temp Node and point to the last Node
        Node temp = tail;
        int removeValue = tail.data;
            //step 2 -> tail point to tail's prev Node OR tail is reinitialized to the 2nd last node
        tail = tail.prev;
            //step 3 -> now tail's next point to null
        tail.next = temp.prev = null;
        size--; //when a Node is disconnected from LinkedList decrease the size
        return removeValue;
    }
                /*--------*/

    //----Remove a Node with Index----//
    public int removeWithIndex(int index){
            //corner case 1 -> when need to remove first Node
        if(index == 0){
            return removeFirst();
        }
            //corner case 2-> when need to remove last Node
        if(index == size-1){
            return removeLast();
        }
            //corner case 3-> when index is grater than size
        if(index > size){
            System.out.println("At index "+index+" no Node is there.........");
            return Integer.MIN_VALUE;
        }
            //step 1 -> create 3 Nodes >> i) point to head, ii) point to 2nd Node, iii) point to 3rd Node
        Node prevNode = head;
        Node deleteNode = head.next;
        Node nextNode = head.next.next;
        int i = 0;
            //step 2 -> run a loop until reach the Node which need to delete
        while(i < index-1){
            prevNode = prevNode.next;
            deleteNode = deleteNode.next;
            nextNode = nextNode.next;
            i++;
        }
            //step 3 -> connect prevNode to nextNode & connect nextNode to prevNode
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
            //step 4 -> disconnect deleteNode
        deleteNode.next = deleteNode.prev = null;
        size--; //when a Node is disconnected from LinkedList decrease the size
        return deleteNode.data;

    }
                /*---- ----*/
    
}

public class Implement_DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(0);
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.addLast(7);
        dll.printForward();
        dll.printBackward();
    }
}
