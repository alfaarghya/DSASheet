import java.util.Stack;

public class Stack05_NextGreater{

    public static void nextGreater(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int sizeOfArr = arr.length;
        int[] nextGreaterElement = new int[sizeOfArr];

        for(int i = sizeOfArr-1; i >= 0; i--){

            while(!stk.isEmpty() && arr[stk.peek()] <= arr[i]){  //loop will stop when either stack is empty or top of stack is greater than array[i]
                stk.pop();
            }

            if(stk.isEmpty()){
                nextGreaterElement[i] = -1; //when stack is empty
            }
            else{
                nextGreaterElement[i] = arr[stk.peek()]; //when greater element is there
            }

            stk.push(i);   //push the current index to the stack for next check

        }
        printArray(nextGreaterElement); //print the array
    }
    
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {7,8,0,4,3,2};
        int[] arr2 = {6,8,1,2,3,8};
        int[] arr3 = {6,8,0,1,3};
        nextGreater(arr2);
    }
}