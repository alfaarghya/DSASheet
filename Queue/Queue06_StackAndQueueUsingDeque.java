import java.util.Deque;
import java.util.LinkedList;

class Stack{
    Deque<Integer> deque = new LinkedList<>();

    void push(int data){
        deque.addFirst(data);   //push a data at the front
    }

    int pop(){
        if(deque.isEmpty()){
            System.out.println("Deque is Empty.........");
            return Integer.MIN_VALUE;
        }
        return deque.removeFirst(); //remove the first data
    }

    int peek(){
        if(deque.isEmpty()){
            System.out.println("Deque is Empty.........");
            return Integer.MIN_VALUE;
        }
        return deque.peekFirst();   //look at the first element
    }

    boolean isEmpty(){
        return deque.isEmpty();
    }
}

    class Queue{
        Deque<Integer> deque = new LinkedList<>();

        void add(int data){
            deque.addLast(data);    //push all data at the last
        }
        
        int remove(){
            if(deque.isEmpty()){
                System.out.println("Deque is Empty.........");
                return Integer.MIN_VALUE;
            }
            return deque.removeFirst(); // remove the first data
        }

        int peek(){
            if(deque.isEmpty()){
                System.out.println("Deque is Empty.........");
                return Integer.MIN_VALUE;
            }
            return deque.peekFirst();   // look at the element
        }

        boolean isEmpty(){
            return deque.isEmpty();
        }
    }


public class Queue06_StackAndQueueUsingDeque {
    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.push(1);
        stk.push(2);
        stk.push(3);

        while(!stk.isEmpty()){
            System.out.println(stk.pop()+" ");
        }

        System.out.println("-----------------------------");

        Queue q = new Queue();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.remove()+" ");
        }
    }
}
