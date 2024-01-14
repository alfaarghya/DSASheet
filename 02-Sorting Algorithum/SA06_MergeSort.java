import java.util.ArrayList;
import java.util.Scanner;

class MergeSort {
    int[] arr;

    /*---- Constructor ----*/
    MergeSort(int[] arr) {
        this.arr = arr;
    }

    MergeSort() {
        inputData();
    }
    /*---- ----*/

    /*---- Ascending Order Sorting ----*/
    public void mergeSortAscendingOrder() {
        int startIdx = 0, endIdx = arr.length - 1;
        mergeSort(startIdx, endIdx);
    }

    public void mergeSort(int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        int midIdx = startIdx + (endIdx - startIdx) / 2;
        mergeSort(startIdx, midIdx);
        mergeSort(midIdx + 1, endIdx);
        merge(startIdx, midIdx, endIdx);
    }

    public void merge(int startIdx, int midIdx, int endIdx) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        // 2 pointers
        int left = startIdx;
        int right = midIdx + 1;

        // sorting
        while (left <= midIdx && right <= endIdx) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        // copy rest of the values
        while (left <= midIdx) {
            temp.add(arr[left++]);
        }
        while (right <= endIdx) {
            temp.add(arr[right++]);
        }

        for (int i = startIdx; i < endIdx; i++) {
            arr[i] = temp.get(i - startIdx);
        }

    }

    /*---- ----*/

    /*---- Print the Array ----*/
    public void printArray() { // TC -> O(n)
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    /*---- ----*/

    /*---- take input from user ----*/
    private void inputData() { // we are using this method at constructor
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of your array >> ");
        int n = scn.nextInt();
        arr = new int[n]; // give the size of arr array(object)

        System.out.println("-------- Enter " + n + " Data --------");
        for (int i = 0; i < n; i++) {
            System.out.print("\tarr[" + i + "] = ");
            arr[i] = scn.nextInt(); // here we take the input from user
        }
        System.out.println("\t----- -----");
        scn.close();
    }
    /*---- ----*/
}

public class SA06_MergeSort {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        int[] data = { 1, 4, 1, 3, 2, 4, 3, 7 };
        // int[] data = {5,4,1,3,2};
        MergeSort ms = new MergeSort(data); // use this when u have the data
        System.out.print("Original Array >> ");
        ms.printArray();
        ms.mergeSortAscendingOrder();
        System.out.print("Sorted Array(Ascending Order) >> ");
        ms.printArray();
    }
}
