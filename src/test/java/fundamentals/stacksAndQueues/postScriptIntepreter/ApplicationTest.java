package fundamentals.stacksAndQueues.postScriptIntepreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class ApplicationTest {


    @Test
    public void addTwoNumbers() {
        String inputFilePath = "/home/ivan/Documents/projects/TheAlgorithmDesign/src/test/resources/fundamentals/stacksAndQueues/postScriptIntepreter/app_input_addTwoNumbers.txt";
        String outputFilePath = "/home/ivan/Documents/projects/TheAlgorithmDesign/src/test/resources/fundamentals/stacksAndQueues/postScriptIntepreter/app_output_addTwoNumbers.txt";
        String expectedOutput = "110";

        Application.app(inputFilePath, outputFilePath);
        Assertions.assertEquals(expectedOutput, readFile(outputFilePath));
    }

    @Test
    public void createAndCallMethod() {
        String inputFilePath = "/home/ivan/Documents/projects/TheAlgorithmDesign/src/test/resources/fundamentals/stacksAndQueues/postScriptIntepreter/app_input_createAndCallMethod.txt";
        String outputFilePath = "/home/ivan/Documents/projects/TheAlgorithmDesign/src/test/resources/fundamentals/stacksAndQueues/postScriptIntepreter/app_output_createAndCallMethod.txt";
        String expectedOutput = "50";

        Application.app(inputFilePath, outputFilePath);
        Assertions.assertEquals(expectedOutput, readFile(outputFilePath));
    }

    private String readFile(String path)  {
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
