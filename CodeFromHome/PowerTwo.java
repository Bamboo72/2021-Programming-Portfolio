// Jacob Schwartz - 3/11/2021
// A quick test program for a Big Java problem (13.1.5)

public class PowerTwo {
    public static int pow2(int n){
        System.out.println(n);
        if(n < 0){
            return -1;
         } else if( n == 0){
            return 1;
         } else {
            return 2 * pow2(n - 1);
         }
    }

    public static void main(String[] args){
        System.out.println("Final: " + pow2(-2));
    }
}
