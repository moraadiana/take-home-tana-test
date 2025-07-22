public class MakeZeroArray{

    //function to compute Greatest Common Divisor (gcd) of two numbers
    static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
    public static int MakeAllZeros(int[] x) {
        int gcdCurrent  = x[0];
        for (int i = 1; i < x.length; i++) {
            gcdCurrent = gcd(gcdCurrent, x[i]);
        }
        return (gcdCurrent == x[0]) ? 1 : 0;
    }
//Test
    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        System.out.println(MakeAllZeros(x));  // Output: 1

        int[] y = {2, 6, 10}; 
        System.out.println(MakeAllZeros(y));  // Output: 0
    }
}
