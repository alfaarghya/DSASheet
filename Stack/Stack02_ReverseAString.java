//reverse a String using Stack

import java.util.Stack;

public class Stack02_ReverseAString {

    public static void reverseString(String str){
        Stack<Character> stk = new Stack<>();

        int i = 0;
        while(i < str.length()){
            stk.push(str.charAt(i));   //push all character into stack
            i++;
        }

        StringBuilder result = new StringBuilder("");
        while(!stk.isEmpty()){
            result.append(stk.pop());   //reverse the order using loop
        }

        str = result.toString();    //reassigned the value
        System.out.println(str);
    }
    public static void main(String[] args) {
        reverseString("Arghya Das"); //input
    }
}
