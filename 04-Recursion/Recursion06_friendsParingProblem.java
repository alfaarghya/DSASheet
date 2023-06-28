/*
u can make pair of 2 friends ...... find out the way every friends can pair

ex:
    n = 3
    output -> 4

ex:
    n = 4
    output -> 10

ex:
    n = 0
    output -> 1

ex: 
    n = 1
    output -> 1
 */

public class Recursion06_friendsParingProblem {

    public static int friendPair(int n) {
        if( n == 1 || n == 2) {
            return n;
        }

        return friendPair(n-1) + (n-1) * friendPair(n-2);

    }

    public static void main(String[] args) {
        System.out.println(friendPair(4));
    }
}
