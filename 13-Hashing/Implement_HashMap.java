import java.util.ArrayList;
import java.util.LinkedList;

class HashMap<K, V> { // generics

    private class Node {
        K key;
        V value;

        // constructor
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // HashMap use Array of LinkedList
    private LinkedList<Node>[] bucket;
    private static int N; // size of bucket array
    private static int n; // total number of Node in HashMap

    /*---- HashMap Constructor ----*/
    @SuppressWarnings("unchecked")
    public HashMap() {
        N = 10;
        n = 0;
        bucket = new LinkedList[N];
        // every index of bucket should have empty LinkedList
        for (int i = 0; i < N; i++) {
            bucket[i] = new LinkedList<>();
        }
    }
    /*---- ----*/

    /*---- put (key,value) into HashMap ----*/
    public void put(K key, V value) { // TC ->O(1)
        int bucketIndex = hashFunction(key);// get Index where put/get Node in array
        int dataIndex = searchInLL(bucketIndex, key);// get the node index in LL

        if (dataIndex == -1) { // No node available for the key
            bucket[bucketIndex].add(new Node(key, value)); // add new Node into hashMap
            n++;
        } else { // Node is available
            Node node = bucket[bucketIndex].get(dataIndex);
            node.value = value; // update the value
        }

        double lambda = (double) n / N;

        if (lambda > 5.0) { // lambda is greater than threshold
            reshape(); // then reshape the hashMap
        }
    }
    /*---- ----*/

    /*---- get value from hashMap ----*/
    public V get(K key) { // TC -> O(1)
        int bucketIndex = hashFunction(key);// get Index where put/get Node in array
        int dataIndex = searchInLL(bucketIndex, key);// get the node index in LL

        if (dataIndex == -1) { // No node available for the key
            return null;
        } else { // Node is available
            return bucket[bucketIndex].get(dataIndex).value; // value of key
        }
    }
    /*---- ----*/

    /*---- check key if is it in hashMap ----*/
    public boolean containKey(K key) { // TC -> O(1)
        int bucketIndex = hashFunction(key);// get Index where put/get Node in array
        int dataIndex = searchInLL(bucketIndex, key);// get the node index in LL

        if (dataIndex == -1) { // No node available for the key
            return false;
        } else { // Node is available
            return true;
        }
    }
    /*---- ----*/

    /*---- remove the value using key from hashMap ----*/
    public V remove(K key) { // TC -> O(1)
        int bucketIndex = hashFunction(key);// get Index where put/get Node in array
        int dataIndex = searchInLL(bucketIndex, key);// get the node index in LL

        if (dataIndex == -1) { // No node available for the key
            return null;
        } else { // Node is available
            n--;
            return bucket[bucketIndex].remove(dataIndex).value;
        }
    }
    /*---- ----*/

    /*---- get size of hashMap ----*/
    public int size() {
        return n;
    }
    /*---- ----*/

    /*---- is HashMap empty? ----*/
    public boolean isEmpty() {
        return n == 0;
    }
    /*---- ----*/

    /*---- get key set ----*/
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            LinkedList<Node> ll = bucket[i];
            for (Node node : ll) {
                keys.add(node.key);
            }
        }
        return keys;
    }
    /*---- ----*/

    /*---- Helper function ----*/
    private int hashFunction(K key) {
        return Math.abs(key.hashCode()) % N;
    }

    private int searchInLL(int bucketIndex, K key) {
        LinkedList<Node> ll = bucket[bucketIndex];
        int dataIndex = 0;
        // run a loop and find the key
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i).key == key) {
                return dataIndex; // key found
            }
            dataIndex++;
        }
        return -1; // key is not available in HashMap
    }

    @SuppressWarnings("unchecked")
    private void reshape() {
        LinkedList<Node>[] oldBucket = bucket; // store bucket's all Node into oldBucket
        N *= 2; // increase bucket size
        bucket = new LinkedList[N];

        // every index of bucket should have empty LinkedList
        for (int i = 0; i < N; i++) {
            bucket[i] = new LinkedList<>();
        }

        // go through old bucket & remove all nodes from it & put in into bucket
        for (int i = 0; i < oldBucket.length; i++) {
            LinkedList<Node> ll = oldBucket[i];
            for (int j = 0; j < ll.size(); i++) {
                Node node = ll.remove(j);
                put(node.key, node.value);
            }
        }
    }
    /*---- ----*/

}

public class Implement_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        System.out.println(hm.size());

        hm.put("U", 1);
        hm.put("a", 2);
        hm.put("X", 3);
        hm.put("y", 4);
        hm.put("y", 5);
        hm.put("A", 6);
        hm.put("B", 7);

        System.out.println(hm.keySet());
        System.out.println(hm.size());
        System.out.println(hm.containKey("a"));
        System.out.println(hm.containKey("b"));
        System.out.println(hm.get("A"));
        System.out.println(hm.get("M"));
        System.out.println(hm.remove("y"));
        System.out.println(hm.remove("m"));
        System.out.println(hm.keySet());
        System.out.println(hm.size());
    }
}
