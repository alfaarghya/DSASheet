import java.util.TreeMap;

public class Implement_TreeMap {
    public static void main(String[] args) {
        /*
         * To implement it we use Red Black Tree
         * it will sort itself according to key
         * that's why put(),remove(),get() all are in O(log n) Time Complexity
         */
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("IND", 130);
        tm.put("CHINA", 120);
        tm.put("US", 100);
        tm.put("PAK", 30);
        System.out.println(tm);
    }
}
