import java.util.Scanner;
class BubbleSort{
    int[] arr;

        /*----- constructors ----*/
    BubbleSort(int[] data){ //passing the data at the time of creating a object
        this.arr = data;
    }

    BubbleSort(){   //when.....we don't have the data to pass.....we want to pass the data at run time
        inputData();
    }
            /*---- ----*/

            /*---- Ascending Order Sorting(only this part is required to understand Bubble Sort) ----*/
    public void bubbleSortAscendingOrder(){ //TC -> O(n^2)
        int n = arr.length;
        for(int i = 0; i < n-1; i++){   //run a loop >> 0 to 2nd last element
            int swap = 0;   //it tracks how many swapping done
            for(int j = 0; j < n-1-i; j++){ //run a loop >> 0 to n-1-i 
                if(arr[j] > arr[j+1]){  //when current element[j] is greater than it's next element[j+1] push that after the element[j+1]......it means if we have 4,3,2,1 >> we need to push 4 after 3
                    //-- swapping --//
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                        //-- --//
                    swap++; //to track the number of swaps
                    if(swap == 0){  //it means our array is already sorted..... so break the loop
                        break;
                    }
                }

            }
        }
    }
                        /*---- ----*/

            /*---- Descending Order Sorting ----*/
    public void bubbleSortDescendingOrder(){    //TC -> O(n^2)
        int n = arr.length;
        for(int i = 0; i < n-1; i++){   //run a loop >> 0 to 2nd last element
            int swap = 0;   //it tracks how many swapping done
            for(int j = 0; j < n-1-i; j++){ //run a loop >> 0 to n-1-i 
                if(arr[j] < arr[j+1]){  //when current element[j] is less than it's next element[j+1] push that after the element[j+1]......it means if we have 1,2,3,4 >> we need to push 1 after 2
                    //-- swapping --//
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                        //-- --//
                    swap++; //to track the number of swaps
                    if(swap == 0){  //it means our array is already sorted..... so break the loop
                        break;
                    }
                }

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

public class SA01_BubbleSort{
    public static void main(String[] args) {
        
        System.out.println("--------------------------------------");
        int[] data = {5,4,1,3,2};
        BubbleSort bs = new BubbleSort(data);   //use this when u have pre-defined dataset
        System.out.print("Original array >> ");
        bs.printArray();
        bs.bubbleSortAscendingOrder();
        System.out.print("Sorted array(ascending)>> ");
        bs.printArray();
        bs.bubbleSortDescendingOrder();
        System.out.print("Sorted array(descending)>> ");
        bs.printArray();
        System.out.println("--------------------------------------");
        
        /*System.out.println("--------------------------------------");
        BubbleSort bs1 = new BubbleSort();  //use this when u want to give the data at run time
        System.out.print("Original array >> ");
        bs1.printArray();
        bs1.bubbleSortAscendingOrder();
        System.out.print("Sorted array(ascending)>> ");
        bs1.printArray();
        bs1.bubbleSortDescendingOrder();
        System.out.print("Sorted array(descending)>> ");
        bs1.printArray();
        System.out.println("--------------------------------------");*/

    }
}
