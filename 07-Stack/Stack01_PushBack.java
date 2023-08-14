/* push a data at the bottom of the stack */
import java.util.Stack;

public class Stack01_PushBack {

    public static void pushBack(Stack<Integer> stk, int data) { //TC -> O(n) || Sc -> O(1)
            //base case -> when ever stk is empty push the data
        if(stk.isEmpty()) {
            stk.push(data);
            return;
        }
        int top = stk.pop();    //pop data from top
        pushBack(stk, data);    //recursive call
        stk.push(top);          //put all the data bak into stack
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);

        pushBack(stk, 4);

        //print elements of stack
        while(!stk.isEmpty()) {
            System.out.println(stk.pop());
        }

    }
}
