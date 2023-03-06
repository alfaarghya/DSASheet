import java.util.Arrays;
import java.util.Comparator;

public class GA04_MaxLenChainPair {

    public static int maxLength(int[][] pairs){
            //step 1 -> sort the array based on second value of the pair
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
            //step 2 -> always select first pair
        int count = 1, select = pairs[0][1];

        for(int i = 1; i < pairs.length; i++){
                //step 3 -> when current first value of pair is greater than last pair's second value
            if(pairs[i][0] > select){
                count++;
                select = pairs[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = {{5,24},{39,60},{5,28},{27,40},{50,90}};

        System.out.println("maximum length of chain >> "+maxLength(pairs));
    }
}
