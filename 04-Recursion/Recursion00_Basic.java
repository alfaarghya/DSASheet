public class Recursion00_Basic {

    public static void decreasingOrder(int n) {
        if( n == 0) {
            System.out.print(0+" ");
            return ;
        }

        System.out.print(n+ " ");;
        decreasingOrder(n-1);
    }
    public static void increasingOrder(int n) {
        if( n == 0) {
            System.out.print(0+" ");
            return ;
        }

        increasingOrder(n-1);
        System.out.print(n+ " ");;
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n-1);
    }

    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int sumFirst_n_NaturalNumbers(int n) {
        if(n == 0) {
            return 0;
        }

        return n+sumFirst_n_NaturalNumbers(n-1);

    }


    public static void main(String[] args) {
        decreasingOrder(10);
        System.out.println();
        increasingOrder(10);
        System.out.println();
        System.out.println(factorial(5));
        System.out.println(fibonacci(10));
        System.out.println(sumFirst_n_NaturalNumbers(11));
    }
}