import java.util.Arrays;
import java.util.Comparator;

public class GA02_FractionalKnapsack {

    public static int maximumValue(int[] value, int[] weight, int W){
        int maxValue = 0, capacity = W;
        double[][] store = new double[value.length][3];
        
        for(int i = 0; i < store.length; i++){
            store[i][0] = value[i]/(double)weight[i];   // ratio = value/weight >> stores in column 0
            store[i][1] = value[i]; //values stores in column 1
            store[i][2] = weight[i];    //weights store in column 2
        }

            //step 1 -> sort array according to the ratio
        Arrays.sort(store, Comparator.comparingDouble(o -> o[0])); //this will sort  in ascending order
            //always we have to take big ratio value >> for that reason always
        for(int i = store.length-1; i >= 0; i--){
                //step 2 -> when we have capacity to store element
            if(capacity >= store[i][2]){
                maxValue += store[i][1];    //add their value
                capacity -= store[i][2];    //track the capacity
            }
                //step 3 -> when we need to take a fraction part of element to full fill the capacity
            else{
                maxValue += store[i][0] * capacity; // value of fractional part
                capacity = 0;   //now capacity is full
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        System.out.println(maximumValue(value, weight, W));
    }
}
