import java.util.Stack;
public class Stack04_StockSpanProblem {

    public static void span(int[] stock, int[] span){
        Stack<Integer> stk = new Stack<>();
            //first element of span is always 1........because we have no value before that element
        span[0] = 1;
        stk.push(0);

        for(int i = 1; i < stock.length; i++){
            int currentPrice = stock[i];
            while(!stk.isEmpty() && currentPrice > stock[stk.peek()]){  //when current day price is lower than previous day value.....then stop the loop
                stk.pop();
            }
            if(stk.isEmpty()){  //before current price every element is lower than current price
                span[i] = i+1;
            }
            else{
                int prevHigh = stk.peek();
                span[i] = i - prevHigh;
            }
            stk.push(i);
        }
    }

    public static void main(String[] args) {
        int[] stock = {100, 80, 60, 70, 60, 85, 100};
        int[] span = new int[stock.length];

            //function call
        span(stock, span);

            //print the array
        for(int i = 0; i < span.length;i++){
            System.out.print(span[i]+" ");
        }
    }
}
