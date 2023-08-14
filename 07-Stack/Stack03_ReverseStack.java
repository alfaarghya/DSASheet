import java.util.Stack;

public class Stack03_ReverseStack {

    public static void reverseStack(Stack<Integer> stk) {   //TC -> O(n) || TC -> O(1)
            //base case -> when ever stk is empty stop recursion
        if(stk.isEmpty()) { 
            return;
        }
        int top = stk.pop();
        reverseStack(stk);
        pushBack(stk, top);
    }

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
        stk.push(4);

        reverseStack(stk);

        while(!stk.isEmpty()) {
            System.out.println(stk.pop());
        }
    }
}
