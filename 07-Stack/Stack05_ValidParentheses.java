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
                    //brackets pair -> pop from stk
                if( (stk.peek() == '[' && ch == ']') || (stk.peek() == '{' && ch == '}') || (stk.peek() == '(' && ch == ')')) {
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
        System.out.println(isValidParentheses(str3));
    }
}