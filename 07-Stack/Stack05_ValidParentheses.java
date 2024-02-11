/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */


import java.util.Stack;

public class Stack05_ValidParentheses {

    public static boolean isValidParentheses(String str) {
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
                //opening brackets -> push into stk
            if(ch == '[' || ch == '{' || ch == '(') {
                stk.push(ch);
            } else {
                if(stk.isEmpty()) {
                    return false;
                }
                    //brackets pair -> pop from stk
                else if( (stk.peek() == '[' && ch == ']') || (stk.peek() == '{' && ch == '}') || (stk.peek() == '(' && ch == ')')) {
                    stk.pop();
                } else {    //dose not make a pair
                    return false;
                }
            }
        }

            //all brackets are valid.....so stack will be empty
        if(stk.isEmpty()) {
            return true;
        }
            //all brackets are not valid
        return false;
    }

    public static void main(String[] args) {
        String str1 = "[]{([])[]}";
        String str2 = "[{()()(}]}";
        String str3 = "(}";
        String str4 = "()";
        String str5 = "(){}[]";
        String str6 = "]";
        System.out.println(isValidParentheses(str6));
    }
}