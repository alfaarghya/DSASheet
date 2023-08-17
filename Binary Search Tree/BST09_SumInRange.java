public class BST09_SumInRange {

    static class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int rangeSum(Node root, int lowerBound, int higherBound) {
            //base case
        if(root == null){
            return 0;
        }

        int leftSum, rightSum;

        if(lowerBound <= root.data){
            leftSum = rangeSum(root.left, lowerBound, higherBound);
        }
        if(higherBound >= root.data){
            rightSum = rangeSum(root.right, lowerBound, higherBound);
        }
        
            return leftSum + rightSum + root.data;
        
    
    }

    public static void main(String[] args) {
        /*
                    8
                   / \
                  5   11
                 / \   \
                3  6   20
         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.right = new Node(20);

        System.out.println(rangeSum(root, 5, 11, 0));
    }
}
