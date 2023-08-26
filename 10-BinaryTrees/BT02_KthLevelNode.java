import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BT02_KthLevelNode {

    public static List<Integer> kthLevelNodes(Node root, int kthLv) {
        List<Integer> ans = new ArrayList<>();
        kthLevelNodes(root, 1, kthLv, ans);
        return ans;
    }

    private static void kthLevelNodes(Node root, int currentLv, int kthLv, List<Integer> ans) {
            //base case ->  current root is null
        if(root == null) {
            return;
        }

            //when current level match with K th level 
        if(currentLv == kthLv) {    
            ans.add(root.data);
            return;
        }

        kthLevelNodes(root.left, currentLv+1, kthLv, ans);  //left side of current root >> level will increase
        kthLevelNodes(root.right, currentLv+1, kthLv, ans); //right side of current root >> level will increase
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);
 
         int k = 2;

        System.out.println(kthLevelNodes(root,k));
    }
}
