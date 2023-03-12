public class BT05_MinDistanceBetweenNodes {
    /*--- Node Creation ----*/
    static class Node{
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

      public static Node lowestCommonAncestor(Node root, int n1, int n2){ //TC -> O(n), SC -> O(1)
            //base case
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLCA = lowestCommonAncestor(root.left, n1, n2); //check left side of current root
        Node rightLCA = lowestCommonAncestor(root.right, n1, n2);   //check right side of current root

        if(leftLCA == null){    //when left side of current root does not contain n1 or n2....that's mean n1 & n2 lies in right side
            return rightLCA;
        }
        if(rightLCA == null){    //when right side of current root does not contain n1 or n2....that's mean n1 & n2 lies in left side
            return leftLCA;
        }

        return root;    //when left side contain 1 node and right side contain 1 node..... that's mean root is LCA
    }

    public static int minDistBwtNodes(Node root, int n1, int n2){
      Node lca = lowestCommonAncestor(root, n1, n2);

      int dist1 = lcaDist(lca, n1); //collect the distance for n1
      int dist2 = lcaDist(lca, n2); //collect the distance for n2

      return dist1 + dist2;
    }

    public static int lcaDist(Node root, int n){
        //base case
      if(root == null){
        return -1;
      }

      if(root.data == n){ //when we found n in root
        return 0;
      }

      int leftDist = lcaDist(root.left, n); //search for n in left side of current root
      int rightDist = lcaDist(root.right, n); //search for n in right side of current root

      if(leftDist == -1 && rightDist == -1){  //when both side return -1
        return -1;
      }
      else if(leftDist == -1){  //if n does not exist in left side
        return rightDist + 1;
      }
      else{ //if n does not exist in right side
        return leftDist + 1;
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

        int n1 = 666, n2 = 12;
        int ans = minDistBwtNodes(root, n1, n2);
        if(ans < 0){
            System.out.println("n1 or n2 or both values not in the tree");
        }
        else{
            System.out.println("Minimum distance between n1 & n2 >> "+ans); 
        }
    }
}
