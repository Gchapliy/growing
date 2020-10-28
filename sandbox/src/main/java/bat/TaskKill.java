package bat;

import java.io.*;
import java.lang.management.ManagementFactory;

public class TaskKill {
    public static void main(String[] args) {
        obtainFocusOnProgram();
    }

    private static void killTaskByName() {
        try {
            Runtime.getRuntime().exec("taskkill /IM \"eSign.Signer.Integration.Client.exe\" /F");
            Runtime.getRuntime().exec("taskkill /IM \"cmd.exe\" /F");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPortAvailable(int port) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "netstat -ano | findstr :" + port);
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
        StringBuilder output = new StringBuilder("start output:\n");
        while ((bytesRead = inputStream.read(bytes)) > -1) {
            output.append(new String(bytes, 0, bytesRead));
        }

        return output.toString();
    }

    private static void getPid() {
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(jvmName);
        try {
            Thread.sleep(10_0000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void obtainFocusOnProgram() {

        String script = "Set objShell = CreateObject(\"WScript.Shell\")\n" +
                "objShell.AppActivate(\"KONEX\")\n" +
                "objShell.SendKeys(\"% {ENTER}{DOWN}{DOWN}{DOWN}{DOWN}{ENTER}\")\n" +
                "Rtn = objShell.AppActivate(\"KONEX\")\n" +
                "If Rtn = True Then\n" +
                "Wscript.Echo \"application already running\"\n" +
                "End If";


        File fileTemp = new File("temp1.vbs");
        //if(!fileTemp.exists()){
        try {
            FileOutputStream fo = new FileOutputStream(fileTemp);
            fo.write(script.getBytes());
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //}

        try {
            Process p = Runtime.getRuntime().exec("cscript.exe " + fileTemp.getAbsolutePath());
            p.waitFor();
            String result = printProcessStream(p.getInputStream());

            if (result.contains("application already running"))
                System.out.println("application is running");
            else
                System.out.println("application is not running");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
