import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;

public class cryptoTest {
    private int variabile = 0;
    public static void main(String[] args) {
        System.out.println("Luigi Vezzoso");


        System.out.println(RunLinuxGrepCommand("ping 8.8.8.8 -c 3"));
        System.out.println(RunLinuxGrepCommand("iptables -L"));
    }

    private int get(){
        return variabile;
    }

    public static String RunLinuxGrepCommand(String command) {
        String line = null;
        String strstatus = "";
        try {

            String[] cmd = { "/bin/sh", "-c", command };
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = in.readLine()) != null) {
                strstatus = line;
            }
            in.close();
        } catch (Exception e) {

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            String stackTrace = sw.toString();
            int lenoferrorstr = stackTrace.length();
            if (lenoferrorstr > 500) {
                strstatus = "Error:" + stackTrace.substring(0, 500);
            } else {
                strstatus = "Error:" + stackTrace.substring(0, lenoferrorstr - 1);

            }
        }
        return strstatus;

    }

}



