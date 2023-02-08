class StackWithLinkedList{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;

    public boolean isEmpty(){
        return head==null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop(){
        Node top = head;
        head = head.next;
        top.next = null;
        return top.data;
    }

    public int peek(){
        return head.data;
    }
}

public class DS05_StackWithLinkedList {
    public static void main(String[] args) {
        StackWithLinkedList stk = new StackWithLinkedList();
        // StackWithArrayList stk = new StackWithArrayList();
        stk.push(0);
        stk.push(1);
        stk.push(2);

        System.out.println(stk.peek());

        while(!stk.isEmpty()){
            System.out.println(stk.peek());
            stk.pop();
        }
    }
}
