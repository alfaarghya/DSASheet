import java.util.Queue;
import java.util.LinkedList;

public class Queue04_InterleaveEvenLength {

    public static void Interleave(Queue<Integer> qOriginal){
        Queue<Integer> qNew = new LinkedList<>();
        int size = qOriginal.size();

            //step 1 -> move 1st half Queue data to a new Queue
        for(int i = 0; i < size/2; i++){
            qNew.add(qOriginal.remove());
        }

            //step 2 -> Interleave two halves
        while(!qNew.isEmpty()){
                //add front of new Queue to Original Queue
            qOriginal.add(qNew.remove());   
                //add front of Original Queue to Original Queue
            qOriginal.add(qOriginal.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        Interleave(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
