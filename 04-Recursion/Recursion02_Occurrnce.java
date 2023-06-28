/*
WAF to find the first occurence of an element in an array
 */

public class Recursion02_Occurrnce {

    public static int firstOccurence(int[]arr, int key, int i) {
            //base case
        if(i == arr.length) {   //when there is no element such as key
            return -1;
        }
        if(arr[i] == key) { //when we found key
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }
    public static int lastOccurence(int[]arr, int key, int n) {
            //base case
        if(n == -1) {   //when there is no element such as key
            return -1;
        }
        if(arr[n] == key) { //when we found key
            return n;
        }

        return lastOccurence(arr, key, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {4,4,4,5,5,5,5,5,4,4,4};
        int key = 5;
        System.out.println(firstOccurence(arr, key, 0));
        System.out.println(lastOccurence(arr, key, arr.length-1));
    }
}
