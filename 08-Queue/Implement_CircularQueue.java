
class CircularQueue {
    static int[] arr;
    static int front;
    static int rear;
    static int size;
    CircularQueue(int sizeOfQueue) {
        size = sizeOfQueue;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    /*---- isEmpty? ----*/
    boolean isEmpty() { //TC -> O(1)
        return rear == -1 && front == -1;
    }
        /*---- ----*/
    /*---- isFull? ----*/
    boolean isFull() {
        return (rear+1) % size == front;
    }
        /*---- ----*/

    /*---- add a data in Queue ----*/
    void add(int data) {    //TC -> O(1)
        if(isFull()) {
            System.out.println("Alert! >>> Queue is full.... can't add any value now");
            return;
        }

            //adding 1st element
        if(front == -1) {
            front = 0;
        }
            //adding data in circular queue
        rear = (rear+1) % size;
        arr[rear] = data;

    }
            /*---- ----*/
    /*---- remove a data from queue ----*/
    int remove() {  //TC -> O(1)
        if(isEmpty()) {
            System.out.println("Alert! >>> Queue is empty");
            return -1;
        }

        int remove = arr[front];
        if(front == rear) { //deleting last element
            front = rear = -1;
        } else {
            front = (front+1) % size;
        }

        return remove;

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
public class Implement_CircularQueue {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        cq.add(5);

        cq.remove();
        cq.remove();
        cq.remove();

        cq.add(6);
        cq.add(7);
        cq.add(8);
        cq.add(8);
        while(!cq.isEmpty()) {
            System.out.print(cq.remove());
        }
    }
}
