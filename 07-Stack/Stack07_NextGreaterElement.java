import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack07_NextGreaterElement {

    public static List<Integer> nextGreaterElement(int[] arr) { //TC -> O(n)
        List<Integer> nextGreater = new ArrayList<Integer>();
        Stack<Integer> stk = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--) { 

                //pop out from stack until found greater value then arr[i]
            while(!stk.isEmpty() && stk.peek() <= arr[i]) {
                stk.pop();
            }

                //stack is empty -> there are no greater value than arr[i]
            if(stk.isEmpty()) {
                nextGreater.add(0, -1);
            } else {    //found greater value at top of peek
                nextGreater.add(0, stk.peek());
            }
                //push current arr[i] into stack
            stk.push(arr[i]);
        }

        return nextGreater;

    }

    public static void main(String[] args) {
        int[] arr1 = {7,8,0,4,3,2};
        int[] arr2 = {0,5,1,4,3,2,6,7,1};
        int[] arr3 = {1,2,3,4,3};

        // System.out.println(nextGreaterElement(arr3));
        System.out.println(9%5);
    }
}
