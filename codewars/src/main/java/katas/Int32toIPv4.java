package katas;

/**
 * Take the following IPv4 address: 128.32.10.1
 *
 * This address has 4 octets where each octet is a single byte (or 8 bits).
 *
 * 1st octet 128 has the binary representation: 10000000
 * 2nd octet 32 has the binary representation: 00100000
 * 3rd octet 10 has the binary representation: 00001010
 * 4th octet 1 has the binary representation: 00000001
 * So 128.32.10.1 == 10000000.00100000.00001010.00000001
 *
 * Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361
 *
 * Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.
 *
 * Examples
 * 2149583361 ==> "128.32.10.1"
 * 32         ==> "0.0.0.32"
 * 0          ==> "0.0.0.0"
 */
public class Int32toIPv4 {
    public static void main(String[] args) {
        System.out.println(longToIp(2149583361L));
        System.out.println(longToIp(0));
        System.out.println(longToIp(2154959208L));
        System.out.println(longToIp(2149583361L));
        System.out.println(longToIp(32));
        System.out.println(longToIp(280));
    }

    private static String longToIp(long decimalPresentation){

        long n;
        int counter = 1;
        int octet = 0;
        String point = "";
        String result = "";

        while (octet < 4){

            n = decimalPresentation % 2;

            point = n + point;

            if(counter == 8){
                counter = 0;
                octet++;
                result = Long.parseLong(point, 2) + result;
                point = "";
                if(octet < 4) {
                    result = "." + result;
                }
            }

            decimalPresentation /= 2;
            counter++;
        }

        return result;
    }
}
