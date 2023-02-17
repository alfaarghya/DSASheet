import java.util.Queue;
import java.util.LinkedList;

class Stack1{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int data){    //TC -> O(n)
            //if there is any element at Queue1 move them to Queue2 until Queue1 is empty
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }

        q1.add(data);   //add new data to Queue1

            //now add all the data back to Queue 1
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
    }

    boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty();
    }
    int pop(){  // TC -> O(1)
        if(isEmpty()){
            System.out.println("Stack is empty.............");
            return Integer.MIN_VALUE;
        }

        return q1.remove();
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty.............");
            return Integer.MIN_VALUE;
        }

        return q1.peek();
    }
}

class Stack2{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int data){    //TC -> O(1)
        q1.add(data);
    }

    boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty();
    }

    int pop(){  // TC -> O(n)
        if(isEmpty()){
            System.out.println("Stack is empty...........");
            return Integer.MIN_VALUE;
        }

        int top = -1;
            //case 1
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
            }
        }
            // case 2
        else{
            while(!q2.isEmpty()){
                top = q2.remove();
                if(q2.isEmpty()){
                    break;
                }
                q1.add(top);
            }
        }
        return top;
    }

    int peek(){ //TC -> O(n)
        if(isEmpty()){
            System.out.println("Stack is empty...........");
            return Integer.MIN_VALUE;
        }

        int top = -1;
            //case 1
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                q2.add(top);
            }
        }
            //case 2
        else{
            while(!q2.isEmpty()){
                top = q2.remove();

                q1.add(top);
            }
        }
        return top;
    }
}

public class Queue02_StackUsingQueues {
    public static void main(String[] args) {
        Stack1 s1 = new Stack1();
        s1.push(0);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        while(!s1.isEmpty()){
            System.out.println(s1.peek());
            s1.pop();
        }

        System.out.println("-------------------------");
        Stack2 s2 = new Stack2();
        s2.push(0);
        s2.push(1);
        s2.push(2);
        s2.push(3);
        
        while(!s2.isEmpty()){
            System.out.println(s2.peek());
            s2.pop();
        }
        
    }
}
