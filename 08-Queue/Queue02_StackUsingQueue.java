import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Stack1 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    void push(int data) { // TC -> O(n)
        // when stack is empty
        if (q1.isEmpty()) {
            q1.add(data);
            return;
        }

        // pop up all data from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        q1.add(data); // adding data into q1

        // pop up all data from q2 to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty....");
            return Integer.MIN_VALUE;
        }

        return q1.remove();
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty....");
            return Integer.MIN_VALUE;
        }

        return q1.peek();
    }
}

class Stack2 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int data) { // TC -> O(1)
        q1.add(data);
    }

    boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    int pop() { // TC -> O(n)
        if (isEmpty()) {
            System.out.println("Stack is empty...........");
            return Integer.MIN_VALUE;
        }

        int top = -1;
        // case 1
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                top = q1.remove();
                if (q1.isEmpty()) {
                    break;
                }
                q2.add(top);
            }
        }
        // case 2
        else {
            while (!q2.isEmpty()) {
                top = q2.remove();
                if (q2.isEmpty()) {
                    break;
                }
                q1.add(top);
            }
        }
        return top;
    }

    int peek() { // TC -> O(n)
        if (isEmpty()) {
            System.out.println("Stack is empty...........");
            return Integer.MIN_VALUE;
        }

        int top = -1;
        // case 1
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                top = q1.remove();
                q2.add(top);
            }
        }
        // case 2
        else {
            while (!q2.isEmpty()) {
                top = q2.remove();

                q1.add(top);
            }
        }
        return top;
    }
}

class StackUsingDeque {
    Deque<Integer> dq = new LinkedList<>();

    boolean isEmpty() {
        return dq.isEmpty();
    }

    void push(int data) {
        dq.addFirst(data);
    }

    int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty...........");
            return Integer.MIN_VALUE;
        }

        return dq.removeFirst();
    }

    int peek() {
        if(isEmpty()) {
            System.out.println("Stack is Empty...........");
            return Integer.MIN_VALUE;
        }

        return dq.getFirst();
    }
}


public class Queue02_StackUsingQueue {
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
        System.out.println("-------------------------");

        StackUsingDeque s3 = new StackUsingDeque();
        s3.push(0);
        s3.push(1);
        s3.push(2);
        s3.push(3);

        while(!s3.isEmpty()){
            System.out.println(s3.peek());
            s3.pop();
        }
    }
}
