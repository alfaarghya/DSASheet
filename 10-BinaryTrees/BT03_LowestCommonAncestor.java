import java.util.ArrayList;

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

public class BT03_LowestCommonAncestor {

    /*-------- Approach 1 >> Using extra space in term of Arraylist or Array --------*/
    public static int lowestCommonAncestor_approch1(Node root, int n1, int n2){  //TC -> O(n), SC -> O(n)
            //when tree is empty
        if(root == null){
            System.out.println("Empty Tree");
            return Integer.MIN_VALUE;
        }
            //store the path for n1 & n2
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        

            //from this we get the paths for n1 & n2
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for(;i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){   //current i point uncommon ancestor
                break;
            }
        }

        return path1.get(i-1).data; //i-1 will point to that node where we found common ancestor
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
            //base case
        if(root == null){
            return false;
        }

        path.add(root); //add current root at path
            
        if(root.data == n){ //when current root's data match with n
            return true;
        }

        boolean leftFound = getPath(root.left, n, path);    //found path left side for current root
        boolean rightFound = getPath(root.right, n, path);  //found path right side for current root

        if(leftFound || rightFound){    //left side and right side both or any one return true
            return true;
        }

        path.remove(path.size()-1); //when left and right side both return false.....simply remove that node.....because after that node we don't have n value
        return false;
    }
                                /*---- ----*/

             /*-------- Approach 2 >> here we don't use extra space --------*/
    public static Node lowestCommonAncestor_approch2(Node root, int n1, int n2) { //TC -> O(n), SC -> O(1)
            //base case
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }    

        Node leftSide = lowestCommonAncestor_approch2(root.left, n1, n2); //check left side of current root
        Node rightSide = lowestCommonAncestor_approch2(root.right, n1, n2); //check right side of current root

        if(leftSide == null) {  //when left side of current root does not contain n1 or n2....that's mean n1 & n2 lies in right side
            return rightSide;
        }
        if(rightSide == null) {  //when right side of current root does not contain n1 or n2....that's mean n1 & n2 lies in left sid
            return leftSide;
        }

        return root;    //when left side contain 1 node and right side contain 1 node..... that's mean root is LCA

    }

    public static void main(String[] args) {
        /*
                        1
                      /  \
                     2    3
                   /   \   \
                  4     5   6
                /  \     \
               7    8     9
                   / \   / \
                 10  11 12  13
                / \
               14 15
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.left.left = new Node(7);
         root.left.left.right = new Node(8);
         root.left.left.right.left = new Node(10);
         root.left.left.right.left.left = new Node(14);
         root.left.left.right.left.right = new Node(15);
         root.left.left.right.right = new Node(11);
         root.left.right = new Node(5);
         root.left.right.right = new Node(9);
         root.left.right.right.left = new Node(12);
         root.left.right.right.right = new Node(13);
         root.right.right = new Node(6);
 
         int n1 = 11, n2 = 12;

         System.out.println(lowestCommonAncestor_approch1(root, n1, n2));
         System.out.println(lowestCommonAncestor_approch2(root, n1, n2).data);
    }
}
