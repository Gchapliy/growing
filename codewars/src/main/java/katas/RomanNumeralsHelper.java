package katas;

import java.util.Map;

/**
 * Create a RomanNumerals class that can convert a roman numeral to and from an integer value.
 * It should follow the API demonstrated in the examples below.
 * 10ple roman numeral values will be tested for each helper method.
 *
 * Modern Roman numerals are written by expressing each digit separately starting with the left most digit and
 * skipping any digit with a value of zero. In Roman numerals 1990 is rendered:
 * 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII.
 * 1666 uses each Roman symbol in descending order: MDCLXVI.
 *
 * Examples
 * RomanNumerals.toRoman(1000) // should return 'M'
 * RomanNumerals.fromRoman("M") // should return 1000
 */
public class RomanNumeralsHelper {
    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            String to = toRoman(i);
            System.out.println(to + " - " + fromRoman(to));

        }
    }

    private static String[] mins = new String[]{"I", "X", "C", "M"};
    private static String[] mids = new String[]{"V", "L", "D"};
    private static String[] maxs = new String[]{"X", "C", "M"};

    private static Map<String, Integer> map = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );
    public static String toRoman(int n) {
        String res = "";

        int t = n;
        int m = 1;
        int lvl = 0;

        while (t > 0){
            int div = (t % 10) * m;
            String temp = "";

            for (int i = m; i <= div; i+=m) {
                if(i == (4 * m)) {
                    temp += mids[lvl];
                    temp = temp.substring(temp.length() - 2);
                    continue;
                }
                if(i == (5 * m)) {
                    temp = temp.substring(temp.length() - 1);
                    continue;
                }
                temp += mins[lvl];
                if(i == (9 * m)){
                    temp = temp.substring(temp.length() - 1);
                    temp += maxs[lvl];
                }
            }

            res = temp + res;
            m *= 10;
            t /= 10;
            lvl++;
        }
        
        return res;
    }

    public static int fromRoman(String romanNumeral) {
        int res = 0;
        String[] s = romanNumeral.split("");
        for (int i = 0; i < s.length; i++) {
            res += map.get(s[i]);
            if(i > 0 && map.get(s[i - 1]) < map.get(s[i])) res -= map.get(s[i - 1]) * 2;
        }
        return res;
    }
}
