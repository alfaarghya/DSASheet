
class QueueWithArray{
    static int[] arr;   //array for the queue
    static int size;    //size of the array
    static int rear;    //index to track where is the last element

    QueueWithArray(int sizeOfQueue){  //constructor
        arr = new int[sizeOfQueue];   //declaring array size
        size = sizeOfQueue;
        rear = -1;
    }

        /*---- checking array is empty or not ----*/
    boolean isEmpty(){
        return rear == -1;
    }
                    /*--------*/

        /*---- Add a element to Queue ----*/
    void add(int data){ // TC -> O(1)
        if (rear == size-1){
            System.out.println("Alert! >>> Queue is full.... can't add any value now");
            return;
        }
            //add a value in array with rear index
        rear++;
        arr[rear] = data;
    }
                /*---- ----*/

        /*---- Remove a element from Queue ----*/
    int remove(){ // TC -> O(n)
        if(isEmpty()){
            System.out.println("Alert! >>> Queue is empty");
            return -1;
        }
            //step 1 -> store first value in front
        int front = arr[0]; //always delete 0th index or the first element
            //step 2 -> delete the first element
        for(int i = 0; i < rear; i++){
            arr[i] = arr[i+1];  //re-initialize i+1th element to i index
        }
            //step 3 -> decrease the rear by 1.....to track current index where is last element
        rear--;
        return front;
    }
                    /*---- ----*/

        /*---- Peek to see which element in front ----*/
    int peek(){
        if(isEmpty()){
            System.out.println("Alert! >>> Queue is empty");
            return -1;
        }
            //step -> simply return first element
        return arr[0];
    }
                        /*---- ----*/
}

public class DS05_Queue {
    public static void main(String[] args) {
        QueueWithArray qa = new QueueWithArray(10);
        qa.add(1);
        qa.add(2);
        qa.add(3);

        // qa.remove();
        // qa.remove();
        System.out.println("----Print----");
        while(!qa.isEmpty()){
            System.out.println(qa.peek());
            qa.remove();
        }
    }
}
