import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue05_QueueReversal {

    public static void queueReverse(Queue<Integer> q) {
        Stack<Integer> stk = new Stack<>();
            //store queue's all element in stack
        while(!q.isEmpty()) {
            stk.push(q.remove());
        }
            //store stack's all elements back in queue
        while(!stk.isEmpty()) {
            q.add(stk.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); 
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        queueReverse(q);

        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
