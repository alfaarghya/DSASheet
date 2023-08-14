import java.util.Stack;

public class Stack02_ReverseString {
    public static void reverseString(String str) {  //TC -> O(n) || Sc -> O(n)
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            stk.push(str.charAt(i));
        }

        while(!stk.isEmpty()) {
            System.out.print(stk.pop());
        }

    }
    public static void main(String[] args) {
        String str = "ayhgrAafla";

        reverseString(str);
    }
}
