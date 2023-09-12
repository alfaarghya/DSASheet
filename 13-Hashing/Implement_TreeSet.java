
import java.util.TreeSet;

public class Implement_TreeSet {
    public static void main(String[] args) {
        /*
         * TreeSet Implement using TreeMap
         * Sorted in ascending order
         * Null value not allowed
         */
        TreeSet<Character> ts = new TreeSet<>();

        ts.add('c');
        ts.add('x');
        ts.add('c');
        ts.add('W');
        ts.add('b');
        ts.add('A');
        ts.add('a');

        System.out.println(ts);
    }
}
