package someTasks;

public class RegexValidator {
    private static final String REGEX = "[\\\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]{5,256}]";

    public static void main(String[] args) {
        System.out.println(checkString("https://youtube.com"));
    }

    public static boolean checkString(String str){
        return str.matches(REGEX);
    }
}
