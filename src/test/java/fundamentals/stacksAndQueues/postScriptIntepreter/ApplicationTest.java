package fundamentals.stacksAndQueues.postScriptIntepreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class ApplicationTest {

    @Test
    public void addTwoNumbers() {
        String inputFilePath = TestHelper.BASE_PATH + "app_input_addTwoNumbers.txt";
        String outputFilePath = TestHelper.BASE_PATH + "app_output_addTwoNumbers.txt";
        String expectedOutput = "110";

        Application.app(inputFilePath, outputFilePath);
        Assertions.assertEquals(expectedOutput, TestHelper.readFile(outputFilePath));
    }

    @Test
    public void createAndCallMethod() {
        String inputFilePath = TestHelper.BASE_PATH + "app_input_createAndCallMethod.txt";
        String outputFilePath = TestHelper.BASE_PATH + "app_output_createAndCallMethod.txt";
        String expectedOutput = "50";

        Application.app(inputFilePath, outputFilePath);
        Assertions.assertEquals(expectedOutput, TestHelper.readFile(outputFilePath));
    }

    @Test
    public void testStringPrint() {
        String inputFilePath = TestHelper.BASE_PATH + "app_input_printString.txt";
        String outputFilePath = TestHelper.BASE_PATH + "app_output_printString.txt";
        String expectedOutput = "Example 4";

        Application.app(inputFilePath, outputFilePath);
        Assertions.assertEquals(expectedOutput, TestHelper.readFile(outputFilePath));
    }


}
