public class Backtracking01_FindSubset {

    public static void findSubset(String str, StringBuilder ans, int idx) {
            //base case
        if(idx == str.length()) {   //TC -> O(n*2^n) || SC -> O(n)
            if(ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        
        findSubset(str, ans.append(str.charAt(idx)), idx+1);    //yes choice
        ans.deleteCharAt(ans.length()-1);
        findSubset(str, ans, idx+1);                            //no choice

    }

    public static void main(String[] args) {
        String str = "abc";
        // String ans = "";
        findSubset(str, new StringBuilder(""), 0);

    }
}
