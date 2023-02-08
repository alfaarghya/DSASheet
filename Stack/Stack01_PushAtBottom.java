/**/
import java.util.Stack;

public class Stack01_PushAtBottom{
    public static void pushAtBottom(Stack<Integer> stack, int data){
            //Base Case
        if(stack.isEmpty()){
            stack.push(data);   //push the data at the bottom of Stack
            return;
        }
        int top = stack.pop();  //pop data 
        pushAtBottom(stack, data);  //recursive call
        stack.push(top);    //putting all data back to stack
    }
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();

        stk.push(1);
        stk.push(2);
        stk.push(3);

        pushAtBottom(stk, 4);

        while(!stk.isEmpty()){  //printing the stack
            int top = stk.pop();
            System.out.println(top);
        }


    }
}