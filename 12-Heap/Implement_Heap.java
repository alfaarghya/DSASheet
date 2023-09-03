import java.util.ArrayList;

/*-------- MinHeap - smaller the value higher the priority --------*/
class MinHeap {
    ArrayList<Integer> arr = new ArrayList<>();

        /*---- calling function ----*/
    public void add(int data) {
        insert(data);
    }

    public void peek() {
        System.out.println("Peek >> " + peekInto());
    }
    public void show() {
        System.out.println("MinHeap >> "+arr);
    }
            /*---- ----*/

    /*------ Working function ------*/

    /*---- Insert a value ----*/
    private void insert(int data){  //TC -> O(log(n)) || SC -> O(1)
            //step1 -> insert the value at the end of array list
        arr.add(data);

            //step2 -> fix the heap
        int childIdx = arr.size() - 1;
        int parentIdx = (childIdx - 1) / 2;

        while(arr.get(childIdx) < arr.get(parentIdx)) {
                //swapping
            int swapVar = arr.get(childIdx);
            arr.set(childIdx, arr.get(parentIdx));
            arr.set(parentIdx, swapVar);

                //change index values
            childIdx = parentIdx;
            parentIdx = (childIdx - 1) / 2;
        }
    }
        /*---- ----*/
        /*--- Peek on Heap- ----*/
    private int peekInto() {    //TC -> O(1) || SC -> O(1)
        return arr.get(0);
    }
        /*---- ----*/

        /*------ ------*/
    
}
/*-------- --------*/

/*-------- MaxHeap - greater the value higher the priority --------*/
class MaxHeap {
    ArrayList<Integer> arr = new ArrayList<>();

        /*---- calling function ----*/
    public void add(int data) {
        insert(data);
    }

    public void peek() {
        System.out.println("Peek >> " + peekInto());
    }
    public void show() {
        System.out.println("MaxHeap >> "+arr);
    }
            /*---- ----*/

    /*------ Working function ------*/

    /*---- Insert a value ----*/
    private void insert(int data){  //TC -> O(log(n)) || SC -> O(1)
            //step1 -> insert the value at the end of array list
        arr.add(data);

            //step2 -> fix the heap
        int childIdx = arr.size() - 1;
        int parentIdx = (childIdx - 1) / 2;

        while(arr.get(childIdx) > arr.get(parentIdx)) {
                //swapping
            int swapVar = arr.get(childIdx);
            arr.set(childIdx, arr.get(parentIdx));
            arr.set(parentIdx, swapVar);

                //change index values
            childIdx = parentIdx;
            parentIdx = (childIdx - 1) / 2;
        }
    }
        /*---- ----*/
    /*--- Peek on Heap- ----*/
    private int peekInto() {    //TC -> O(1) || SC -> O(1)
        return arr.get(0);
    }
        /*---- ----*/

        /*------ ------*/
    
}
/*-------- --------*/

public class Implement_Heap {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap();
        mh.add(5);
        mh.add(6);
        mh.add(7);
        mh.add(8);
        mh.add(1);

        mh.show();  
    /*      1
           / \
          5   7
         / \
        8   6      
    */    
        
    mh.peek();

    // --------------------------------------------
        System.out.println("---------- ---------");
    // --------------------------------------------

    MaxHeap maxH = new MaxHeap();
    maxH.add(5);
    maxH.add(6);
    maxH.add(7);
    maxH.add(8);
    maxH.add(1);

    maxH.show();
    /*      8
           / \
          7   6
         / \
        5   1      
    */  
    maxH.peek();

    }
}
