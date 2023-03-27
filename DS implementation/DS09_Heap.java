import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> arr = new ArrayList<>();

    /*---- Insert a data in min heap ----*/
    public void add(int data) { //TC -> O(log(n))
        arr.add(data);  //adding data into heap

            //collecting child and parent 
        int childIndex = arr.size()-1;
        int parentIndex = (childIndex-1)/2;

            //now compare -> is child smaller than parent
        while(arr.get(childIndex) < arr.get(parentIndex)) {
                //if condition is true then -> swap child and parent
            int temp = arr.get(childIndex);
            arr.set(childIndex, arr.get(parentIndex));
            arr.set(parentIndex, temp);

                //re-assign child and parent index for another check
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }

    }
            /*---- ----*/

        /*---- peek into heap----*/
    public int peek() { //TC -> O(1)
        return arr.get(0);
    }
            /*---- ----*/

        /*---- remove a first data from min heap ----*/
    public int remove(){//TC -> O(log(n))
            //swap between 1st and last data
        int temp = arr.get(0);
        arr.set(0, arr.get(arr.size()-1));
        arr.set(arr.size()-1, temp);

            //remove last idex data
        arr.remove(arr.size()-1);

            //now change position of value....if it is not follows it's property
        heapify(0);

        return temp;
    }
    private void heapify(int i) {
            //find out both child index
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int minIndex = i;
        
            //if one of child is smaller than parent catch the index
        if(leftChild < arr.size() && arr.get(minIndex)>arr.get(leftChild)){
            minIndex = leftChild;
        }
        if(rightChild < arr.size() && arr.get(minIndex)>arr.get(rightChild)){
            minIndex = rightChild;
        }

            //if min index is not the root index
        if(minIndex != i){
                //then.....swap
            int temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);

                //now again call heapify.... to check all values are in right position or note
            heapify(minIndex);
        }

    }
                    /*---- ----*/

    public void print() {
        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }

}

class MaxHeap { 
    ArrayList<Integer> arr = new ArrayList<>();

    /*---- Insert a data in max heap ----*/
    public void add(int data) { //TC -> O(log(n))
        arr.add(data);  //adding data into heap

            //collecting child and parent 
        int childIndex = arr.size()-1;
        int parentIndex = (childIndex-1)/2;

            //now compare -> is child greater than parent
        while(arr.get(childIndex) > arr.get(parentIndex)) {
                //if condition is true then -> swap child and parent
            int temp = arr.get(childIndex);
            arr.set(childIndex, arr.get(parentIndex));
            arr.set(parentIndex, temp);

                //re-assign child and parent index for another check
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }

    }
            /*---- ----*/

        /*---- peek into heap----*/
    public int peek() { //TC -> O(1)
        return arr.get(0);
    }
            /*---- ----*/

        /*---- remove a first data from max heap ----*/
    public int remove(){    //TC -> O(log(n))
            //swap between 1st and last data
        int temp = arr.get(0);
        arr.set(0, arr.get(arr.size()-1));
        arr.set(arr.size()-1, temp);

            //remove last idex data
        arr.remove(arr.size()-1);

            //now change position of value....if it is not follows it's property
        heapify(0);

        return temp;
    }
    private void heapify(int i) {
            //find out both child index
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int minIndex = i;
        
            //if one of child is smaller than parent catch the index
        if(leftChild < arr.size() && arr.get(minIndex)<arr.get(leftChild)){
            minIndex = leftChild;
        }
        if(rightChild < arr.size() && arr.get(minIndex)<arr.get(rightChild)){
            minIndex = rightChild;
        }

            //if min index is not the root index
        if(minIndex != i){
                //then.....swap
            int temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);

                //now again call heapify.... to check all values are in right position or note
            heapify(minIndex);
        }

    }
                    /*---- ----*/

    public void print() { 
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

}

public class DS09_Heap {

    public static void main(String[] args) {
        MinHeap minH = new MinHeap();
        minH.add(4);
        minH.add(8);
        minH.add(10);
        minH.add(3);
        minH.add(5);
        minH.add(1);

        minH.print();
        minH.remove();
        minH.print();
        System.out.println("---------------------------------");
        
        MaxHeap maxH = new MaxHeap();
        maxH.add(5);
        maxH.add(6);
        maxH.add(3);
        maxH.add(2);
        maxH.add(4);
        maxH.add(1);
        maxH.add(10);
        
        maxH.print();
        maxH.remove();
        maxH.print();
        System.out.println("---------------------------------");

    }
}
