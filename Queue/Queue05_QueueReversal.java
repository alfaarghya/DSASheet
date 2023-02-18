import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Queue05_QueueReversal {    //TC -> O(n)

    public static void reversal(Queue<Integer> q){
        Stack<Integer> stk = new Stack<>();
            //step 1 -> move all the data from Queue to Stack
        while(!q.isEmpty()){
            stk.push(q.remove());
        }
            //step 2 -> move all data from Stack to Queue
        while(!stk.isEmpty()){
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

        reversal(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
