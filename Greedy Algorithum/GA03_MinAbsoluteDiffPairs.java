import java.util.Arrays;
public class GA03_MinAbsoluteDiffPairs {

    public static int minSum(int[] A, int[] B){
        //step 1 -> sort the arrays in ascending order
    Arrays.sort(A);
    Arrays.sort(B);

    int minDiffSum = 0;

    for(int i = 0; i < A.length; i++){
            //step 2 -> sum of absolute value(diff between A and B)
        minDiffSum += Math.abs(A[i]-B[i]);
    }

    return minDiffSum;
    }

    public static void main(String[] args) {
        int[] A = {4,1,8,7};
        int[] B = {2,3,6,5};

        System.out.println("Minimum sum >> "+minSum(A, B));
    }
}
