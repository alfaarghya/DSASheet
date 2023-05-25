import java.util.Scanner;
class CountingSort {
    int arr[];
        /*---- Constructor ----*/
    CountingSort(int[] arr){
        this.arr = arr;
    }

    CountingSort(){
        inputData();
    }

            /*---- Ascending Order Sorting(only this part is required to understand Selection Sort) ----*/
    public void CountingSortAscendingOrder(){  //TC -> O(n + range)
        int large = Integer.MIN_VALUE;
            //step1 -> find out largest value in array
        for(int i = 0; i < arr.length; i++) {
            large = Math.max(large, arr[i]);
        }
            //step2 -> counting each numbers frequency
        int[] count = new int[large+1];
        for(int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

            //step3 -> change the original array according to the frequency
        int index = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }

    }
                        /*---- ----*/

        /*---- Descending Order Sorting ----*/
    public void CountingSortDescendingOrder(){  //TC -> O(n + range)
        int large = Integer.MIN_VALUE;
            //step1 -> find out largest value in array
        for(int i = 0; i < arr.length; i++) {
            large = Math.max(large, arr[i]);
        }
            //step2 -> counting each numbers frequency
        int[] count = new int[large+1];
        for(int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

            //step3 -> change the original array according to the frequency
        int index = 0;
        for(int i = count.length-1; i >= 0; i--) {
            while(count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }

    }
                        /*---- ----*/


            /*---- Print the Array ----*/
    public void printArray(){   //TC -> O(n)
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
                /*---- ----*/

    /*---- take input from user ----*/
    private void inputData(){   //we are using this method at constructor
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of your array >> ");
        int n = scn.nextInt();
        arr = new int[n]; //give the size of arr array(object)

        System.out.println("-------- Enter "+n+" Data --------");
        for(int i = 0; i < n; i++){
            System.out.print("\tarr["+i+"] = ");
            arr[i] = scn.nextInt(); //here we take the input from user
        }
        System.out.println("\t----- -----");
        scn.close();
    }
            /*---- ----*/

}

public class SA04_CountingSort {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        int[] data = {1,4,1,3,2,4,3,7};
        // int[] data  = {5,4,1,3,2};
        CountingSort cs = new CountingSort(data); //use this when u have the data
        System.out.print("Original Array >> ");
        cs.printArray();
        cs.CountingSortAscendingOrder();
        System.out.print("Sorted Array(Ascending Order) >>");
        cs.printArray();
        cs.CountingSortDescendingOrder();
        System.out.print("Sorted Array(Descending Order) >>");
        cs.printArray();
        System.out.println("---------------------------------------");

        /*System.out.println("---------------------------------------");
        CountingSort cs = new CountingSort(); //use this when u want to input data at runtime 
        System.out.print("Original Array >> ");
        cs.printArray();
        cs.CountingSortAscendingOrder();
        System.out.print("Sorted Array(Ascending Order) >>");
        cs.printArray();
        cs.CountingSortDescendingOrder();
        System.out.print("Sorted Array(Descending Order) >>");
        cs.printArray();
        System.out.println("---------------------------------------");*/

    }
}
