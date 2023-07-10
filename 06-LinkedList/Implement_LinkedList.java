
class LinkedList {
        /*----Node creation----*/
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;   //node's data
            this.next = null; //by default every Node point to the null
        }
    }
            /*---- ----*/

    public static Node head;    //this will point to the first Node of LinkedList (head Node)
    public static Node tail;    //this will point to the last Node of LinkedList (tail Node)
    public static int size; //this will track size of LinkedList

    //----------- Basic Function of LL ----------//
    /*---- Print Linked List ----*/
    public void print() {   //TC -> O(n)
            //corner Case -> when LinkedList is empty
        if(head == null) {
            System.out.println("LinkedList is Empty.......");
            return;
        }

            //step1 -> a temp node point to head node/first node (because if we use head node to print, head will not point to the first Node)
        Node temp = head;   
            //step2 -> run a loop until temp node is null
        while(temp != null) {  
            System.out.print("|"+temp.data+"|*|->");
                //step3 -> change the node to it's next
            temp = temp.next;   
        }
        System.out.print("null");
        System.out.println();
    }
            /*---- ----*/

    /*---- Add a Node at first of LinkedList ----*/
    public void addFirst(int data) {    //TC -> O(1)
            //step1 -> create a new Node
        Node newNode = new Node(data); 

            //corner case -> when LinkedList is empty
        if(head == null) {
            head = tail = newNode;  //connect the newNode
            size++; //when newNode is connected to LinkedList size will increase
            return;
        }

            //step2 -> connect newNode to current head
        newNode.next = head;    
        size++; //when newNode is connected to LinkedList size will increase
            //Step3 -> now newNode becomes head
        head = newNode; 
    }
                /*---- ----*/

    /*---- Add a Node at last of LinkedList ----*/
    public void addLast(int data) { //TC -> O(1)
            //step1 ->create a new Node
        Node newNode = new Node(data);

            //corner case -> LinedList is empty
        if(tail == null) {
            head = tail = newNode;  //connect the newNode
            size++; //when newNode is connected to LinkedList size will increase
            return;
        }

            //step2 -> connect tail to newNode
        tail.next = newNode;
        size++; //when newNode is connected to LinkedList size will increase
            //step3 -> now newNode becomes tail
        tail = newNode;
    }
                    /*---- ----*/

    /*---- Add a Node with index ----*/
    public void addWithIndex(int data, int index) { //TC -> O(n)
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
            /*---- ----*/

    /*---- Remove first Node of LinedList ----*/
    public int removeFirst() {  //TC -> O(1)
            //step1 -> a temp node point to head node/first node
        Node temp = head;

            //corner case
        if(head == null) {  //when LL is Empty
            System.out.println("LinkedList is Empty.......");
            return Integer.MIN_VALUE;
        }
        if(head.next == null) { //when LL have single Node 
            head = tail = null;
            temp.next = null;
            size = 0;   //no node is there
            return temp.data;
        }

            //step2 ->  point head to the 2nd Node
        head = head.next;
            //step3 ->  now disconnect temp note from LL
        temp.next = null;
        size--; //when Node is disconnected to LinkedList size will decrease
        return temp.data;
    }
                    /*---- ----*/

    /*---- Remove Last node of LinkedList ----*/
    public int removeLast() {
            //corner case
        if(head == null) {  //when LL is Empty
            System.out.println("LinkedList is Empty.......");
            return Integer.MIN_VALUE;
        }
        if(head.next == null) { //when LL have single Node 
            head = tail = null;
            size = 0;   //no node is there
            return head.data;
        }
            //step 1 -> point to the first Node
        Node prev = head;
        Node temp = head.next.next;

            //step 2 -> run a loop and reach to the previous Node last node
        while(temp != null) {
            prev = prev.next;// provide previous node of last node
            temp = temp.next;
        }
            //step 3 -> prev node point to null
        prev.next = null;
        int removeValue = tail.data;
            //step 4 -> now tail will point to prev node
        tail = prev;
        size--;//when newNode is disconnected to LinkedList size will decrease
        return removeValue;
    }
                    /*---- ----*/
    
    /*---- remove a node with Index ----*/
    public int removeWithIndex(int index){  //TC -> O(n)
            //corner case 1 -> when LinkedList is empty
        if(head == null){
            System.out.println("No Node is there for remove");
            return Integer.MIN_VALUE;
        }
            //corner case 2 -> when LinkedList have only 1 Node
        if(head.next == null){
            int removeValue = head.data;
            head = tail = null;
            size = 0;
            return removeValue;
        }
            //step 1 -> create a node point to head & a node point to head next
        Node prev = head;   //to find out the node
        Node deleteNode = head.next;    //to find out the node which want to delete
        int i = 0;
            //step 2 -> run a loop until find out DeleteNode
        while(i < index-1){
            prev = prev.next;
            deleteNode = deleteNode.next;
            i++;
        }
        int removeValue = deleteNode.data;
        //step 3 -> prev node's next point to delete  node's next
        prev.next = deleteNode.next;
        //step 4 -> delete node's next point to null
        deleteNode.next = null;
        size--;
        return removeValue;
    }
                /*---- ----*/
        //---------- ----------//

    /*---- Search in LinkedList ----*/
    public int  itrSearch(int key) {        //TC -> O(n)
        int i = 0;
        Node temp = head;

        while(temp != null) {
            if(temp.data == key) {  //check
                return i;
            }
            temp = temp.next;
            i++;
        }        
        return -1;
    }
    public int recursiveSearch(int key){    //TC -> O(n)
        return helper(head, key);
    }
    private int helper(Node head, int key) {
            //base case -> empty LinkedList
        if(head == null) {
            return -1;
        }
            //Check
        if(head.data == key) {
            return 0;
        }
            //recursive call
        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    } 
            /*---- ----*/

    /*---- Reverse LinkedLIst ----*/
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node nxt;

        while(curr != null) {
                //step1 -> next node of curr is nxt Node
            nxt = curr.next;
                //step2 -> curr Node point to prev Node
            curr.next = prev;
                //Step3 -> prev Node Becomes curr Node
            prev = curr;
                //step4 -> curr Node become nxt Node
            curr = nxt;
        }

        head = prev;
    }
        /*---- ----*/
}

public class Implement_LinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        /*ll.printLL();
        System.out.println("-->"+ll.size);
        ll.addFirst(0);
        ll.addFirst(9);
        ll.addFirst(5);
        
        ll.print();
        System.out.println("-->"+ll.size);

        ll.addLast(0);
        ll.addLast(9);
        ll.addLast(5);
        ll.print();
        System.out.println("-->"+ll.size);

        System.out.println(ll.removeFirst());
        ll.print();

        System.out.println(ll.removeLast());
        ll.print();

        ll.addWithIndex(11, 2);
        ll.print();*/
        
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.print();

        System.out.println(ll.itrSearch(7));
        System.out.println(ll.recursiveSearch(7));

        ll.reverse();
        ll.print();
        
    }
}