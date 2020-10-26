package bat;

public class Main {
    static String path = "C:\\Users\\Hryhorii\\Downloads\\helsi_signer_service";

    public static void main(String[] args) {



        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "cd " + path, " & Start StartAsConsole.bat");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


