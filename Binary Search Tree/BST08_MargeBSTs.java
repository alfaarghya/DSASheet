import java.util.ArrayList;
import java.util.Collections;

public class BST08_MargeBSTs {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

        /*---- Approach 1 --> using 1 arrayList and java in-build sorting || TC -> O(n*log(n)) SC -> O(1)) ----*/
/*    public static void inOrderTraversal(Node root, ArrayList<Integer> arr){
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left, arr);
        arr.add(root.data);
        inOrderTraversal(root.right, arr);
    }

    public static Node array2BST(ArrayList<Integer> arr, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return null;
        }

        int midIndex = (startIndex+endIndex) / 2;
        Node root = new Node(arr.get(midIndex));

        root.left = array2BST(arr, startIndex, midIndex-1);
        root.right = array2BST(arr, midIndex+1, endIndex);

        return root;
    }

    public static Node margeBST(ArrayList<Integer> arr, Node root1, Node root2){    //TC -> O(n*log(n)) SC -> O(1)
        inOrderTraversal(root1, arr);
        inOrderTraversal(root2, arr);

        Collections.sort(arr);

        return array2BST(arr, 0, arr.size()-1);
    }*/
                                /*---- ----*/

        /*---- Approach 2 --> using 3 arrayList */
    public static void inOrderTraversal(Node root, ArrayList<Integer> arr){
            //base case
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left, arr);   //go to the left side of current root
        arr.add(root.data); //add current root data to a ArrayList
        inOrderTraversal(root.right, arr);  //go to the right side of current root
    }

    public static Node array2BST(ArrayList<Integer> arr, int startIndex, int endIndex) {
            //base case
        if(startIndex > endIndex) {
            return null;
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;   //get the mid index
        Node root = new Node(arr.get(midIndex));    //create  a root of arr[mid] 

        root.left = array2BST(arr, startIndex, midIndex-1); //connect left side of current root to current root
        root.right = array2BST(arr, midIndex+1, endIndex); //connect left side of current root to current root

        return root;
    }

    public static Node margeBST(Node root1, Node root2){    //TC -> O(n) or O(n1+n2) | SC -> O(n) or O(n1+n2)
            //store 1st BST's all Node data into arrayList1
        ArrayList<Integer> arr1 = new ArrayList<>();
        inOrderTraversal(root1, arr1);
            //store 2st BST's all Node data into arrayList2
        ArrayList<Integer> arr2 = new ArrayList<>();
        inOrderTraversal(root2, arr2);

        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
            //sorting 2 arrayList and store it into a final Arraylist
        while(i < arr1.size() && j < arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }
            else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while(i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        return array2BST(finalArr, 0, finalArr.size()-1);   //create a BST using final ArrayList
    }

                    /*---- ----*/

    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        /*
                    10         11                                   10
                   /  \       /  \    ---Expected output--->       /  \
                  6    12    5    15                              5    12
                  BST 1       BST 2                               \   / \
                                                                  6  11 15
         */

        Node root1 = new Node(10);
        root1.left = new Node(6);
        root1.right = new Node(12);

        Node root2 = new Node(11);
        root2.left = new Node(5);
        root2.right = new Node(15);


        Node root = margeBST(root1, root2);
        preOrderTraversal(root);    //for checking New BST
    }
}
