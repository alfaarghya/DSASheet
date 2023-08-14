import java.util.Stack;

public class Stack08_MaxAreaHistogram {

    public static int maxArea(int[] height) {   //TC -> O(n) || SC -> O(n)
        int[] nsl = nextSmallerLeft(height, new Stack<>());
        // print(nsl);
        int[] nsr = nextSmallerRight(height, new Stack<>());
        // print(nsr);

        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < height.length; i++) {
            int currentArea = height[i] * (nsr[i] - nsl[i] - 1);  // ---> area = height * width
            maxArea = Math.max(maxArea, currentArea); // ---> getting max-area
        }

        return maxArea;

    }

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int[] nextSmallerLeft(int[] arr, Stack<Integer> stk) {
        int[] nsl = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }

            if(stk.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stk.peek();
            }

            stk.push(i);
        }

        return nsl;
    }

    public static int[] nextSmallerRight(int[] arr, Stack<Integer> stk) {
        int[] nsr = new int[arr.length];

        for(int i = arr.length-1; i >= 0; i--) {
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }

            if(stk.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = stk.peek();
            }

            stk.push(i);
        }

        return nsr;
    }

    public static void main(String[] args) {
        int[] height1 = {2,1,5,6,2,3};
        int[] height2 = {1,6,3,4,1,5,4,6};
        int[] height3 = {100,50,10,80,40,60,20};
        System.out.println(maxArea(height3));
    }
}
