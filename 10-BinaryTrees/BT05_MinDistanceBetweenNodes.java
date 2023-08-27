/*--- Node Creation ----*/
class Node{
      int data;
      Node left;
      Node right;

      Node(int data){
          this.data =data;
          this.left = null;
          this.right = null;
      }
  }
      /*---- ----*/

public class BT05_MinDistanceBetweenNodes {

    public static int minDistBwtNodes(Node root, int n1, int n2) {
        Node lca = lowestCommonAncestor(root, n1, n2);  //getting lowest common ancestor to calculate distance

        int dist1 = lcaDist(lca, n1);  //distance between lca to n1
        int dist2 = lcaDist(lca, n2);   //distance between lca to n2

        if(dist1 == -1 || dist2 == -1) { // n1 dose not exists or n2 does not exists or both does not exists
            return -1;
        } else {
            System.out.println(lca.data);
            return dist1+dist2; //total distance is the sum of both distance
        }
    }

    public static Node lowestCommonAncestor(Node root, int n1, int n2) { //TC -> O(n), SC -> O(1)
            //base case
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftSide = lowestCommonAncestor(root.left, n1, n2);
        Node rightSide = lowestCommonAncestor(root.right, n1, n2);

        if(leftSide == null) {
            return rightSide;
        }
        if(rightSide == null) {
            return leftSide;
        }

        return root;

    }

    public static int lcaDist(Node lca, int n1) {
        if(lca == null) {
            return -1;
        }

        if(lca.data == n1) {//when we found n in root
            return 0;
        }

        int leftSide = lcaDist(lca.left, n1);   //search for n in left side of current root
        int rightSide = lcaDist(lca.right, n1);//search for n in right side of current root

        if(leftSide == -1 && rightSide == -1) { //when both side reutrn -1
            return -1;
        }

        if(leftSide == -1) {    //n dose not exists in left side
            return rightSide+1;
        } else{ //n dose not exists in right side
            return leftSide+1;
        }
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

        System.out.println(minDistBwtNodes(root, n1, n2));
    }
}
