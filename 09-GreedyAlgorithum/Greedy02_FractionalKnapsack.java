import java.util.Arrays;
import java.util.Comparator;

public class Greedy02_FractionalKnapsack {

    public static double storeMaxValue(int[] weight, int[] value, int W) { //TC -> O(n*log(n))
        double[][] data = new double[value.length][3];

            //store all data to sort
        for(int i = 0; i < value.length; i++) {
            data[i][0] = value[i]/(double)weight[i];
            data[i][1] = value[i];
            data[i][2] = weight[i];
        }

                //sort the data according to ratio
        Arrays.sort(data, Comparator.comparingDouble(o -> o[0]));

        int maxValue = 0, capacity = W;
        for(int i = data.length-1; i >= 0; i--) {
            if(capacity >= data[i][2]) {    //when capacity is greater or equal to current weight
                maxValue += data[i][1];// add the value
                capacity -= data[i][2]; //decrease the capacity
            } else {   //when need to take a fraction part of element to full fill the capacity
                maxValue += data[i][0] * capacity;  //ratio * capacity
                capacity = 0;
            }
        }

        return maxValue;

    }

    public static void main(String[] args) {
        int[] weight = {10,20,30};
        int[] value = {60,100,120};
        int W = 50;

        System.out.println(storeMaxValue(weight, value, W));
    }
}
