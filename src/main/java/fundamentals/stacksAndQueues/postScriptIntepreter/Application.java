package fundamentals.stacksAndQueues.postScriptIntepreter;

import java.io.IOException;
import java.util.*;

/**
 Goals
 - write tests (use tutorial and examples)
 - clearly define language (data types and rest)
 - read me add description of solution (images)
 - JVM (heap) simple implementation -> create post about this
 - use tools for code analysis (static and dynamic) -> create post about this
 - create post about this task (explain problem and solution)
 */
public class Application {

    public static String OUTPUT = "";

    // on the start create user dictionary for storing user created functions and variables
    // https://algs4.cs.princeton.edu/13stacks/

    public static void app(String filePathInput, String filePathOutput) {
        OUTPUT = filePathOutput;
        List<PSO> list = new ArrayList<>();
        try {
            list = new PSScanner().scan(filePathInput);
        } catch (IOException ioException) {
            System.out.println("Input file not found " + ioException);
        }

        Interpreter i = new Interpreter();
        list.forEach(el -> {
            try {
                i.exe(el);
            } catch (Exception ex) {
                System.out.println("at " + el.getLineIndex() + " at " + el.getTokenIndex() + " " + el.getName() + " " + ex);
                throw new RuntimeException(ex);
            }
        });
    }
}

