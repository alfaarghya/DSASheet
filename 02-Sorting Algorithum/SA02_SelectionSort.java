import java.util.Scanner;
class SelectionSort {
    int arr[];
        /*---- Constructor ----*/
    SelectionSort(int[] arr){
        this.arr = arr;
    }

    SelectionSort(){
        inputData();
    }
            /*---- ----*/

        /*---- Ascending Order Sorting(only this part is required to understand Selection Sort) ----*/
    public void SelectionSortAscendingOrder(){  //TC -> O(n^2)
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int minPosition = i;    //store current i-th element index
            for(int j = i+1; j < n; j++){
                if(arr[minPosition] > arr[j]){  //when current[minPosition] value is greater than it's next values store less value's Index in minPosition
                    minPosition = j;
                }
            }
                //then swap the current i-th element with minPosition
            int temp = arr[minPosition];
            arr[minPosition] = arr[i];
            arr[i] = temp;
        }
    }
                        /*---- ----*/

        /*---- Descending Order Sorting ----*/
    public void SelectionSortDescendingOrder(){  //TC -> O(n^2)
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int minPosition = i;    //store current i-th element index
            for(int j = i+1; j < n; j++){
                if(arr[minPosition] < arr[j]){  //when current[minPosition] value is less than it's next values store greater value's Index in minPosition
                    minPosition = j;
                }
            }
                //then swap the current i-th element with minPosition
            int temp = arr[minPosition];
            arr[minPosition] = arr[i];
            arr[i] = temp;
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

public class SA02_SelectionSort {
    public static void main(String[] args) {
        
        System.out.println("---------------------------------------");
        int[] data  = {9,2,6,1,8,5,4,3,2,1};
        SelectionSort ss = new SelectionSort(data); //use this when u have the data
        System.out.print("Original Array >> ");
        ss.printArray();
        ss.SelectionSortAscendingOrder();
        System.out.print("Sorted Array(Ascending Order) >>");
        ss.printArray();
        ss.SelectionSortDescendingOrder();
        System.out.print("Sorted Array(Descending Order) >>");
        ss.printArray();
        System.out.println("---------------------------------------");

        /*System.out.println("---------------------------------------");
        SelectionSort ss1 = new SelectionSort(); //use this when u want to input data at runtime 
        System.out.print("Original Array >> ");
        ss1.printArray();
        ss1.SelectionSortAscendingOrder();
        System.out.print("Sorted Array(Ascending Order) >> ");
        ss1.printArray();
        ss1.SelectionSortDescendingOrder();
        System.out.print("Sorted Array(Descending Order) >> ");
        ss1.printArray();
        System.out.println("---------------------------------------");*/
        
    }
}
