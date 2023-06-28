/* is array in sorted manner? */

public class Recursion01_isArraySort {

    public static boolean isArrraySort(int[] arr, int i) {
            //base case
        if(i == arr.length-1) {
            return true;
        }
        if(arr[i] > arr[i+1]) {
            return false;
        }

        return isArrraySort(arr, i+1);  //recursive function
    }

    public static void main(String[] args) {
        int[] arr = {11,111,1111,11111,222222,111111};
        System.out.println(isArrraySort(arr, 0));
    }
}
