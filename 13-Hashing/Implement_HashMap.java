import java.util.HashMap;

public class Implement_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("IND", 140);
        hm.put("PAK", 30);
        hm.put("US", 100);
        System.out.println(hm);

        System.out.println(hm.get("hm"));

        System.out.println(hm.containsKey("IND"));
        System.out.println(hm.containsKey("hm"));

        System.out.println(hm.remove("PAK"));
        System.out.println(hm.remove("hm"));

        System.out.println(hm);

    }
}
