import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunCmd {

    public String JavaRunTime (String command) {

        String output = "";

        try {
            Runtime rt = Runtime.getRuntime();
            //Process pr = rt.exec("cmd /c dir");
            Process pr = rt.exec(command);

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getErrorStream()));

            String line;


            while((line=input.readLine()) != null) {
                output = output + "\n" + line;
            }

            int exitVal = pr.waitFor();
            //System.out.println("Exited with error code "+exitVal);

        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

        return output;
    }
}
