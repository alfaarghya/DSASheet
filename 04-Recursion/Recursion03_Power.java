

public class Recursion03_Power {

    public static int pow(int x, int n) { //TC -> O(n)
            //base case
        if(n == 0) {
            return 1;
        }

        return x * pow(x, n-1);
    }

    public static int optimizedPow(int x, int n) {  //TC -> O(log(n))
            //base class
        if(n == 0) {
            return 1;
        }
            /* Logic */
        int halfPower = optimizedPow(x, n/2);
        int halfpowerSq = halfPower * halfPower;

        if(n%2 != 0) {
            halfpowerSq = x * halfpowerSq;
        }
        
        return halfpowerSq;
    }

    public static void main(String[] args) {
        int x = 2, n = 12;        
        System.out.println(optimizedPow(x, n));
    }
}
