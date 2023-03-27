import java.util.Comparator;
import java.util.PriorityQueue;
public class DS08_PriorityQueue {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(6);  //TC -> O(log(n))
        pq.add(1);
        pq.add(4);
        pq.add(2);
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");    //TC -> O(1)
            pq.remove();    //TC -> O(log(n))
        }
            PriorityQueue<Student> sPQ = new PriorityQueue<>();
            sPQ.add(new Student("a", 100));
            sPQ.add(new Student("b", 1));
            sPQ.add(new Student("c", 55));
            sPQ.add(new Student("d", 12));

            while(!sPQ.isEmpty()){
                System.out.println(sPQ.peek().name+"->"+sPQ.peek().rank);
                sPQ.remove();
            }

            PriorityQueue<Student> spq = new PriorityQueue<>(Comparator.reverseOrder());
            spq.add(new Student("a", 100));
            spq.add(new Student("b", 1));
            spq.add(new Student("c", 55));
            spq.add(new Student("d", 12));

            while(!spq.isEmpty()){
                System.out.println(spq.peek().name+"->"+spq.peek().rank);
                spq.remove();
            }

    }
}
