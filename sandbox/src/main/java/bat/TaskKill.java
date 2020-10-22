package bat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TaskKill {
    public static void main(String[] args) {
        isPortAvailable();
    }

    private static void killTaskByName() {
        try {
            Runtime.getRuntime().exec("taskkill /IM \"eSign.Signer.Integration.Client.exe\" /F");
            Runtime.getRuntime().exec("taskkill /IM \"cmd.exe\" /F");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPortAvailable() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "netstat -ano | findstr :5000");
        pb.redirectErrorStream(true);
        Process process = null;
        try {
            process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            return process.getInputStream().read() == -1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static String printProcessStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        int bytesRead = -1;
        byte[] bytes = new byte[1024];
        String output = "";
        while ((bytesRead = inputStream.read(bytes)) > -1) {
            output = output + new String(bytes, 0, bytesRead);
        }

        return output;
    }
}
