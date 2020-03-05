package someTasks;

public class RegexValidator {
    private static final String REGEX_IS_LINK = "[\\\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]{5,256}]";
    private static final String REGEX_ALL_LETTERS = "[a-zA-Zа-яА-Я]+";

    public static void main(String[] args) {

        System.out.println(checkString("https://youtube.com", REGEX_IS_LINK));
        System.out.println("|" + "Глагол ".replaceAll(REGEX_ALL_LETTERS, "") + "|");
    }

    public static boolean checkString(String str, String regex) {
        return str.matches(regex);
    }
}
