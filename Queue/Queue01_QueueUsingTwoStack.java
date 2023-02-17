import java.util.Stack;

class Queue_1{
    Stack<Integer> s1 = new Stack<>();  //Work as a Queue
    Stack<Integer> s2 = new Stack<>();  //helping stack

    void add(int data){ //TC -> O(n)
            //corner case -> when Stack is empty
        if(s1.isEmpty()){
            s1.push(data);
            return;
        }
            //step 1 -> push all data from stack1 to stack2 & pop s1 until it get empty
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
            //step 2 -> now push new data at stack1 
        s1.push(data);
            // step 3 -> now pus all data from stack2 to stack1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    int remove(){   //TC -> O(1)
        if(isEmpty()){
            System.out.println("Queue is empty....");
            return Integer.MIN_VALUE;
        }
        return s1.pop();
    }

    int peek(){ //TC -> O(1)
        if(isEmpty()){
            System.out.println("Queue is empty....");
            return Integer.MIN_VALUE;
        }
        // return s1.pop(); //this is also work......but  this can pop(remove) a value
        return s1.peek(); //it can't pop(remove) any value.....
    }

    boolean isEmpty(){  // it check Queue is empty or not
        return s1.isEmpty();
    }
}

class Queue_2{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void add(int data){ //TC -> O(1)
        s1.push(data);
    }

    int remove(){   //TC -> O(n)
            //push all element to Stack 2
        while(!s1.isEmpty()){   
            s2.push(s1.pop());
        }
            //remove top data
        return s2.pop();
    }

    int peek(){
        return s2.peek();
    }

    boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }

}

public class Queue01_QueueUsingTwoStack{
    public static void main(String[] args) {
        Queue_1 q1 = new Queue_1();
        q1.add(1);
        q1.add(2);
        q1.add(3);

        while(!q1.isEmpty()){
            System.out.println(q1.remove());
        }

        System.out.println("--------------------------------");
        Queue_2 q2 = new Queue_2();
        q2.add(0);
        q2.add(1);
        q2.add(2);
        q2.add(3);
        while(!q2.isEmpty()){
            System.out.println(q2.remove());
        }
    }
}