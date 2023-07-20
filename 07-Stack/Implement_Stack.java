import java.util.ArrayList;

class StackWithArrayList {
        //create arraylist -> to store inserted data
    static ArrayList<Integer> list = new ArrayList<>();

        /*---- check if stack is empty or not ----*/
    public boolean isEmpty() {
        return list.size() == 0;
    }
                    /*---- ----*/
        /*---- adding a data into stack ----*/
    public void push(int data) { //TC -> O(1)
        list.add(data);
    }
                    /*---- ----*/
        /*---- remove top data from stack ----*/
    public int pop() {  //TC -> O(1)
        if(isEmpty()) { //corner case -> stack is empty
            System.out.print("Empty.....");
            return Integer.MIN_VALUE;
        }
        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }
                    /*---- ----*/
        /*---- peek into stack ----*/
    public int peek() { //TC -> O(1)
        if(isEmpty()) { //corner case -> stack is empty
            System.out.print("Empty.....");
            return Integer.MIN_VALUE;
        }
        return list.get(list.size()-1);
    }
                /*---- ----*/
}

class StackWithLinkedList {
    /*---- Node ----*/
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
      /*---- ----*/
    static Node head;

    /*---- isEmpty? ----*/
    public boolean isEmpty() { //TC -> O(1)
        return head == null;
    }
        /*---- ----*/
    /*---- Adding a data into Stack ----*/
    public void push(int data) {    //TC -> O(1)
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode; 
    }
                /*---- ----*/
    /*---- remove top data from stack ----*/
    public int pop() {  //TC -> O(1)
        if(isEmpty()) {
            System.out.print("Empty.....");
            return Integer.MIN_VALUE;
        }
        Node top = head;
        head = head.next;
        top.next = null;
        return top.data;
    }
                /*---- ----*/
    /*---- peek into stack ----*/
    public int peek() { //TC -> O(1)
        if(isEmpty()) {
            System.out.print("Empty.....");
            return Integer.MIN_VALUE;
        }
        return head.data;
    }
        /*---- ----*/
}

public class Implement_Stack {
    public static void main(String[] args) {
        StackWithArrayList sla = new StackWithArrayList();
        sla.push(0);
        sla.push(1);
        sla.push(2);
        sla.push(3);

        System.out.println(">> "+sla.peek());
        
        while(!sla.isEmpty()) {
            System.out.println(sla.pop());
        }
        // System.out.println(sla.pop());
        System.out.println(sla.peek());
        // ------------------

        StackWithLinkedList sll = new StackWithLinkedList();
        sll.push(0);
        sll.push(1);
        sll.push(2);
        sll.push(3);
        System.out.println(">>" + sll.peek());
        
        while(!sll.isEmpty()) {
            System.out.println(sll.pop());
        }
        System.out.println(sll.peek());
        System.out.println(sll.pop());


    }
}
