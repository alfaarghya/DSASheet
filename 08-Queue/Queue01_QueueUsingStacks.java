import java.util.Stack;

class Queue1 {  //Time complexity of Add operation is O(n)
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    boolean isEmpty() {
        return stk1.isEmpty();
    }

    void add(int data) {    //TC -> O(n)
            //corner case
        if(isEmpty()) {
            stk1.push(data);
            return;
        }
            //shift all data from stack1 to stack2
        while(!stk1.isEmpty()) {
            stk2.push(stk1.pop());
        }

        stk1.push(data);    //push the data

            //again all data shift from stack2 to stack1
        while(!stk2.isEmpty()) {
            stk1.push(stk2.pop());
        }
    }

    int remove() {  //TC -> O(1)
        if(isEmpty()) {
            System.out.println(" >> Queue is empty");
            return Integer.MIN_VALUE;
        }
        return stk1.pop();
    }

    int peek() {    //TC -> O(1)
        if(isEmpty()) {
            System.out.println(" >> Queue is empty");
            return Integer.MIN_VALUE;
        }

        return stk1.peek();
    }
}
class Queue2 {  //Time complexity of Add operation is O(n)
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    boolean isEmpty() {
        return stk1.isEmpty()&& stk2.isEmpty();
    }

    void add(int data) {    //TC -> O(1)
        stk1.add(data);
    }

    int remove() {  //TC -> O(n)
        if(isEmpty()) {
            System.out.println(" >> Queue is empty");
            return Integer.MIN_VALUE;
        }
        while(!stk1.isEmpty()) {
            stk2.push(stk1.pop());
        }
        return stk2.pop();
    }

    int peek() {    //TC -> O(1)
        if(isEmpty()) {
            System.out.println(" >> Queue is empty");
            return Integer.MIN_VALUE;
        }

        return stk2.peek();
    }
}

public class Queue01_QueueUsingStacks {
    public static void main(String[] args) {
        Queue1 q1 = new Queue1();
        System.out.println(q1.isEmpty());
        q1.add(0);
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);

        while(!q1.isEmpty()) {
            System.out.print(q1.peek()+" ");
            q1.remove();
        }
        System.out.println("\n"+q1.isEmpty());

        
        Queue2 q2 = new Queue2();
        System.out.println(q2.isEmpty());
        q2.add(0);
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        q2.add(5);

        while(!q2.isEmpty()) {
            System.out.print(q2.remove()+" ");
            // q2.remove();
        }
        System.out.println("\n"+q2.isEmpty());
    }
}
