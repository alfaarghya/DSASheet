/*
convert a integer into a String
 */

public class Recursion09_NumberToString {

    private static String numberTOstring(int n) {
        if(n == 0) return "zero";
        if(n == 1) return "one";
        if(n == 2) return "two";
        if(n == 3) return "three";
        if(n == 4) return "four";
        if(n == 5) return "five";
        if(n == 6) return "six";
        if(n == 7) return "seven";
        if(n == 8) return "eight";
        if(n == 9) return "nine";

        return "null";
    }


    public static String convert(int number, StringBuilder sb) {        
            //base case
        if(number/10 == 0) {
            return sb.append(numberTOstring(number%10)+" ").toString();
        }
        
        convert(number/10, sb); //recursive function
        return sb.append(numberTOstring(number%10)+" ").toString();
        
    }

    public static void main(String[] args) {
        System.out.println(convert(1947, new StringBuilder("")));
        
    }
}
