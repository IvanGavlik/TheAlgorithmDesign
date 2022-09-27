package fundamentals.stacksAndQueues.postScriptIntepreter;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestHelper {
    public static final String BASE_PATH = "/home/ivan/Documents/projects/TheAlgorithmDesign/src/test/resources/fundamentals/stacksAndQueues/postScriptIntepreter/";

    public static  String readFile(String path)  {
        try {
            var reader = new BufferedReader(new FileReader(path));
            String currentLine = null;
            StringBuilder sb = new StringBuilder();
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine != null || !currentLine.isEmpty()) {
                    sb.append(currentLine);
                }
            }
            return sb.toString();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
