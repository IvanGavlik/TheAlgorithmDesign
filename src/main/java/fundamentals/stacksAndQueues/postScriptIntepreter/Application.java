package fundamentals.stacksAndQueues.postScriptIntepreter;

import java.io.IOException;
import java.util.*;


public class Application {
    /*
    /average { add 2 div } def
    40 60 average
     */
    private final static String complex = "/home/ivan/Documents/projects/TheAlgorithmDesign/src/main/java/fundamentals/stacksAndQueues/postScriptIntepreter/programComplex.txt";
    private final static String simple = "/home/ivan/Documents/projects/TheAlgorithmDesign/src/main/java/fundamentals/stacksAndQueues/postScriptIntepreter/programSimple.txt";

    public static void main(String[] args) {

        // on the start create user dictionary for storing user created functions and variables

        List<PSO> list = new ArrayList<>();
        try {
            list = new PSScanner().scan(simple);
        } catch (IOException ioException) {
            System.out.println("Input file not found " + ioException);
        }

        Interpreter i = new Interpreter();
        list.forEach(el -> {
            i.exe(el);
        });
    }
}

