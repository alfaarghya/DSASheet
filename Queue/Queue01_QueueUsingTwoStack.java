import java.util.Stack;

class Queue{
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
        return s1.pop();
    }

    int peek(){ //TC -> O(1)
        return s1.peek();
    }

    boolean isEmpty(){  // it check Queue is empty or not
        return s1.isEmpty();
    }
}

public class Queue01_QueueUsingTwoStack{
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}