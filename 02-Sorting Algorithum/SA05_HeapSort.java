class HeapSort {
    int[] arr;
        /*---- Constructor ----*/
    public HeapSort(int[] minHeapData) {
        this.arr = minHeapData;
    }
            /*---- ----*/
            
            /*---- Sort minHeap in Ascending Order ----*/
    public void ascOrder() {    //TC -> O(n log(n))
        int n = arr.length;
            //step1 -> build a max heap
        for(int i = n/2; i >= 0; i--) {
            heapifyASC(arr, i, n);
        }

            //step2 -> push the largest element at last
        for(int i = n-1; i > 0; i--) {
                //swap between first and last
          int swapVar = arr[i];
          arr[i] = arr[0];
          arr[0] = swapVar;

            //fix the heap again
          heapifyASC(arr, 0, i);
        }
    }

    private void heapifyASC(int[] arr, int idx, int size) { //heapify for max-heap 
        int left = 2 * idx + 1; //left child 
        int right = 2 * idx + 2; //right child
        int maxIdx = idx;

            // search for maximum value to swap with current root
        if(left < size && arr[left] > arr[maxIdx]) maxIdx = left; 
        if(right < size && arr[right] > arr[maxIdx]) maxIdx = right; 

            //fix the heap
        if(maxIdx != idx) {
            int swapVar = arr[maxIdx];
            arr[maxIdx] = arr[idx];
            arr[idx] = swapVar;

            heapifyASC(arr, maxIdx, size);
        }
    }
                        /*---- ----*/
                        
            /*---- Sort minHeap in Descending Order ----*/
    public void descOrder() {    //TC -> O(n log(n))
        int n = arr.length;
            //step1 -> build a min heap
        // for(int i = n/2; i >= 0; i--) {
        //     heapifyDESC(arr, i, n);
        // }

            //step2 -> push the largest element at last
        for(int i = n-1; i > 0; i--) {
                //swap between first and last
          int swapVar = arr[i];
          arr[i] = arr[0];
          arr[0] = swapVar;

            //fix the heap again
          heapifyDESC(arr, 0, i);
        }
    }

    private void heapifyDESC(int[] arr, int idx, int size) {    //heapify for min-heap
        int left = 2 * idx + 1; //left child 
        int right = 2 * idx + 2; //right child
        int minIdx = idx;

            // search for minimum value to swap with current root
        if(left < size && arr[left] < arr[minIdx]) minIdx = left; 
        if(right < size && arr[right] < arr[minIdx]) minIdx = right; 

            //fix the heap
        if(minIdx != idx) {
            int swapVar = arr[minIdx];
            arr[minIdx] = arr[idx];
            arr[idx] = swapVar;

            heapifyDESC(arr, minIdx, size);
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

}

public class SA05_HeapSort {
    public static void main(String[] args) {
        int[] heapData = {1,5,3,10,11,8,7,20};
        HeapSort hs = new HeapSort(heapData);
        hs.printArray();
        hs.ascOrder();
        hs.printArray();
        hs.descOrder();
        hs.printArray();
    }
}
