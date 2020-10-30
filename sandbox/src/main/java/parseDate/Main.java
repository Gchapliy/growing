package parseDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-21").getTime());
    }
}
