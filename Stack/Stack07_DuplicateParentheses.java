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
public class Stack07_DuplicateParentheses {

    public static boolean isDuplicateParentheses(String str){
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

                //wen we get closing brackets
            if(ch == ')' || ch == '}' || ch == ']'){
                int count = 0;
                    //run a loop until closing brackets find out their pair brackets
                while(stk.peek() != '(' && stk.peek() != '{' && stk.peek() != '['){
                    stk.pop();
                    count++;
                }

                    //if are no valid operation between bracket pair....that's mean pair is a duplicate 
                if (count == 0){
                    return true;
                }
                    //if there are valid operation between brackets pair......pop the opening bracket
                else{
                    stk.pop();
                }
            }
                //push all opening brackets, operator, operand into stack
            else{
                stk.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "((a+b)*(a-b))";
        String str2 = "[[{(a+b+c)*(a-b-c)*(a*b*c)}/d]]";
        String str3 = "[{(a+b+c)*(a-b-c)*(a*b*c)}/d]";
        String str4 = "(a+(b))*(a-b)";
        
        System.out.println("is there any duplicate parentheses?(true/false)");
        System.out.println("--> "+isDuplicateParentheses(str4));
    }
}
