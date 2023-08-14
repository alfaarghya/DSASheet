/*
Duplicate Parentheses --
    Given a balanced expression, find of it contains duplicate parentheses or not. A set of parentheses are duplicate if the same subexpression is surrounded by multiple parentheses.

    return a true if it contains duplicates else return false.

    Example 1 -
    (((a+(b)))+(c+d))
    output -> true

    Example 2 -
    ((((a)+(b))+c+d))
    output -> true

    Example 3 - 
    ((a+b)+(c+d))
    output -> false

    Example 4 -
    (((a+b))+c)
    output -> true

 */

import java.util.Stack;

public class Stack06_DuplicateParentheses {

    public static boolean isDuplicateParentheses(String str) {
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

                //opening brackets or operand or operator -> push into stack
            if(ch != ')' || ch != '}' || ch == ']') {
                stk.push(ch);
            } else {    //closing brackets
                int count = 0;
                    //run a loop until we found opening bracket
                while(stk.peek() != '(' && stk.peek() != '{' && stk.peek() != '[') {
                    stk.pop();
                    count++;
                }
                    //duplicate parentheses -> return true
                if(count == 0) {
                    return true;
                } else {    //if it is not a duplicate -> pop it out from stk
                    stk.pop();
                }
            }
        }
            //no duplicate parentheses
        return false;
    }

    public static void main(String[] args) {
        String str = "(((a+b)*(a-b)))";

        System.out.println(isDuplicateParentheses(str));
    }
}
