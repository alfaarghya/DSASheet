public class Math02_GCD {

    /*--Brute Force --> simply traverse from 1 to min(m,n) and check for every Number--*/
    // TC -> O(n) || SC -> O(1)
    // public static int calcGCD(int m, int n) {
    // int ans = 1;
    // for (int i = 1; i < Math.min(m, n); i++) {
    // if (m % i == 0 && n % i == 0) {
    // ans = i;
    // }
    // }
    // return ans;
    // }
    /*---- ----*/

    /* optimal --> Using Euclidean’s theorem || recursive approach */
    // TC -> O(log min(m,n)) || TC -> O(1)
    public static int calcGCD(int m, int n) {
        // base case
        if (n == 0) {
            return m;
        }

        // recursive call
        return calcGCD(n, m % n);
    }
    /*---- ----*/

    public static void main(String[] args) {
        System.out.println(calcGCD(9, 6));
        System.out.println(calcGCD(2, 5));
        System.out.println(calcGCD(4, 8));
        System.out.println(calcGCD(1, 2));
    }
}
