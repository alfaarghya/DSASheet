import java.util.ArrayList;

class StackWithArrayList{
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public void push(int data){
        list.add(data);
    }

    public int pop(){
        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }

    public int peek(){
        return list.get(list.size()-1);
    }


}

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

public class DS04_Stack {
    public static void main(String[] args) {
        System.out.println("-----Stack with ArrayList-----");
        StackWithArrayList stkA = new StackWithArrayList();
        stkA.push(0);
        stkA.push(1);
        stkA.push(2);

        while(!stkA.isEmpty()){
            System.out.println(stkA.peek());
            stkA.pop();
        }
        
        System.out.println("--------------------");
        stkA.push(3);
        stkA.push(4);
        stkA.push(5);
        while(!stkA.isEmpty()){
            System.out.println(stkA.peek());
            stkA.pop();
        }

        System.out.println("-----Stack Linked List-----");
        StackWithLinkedList stkLL = new StackWithLinkedList();
        stkLL.push(0);
        stkLL.push(1);
        stkLL.push(2);

        System.out.println("peek --> "+stkLL.peek());

        while(!stkLL.isEmpty()){
            System.out.println(stkLL.peek());
            stkLL.pop();
        }
    }
}
