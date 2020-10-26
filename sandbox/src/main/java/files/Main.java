package files;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Hryhorii\\Downloads\\work\\Интеграция_с_КоннексРеимбурсация\\Интеграция с Коннекс(Реимбурсация)\\Решение для ЭЦП\\helsi_signer_service");

        System.out.println(Arrays.stream(file.listFiles()).noneMatch(f -> f.getAbsolutePath().contains("StartAsConsole")));
    }
}
