import java.util.Deque;
import java.util.LinkedList;

public class Implement_Deque {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);
        System.out.println(dq);

        dq.addLast(4);
        dq.addLast(5);
        dq.addLast(6);
        System.out.println(dq);

        dq.removeFirst();
        System.out.println(dq);

        dq.removeLast();
        System.out.println(dq);

    }
}
