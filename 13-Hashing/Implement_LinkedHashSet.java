import java.util.LinkedHashSet;

public class Implement_LinkedHashSet {
    public static void main(String[] args) {
        /*
         * It maintain the order of key and it is implemented by LinedHashMap
         * null value allowed
         */
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();

        lhs.add('c');
        lhs.add('x');
        lhs.add('c');
        lhs.add('W');
        lhs.add('b');
        lhs.add('A');
        lhs.add('a');

        System.out.println(lhs);

    }
}
