package katas;

/**
 * ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
 *
 * If the function is passed a valid PIN string, return true, else return false.
 *
 * eg:
 *
 * Solution.validatePin("1234") === true
 * Solution.validatePin("12345") === false
 * Solution.validatePin("a234") === false
 */
public class RegexValidatePinCode {
    public static void main(String[] args) {
        System.out.println(validatePin("1234"));
        System.out.println(validatePin("12345"));
        System.out.println(validatePin("a234"));
    }
    public static boolean validatePin(String s1) {
        return s1.matches("[0-9]{4}|[0-9]{6}");
    }
}
