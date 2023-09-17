
class Tries {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord;

        // constructor -> in every node store null
        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }

    static Node root = new Node();

    // insert into a Trie
    public void insert(String word) { // TC -> O(L) | L is max size of a word
        Node curr = root;
        // run a loop for current word
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            // remove the null value if there a character to store
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node(); // we don't store char....we create a child node from there
            }
            curr = curr.children[idx]; // go to the next node
        }

        curr.endOfWord = true; // now word is end here so endOfWord is true
    }

    // search into trie
    public boolean search(String word) {
        Node curr = root;

        // run a loop for current word
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) { // there are no such character store
                return false;
            }
            curr = curr.children[idx]; // go to next node
        }
        return curr.endOfWord = true;
    }
}

public class Implement_Trie {
    public static void main(String[] args) {
        Tries trie = new Tries();
        String[] words = {
                "avanger",
                "ironman",
                "captain",
                "america",
                "thor",
                "jarvis",
                "blackwidow",
                "loki",
                "ultran",
                "blackpanther",
                "wanda",
                "drstrange",
                "spiderman",
                "thanos"
        };

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        System.out.println(trie.search("avg"));
        System.out.println(trie.search("avganger"));
    }
}
