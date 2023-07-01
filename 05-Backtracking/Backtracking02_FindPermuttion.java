public class Backtracking02_FindPermuttion {

    public static void findPermutation(String str, String ans) { //TC -> O(n*n!) || SC -> O(n)
            //base case 
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

            //logic
        for(int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, ans+cur);
        }
    }

    public static void main(String[] args) {
        
        findPermutation("abc", "");
    }
}
