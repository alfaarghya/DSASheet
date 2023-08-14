import java.util.ArrayList;
import java.util.Stack;

public class Stack04_StockSpanProblem {

    public static ArrayList<Integer> calculateSpan(int[] stock) {
        ArrayList<Integer> span = new ArrayList<>();    //ans
        Stack<Integer> stk = new Stack<>(); //extra space

        //span's 1st element must be 1
        span.add(1);
        stk.push(0);

        for(int i = 1; i < stock.length; i++) {
            int currentPrice = stock[i];
                //try to find if there are any previous stock price is greater than current stock price
            while (!stk.isEmpty() && currentPrice > stock[stk.peek()]) {
                stk.pop();  //if it is not remove it from stack
            }

            if(stk.isEmpty()) { //if stack is completely empty that's mean our current stock is the largest one 
                span.add(i+1);
            } else {
                span.add(i-stk.peek()); //formula for every span
            }

            stk.push(i);    //at the last push current stock
        }

        return span;
    }

    public static void main(String[] args) {
         int[] stock = {100,80,60,100,60,85,100};
        System.out.println(calculateSpan(stock));
    }
}