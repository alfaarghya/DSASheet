import java.util.Scanner;
class InsertionSort {
    int arr[];
        /*---- Constructor ----*/
    InsertionSort(int[] arr){
        this.arr = arr;
    }

    InsertionSort(){
        inputData();
    }
            /*---- ----*/

        /*---- Ascending Order Sorting(only this part is required to understand Selection Sort) ----*/
    public void InsertionSortAscendingOrder(){  //TC -> O(n^2)
        int n = arr.length;
        for(int i = 1; i < n; i++){   //-> O(n^2)
            int Current = arr[i];
            int PreviousIndex = i-1;
            while(PreviousIndex >= 0 && arr[PreviousIndex] > Current){
                arr[PreviousIndex + 1] = arr[PreviousIndex];
                PreviousIndex--;
            }
            arr[PreviousIndex+1] = Current;
        }
    }
                        /*---- ----*/

        /*---- Descending Order Sorting ----*/
    public void InsertionSortDescendingOrder(){  //TC -> O(n^2)
        int n = arr.length;
        for(int i = 1; i < n; i++){   //-> O(n^2)
            int Current = arr[i];
            int PreviousIndex = i-1;
            while(PreviousIndex >= 0 && arr[PreviousIndex] < Current){
                arr[PreviousIndex + 1] = arr[PreviousIndex];
                PreviousIndex--;
            }
            arr[PreviousIndex+1] = Current;
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


public class SA03_InsertionSort {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        int[] data  = {5,4,1,3,2};
        InsertionSort is = new InsertionSort(data); //use this when u have the data
        System.out.print("Original Array >> ");
        is.printArray();
        is.InsertionSortAscendingOrder();
        System.out.print("Sorted Array(Ascending Order) >>");
        is.printArray();
        is.InsertionSortDescendingOrder();
        System.out.print("Sorted Array(Descending Order) >>");
        is.printArray();
        System.out.println("---------------------------------------");

        /*System.out.println("---------------------------------------");
        InsertionSort is1 = new InsertionSort(); //use this when u want to input data at runtime 
        System.out.print("Original Array >> ");
        is1.printArray();
        is1.InsertionSortAscendingOrder();
        System.out.print("Sorted Array(Ascending Order) >> ");
        is1.printArray();
        is1.InsertionSortDescendingOrder();
        System.out.print("Sorted Array(Descending Order) >> ");
        is1.printArray();
        System.out.println("---------------------------------------");*/
    }
}
