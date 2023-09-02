import java.util.Comparator;
import java.util.PriorityQueue;
public class Implement_PriorityQueue {

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

        pq.add(10);
        pq.add(1);
        pq.add(0);
        pq.add(5);

        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

        System.out.println("---------------------------------");
        
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        
        pq1.add(10);
        pq1.add(1);
        pq1.add(0);
        pq1.add(5);
        
        while(!pq1.isEmpty()) {
            System.out.println(pq1.remove());
        }
        
        System.out.println("---------------------------------");

        PriorityQueue<Student> sPQ = new PriorityQueue<>();
        sPQ.add(new Student("a", 100));
        sPQ.add(new Student("b", 1));
        sPQ.add(new Student("c", 55));
        sPQ.add(new Student("d", 12));

        while(!sPQ.isEmpty()){
            System.out.println(sPQ.peek().name+"->"+sPQ.peek().rank);
            sPQ.remove();
        }
    }
}
