import java.util.LinkedHashMap;

public class Implement_LinkedHashMap {
    public static void main(String[] args) {
        /*
         * to implement it we use Array of DoublyLinkedList
         * it will maintain order as we insert values into it unlike HashMap which
         * change the order
         */
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("IND", 130);
        lhm.put("CHINA", 120);
        lhm.put("US", 100);
        lhm.put("PAK", 30);
        System.out.println(lhm);

    }
}
