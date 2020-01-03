package someTasks;

public class BinaryPalindrome {
    public static void main(String[] args) {

        int from = 0;
        int to = 100;

        System.out.println("All binary palindromes in range [" + from + ", " + to + "] :");
        for (int i = from; i <= to; i++) {
            if (isPalindrome(i))
                System.out.println(Integer.toBinaryString(i));
        }
    }

    // function to reverse bits of a number
    public static long reverseBits(long n) {
        long rev = 0;

        // traversing bits of 'n'
        // from the right
        while (n > 0) {
            // bitwise left shift 'rev' by 1
            rev <<= 1;

            // if current bit is '1'
            if ((n & 1) == 1)
                rev ^= 1;
            // bitwise right shift 'n' by 1
            n >>= 1;
        }

        // required number
        return rev;
    }

    // function to check a number
    // is palindrome or not
    public static boolean isPalindrome(long n) {
        // get the number by reversing
        // bits in the  binary
        // representation of 'n'
        long rev = reverseBits(n);

        return (n == rev);
    }
}
