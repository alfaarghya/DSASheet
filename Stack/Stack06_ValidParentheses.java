/*
valid Parentheses --
    Given a string containing just the  characters '(',')','{','}','[',']' determine is the input staring is valid.
    An input string is valid if:
    1. open brackets must be closed by the same type of brackets.
    2. open brackets must be closed in the correct order.
    3. every close bracket has a corresponding open bracket of same type
*/
import java.util.Stack;
public class Stack06_ValidParentheses {

    public static boolean isValidParentheses(String str){   //TC --> O(n)
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
                //when we get opening brackets --> push them into stack
            if(ch == '(' || ch == '{' || ch == '['){
                stk.push(ch);
            }
                //when we get closing brackets
            else{
                    //if we have only closing parentheses like this --> ")}])"........on that time our stack is empty....so simply return false
                if(stk.isEmpty()){
                    return false;
                }
                    //when brackets makes pair
                if((stk.peek() == '(' && ch == ')') || (stk.peek() == '{' && ch == '}') || (stk.peek() == '[' && ch == ']') ){
                    stk.pop();
                }
                    //when brackets does not make any pair -> "{[]([)}"
                else{
                    return false;
                }
            }
        }

            //after running the loop completely......when there are no brackets left that's mean all brackets are in pair
        if(stk.isEmpty()){
            return true;
        }
            //string -> "{([]{[]}())".....here,'{' this bracket stay in the stack because it has no pair
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        String str1 = ")}])";
        String str2 = "{([]{[]}())";
        String str3 = "{[]([)}";
        String str4 = "[]{([])[]}";
        System.out.println(isValidParentheses(str4));
    }
}
