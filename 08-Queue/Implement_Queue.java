class QueueWithArray {
    static int[] arr;   //array for the queue
    static int size;    //size of the array
    static int rear;    //index to track where is the last element

    QueueWithArray(int sizeOfQueue){  //constructor
        arr = new int[sizeOfQueue];   //declaring array size
        size = sizeOfQueue;
        rear = -1;
    }

        /*---- checking array is empty or not ----*/
    boolean isEmpty(){
        return rear == -1;
    }
                    /*--------*/

        /*---- Add a element to Queue ----*/
    void add(int data){ // TC -> O(1)
        if (rear == size-1){
            System.out.println("Alert! >>> Queue is full.... can't add any value now");
            return;
        }
            //add a value in array with rear index
        rear++;
        arr[rear] = data;
    }
                /*---- ----*/

        /*---- Remove a element from Queue ----*/
    int remove(){ // TC -> O(n)
        if(isEmpty()){
            System.out.println("Alert! >>> Queue is empty");
            return -1;
        }
            //step 1 -> store first value in front
        int front = arr[0]; //always delete 0th index or the first element
            //step 2 -> delete the first element
        for(int i = 0; i < rear; i++){
            arr[i] = arr[i+1];  //re-initialize i+1th element to i index
        }
            //step 3 -> decrease the rear by 1.....to track current index where is last element
        rear--;
        return front;
    }
                    /*---- ----*/

        /*---- Peek to see which element in front ----*/
    int peek(){
        if(isEmpty()){
            System.out.println("Alert! >>> Queue is empty");
            return -1;
        }
            //step -> simply return first element
        return arr[0];
    }
                        /*---- ----*/
}

class QueueWithLinkedList{

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

        /*---- add a data in queue ----*/
    void add(int data){
            //Step 1 -> create a new Node
        Node newNode = new Node(data);
            //corner case -> when linkedList is empty
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
            //Step 2 -> tail point to the new node
        tail.next = newNode;
            //Step 3 -> newNode become tail
        tail = newNode;
        size++;
    }
                /*---- ----*/

        /*---- remove a data from Queue ----*/
    int remove(){
            //corner case 1 -> when LinkedList is empty
        if(isEmpty()){
            System.out.println("Queue is empty.........");
            return Integer.MIN_VALUE;
        }
            //corner case 2 -> when 1 node in linkedList
        if(head.next == null){
            Node temp = head;
            head = tail = null;
            size--;
            return temp.data;
        }
            //step 1 -> create a node which point to the first Node
        Node front = head;
            //step 2 -> now head come to the 2nd node
        head = head.next;
            //step 3 -> disconnect the connection of the first Node with the LinkedList
        front.next = null;
        size--;
        return front.data;
    }
                /*---- ----*/

        /*---- to see first element ----*/
    int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty.........");
            return Integer.MIN_VALUE;
        }

        return head.data;
    }
                /*---- ----*/
    boolean isEmpty(){
        return (head == null && tail == null);
    }
        
        /*---- normal print in linked list ----*/
    void printLL(){
        if(head == null){
            System.out.println("Queue is empty..........");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
                    /*---- ----*/
}

public class Implement_Queue {
    public static void main(String[] args) {
        QueueWithArray qa = new QueueWithArray(10);
        qa.add(1);
        qa.add(2);
        qa.add(3);

        // qa.remove();
        // qa.remove();
        System.out.println("----Print----");
        while(!qa.isEmpty()){
            System.out.println(qa.peek());
            qa.remove();
        }
        System.out.println("--------------------------------");

        QueueWithLinkedList qll = new QueueWithLinkedList();
        qll.add(0);
        qll.add(1);
        qll.add(2);
        qll.add(3);
        System.out.println(qll.size);
        qll.printLL();
        qll.remove();
        System.out.println(qll.size);
        qll.printLL();
    }
}
