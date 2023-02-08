import java.util.Stack;

public class Stack03_ReverseStack {

    public static void pushAtBottom(Stack<Integer> stk ,int data){
        if(stk.isEmpty()){
            stk.push(data); //push the data at the bottom of Stack
            return;
        }

        int top = stk.pop(); //pop data 
        pushAtBottom(stk, data);  //recursive call
        stk.push(top);    //putting all data back to stack
    }

    public static void reverseStack(Stack<Integer> stk){
            //baseCase
        if(stk.isEmpty()){
            return;
        }
        int top = stk.pop();    //pull out the data from stack
        reverseStack(stk);  //recursive call
        pushAtBottom(stk, top); //push all data back to the stack but from bottom

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverseStack(stack);

        while(!stack.isEmpty()){
            int top = stack.pop();
            System.out.println(top);
        }

    }
}
