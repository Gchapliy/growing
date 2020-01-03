package katas;

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
