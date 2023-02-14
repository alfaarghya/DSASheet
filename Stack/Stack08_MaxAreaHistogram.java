/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,return largest rectangle in histogram.
 */
import java.util.Stack;
public class Stack08_MaxAreaHistogram {

        //left side first smaller value --> to understand this logic first check Stack05_NextGreater
    public static void nextSmallerLeft(int mainArr[], int newArr[], Stack<Integer> stk){
        for(int i = 0; i < mainArr.length; i++){
            while(!stk.isEmpty() && mainArr[stk.peek()] >= mainArr[i]){
                stk.pop();
            }

            if(stk.isEmpty()){
                newArr[i] = -1;
            }
            else{
                newArr[i] = stk.peek();
            }
            stk.push(i);
        }
    }

        //right side first smaller value --> to understand this logic first check Stack05_NextGreater
    public static void nextSmallerRight(int mainArr[], int newArr[], Stack<Integer> stk){
        int n = mainArr.length;
        for(int i = n-1; i >= 0; i--){
            while(!stk.isEmpty() && mainArr[stk.peek()] >= mainArr[i]){
                stk.pop();
            }

            if(stk.isEmpty()){
                newArr[i] = n;
            }
            else{
                newArr[i] = stk.peek();
            }
            stk.push(i);
        }
    }

    public static int maxAreaHistogram(int height[]){   //TC -> O(n)
        int maxArea = Integer.MIN_VALUE;
        int[] nsl = new int[height.length]; //stores bottom bound of width for ever height
        int[] nsr = new int[height.length]; //stores upper bound of width for ever height

        Stack<Integer> stk = new Stack<>();
        nextSmallerLeft(height, nsl, stk);  // --> this provides bottom bound for width
        stk = new Stack<>();
        nextSmallerRight(height, nsr, stk); // --> this provides upper bound for width

        for(int i = 0; i < height.length; i++){
            int currentArea = height[i] * (nsr[i] - nsl[i] - 1);    // area = height * width
            if(currentArea > maxArea){  //check greater
                maxArea = currentArea;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height1 = {2,1,5,6,2,3};
        int[] height2 = {1,6,3,4,1,5,4,6};
        int[] height3 = {100,50,10,80,40,60,20};

        System.out.println("Maximum area for Histogram --> "+maxAreaHistogram(height3));
    }
}
