import java.util.HashSet;

public class Implement_HashSet {
    public static void main(String[] args) {
        /*
         * HashSet Implement using HashMap
         * null value allowed
         */
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(6);
        hs.add(5);
        hs.add(5);
        hs.add(1);
        hs.add(3);

        System.out.println(hs);

        System.out.println(hs.contains(10));
        System.out.println(hs.contains(6));

        hs.remove(1);

        System.out.println(hs);
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());
    }
}
