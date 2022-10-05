package fundamentals.stacksAndQueues.postScriptIntepreter;

import java.io.IOException;
import java.util.*;

/**
 -> sta za sta služi i gdje se koristi te kako utjece na druge dijelove programa
 -> npr PSO -> name
        POS -> literal
 -> treba definirati i jasno opisati

 Problem to think
 - how save build in action in dictionary and procedure or variable is PSO good solution
 - how to exe operation (where to store addition and how) so that intepreter executes it
 - odgovornost koja clasa ima ?

 Goals
 - write tests (use tutorial and examples)
 - clearly define language (data types and rest)
    -> String data type
    -> math operation conversion int and double
    -> div always returns Double
    -> cast operators
 - read me add description of solution (images)
 - JVM (heap) simple implementation -> create post about this
 - use tools for code analysis (static and dynamic) -> create post about this
 - create post about this task (explain problem and solution)
 */
public class Application {

    public static String OUTPUT = "";

    // on the start create user dictionary for storing user created functions and variables
    // https://algs4.cs.princeton.edu/13stacks/

    /**
     * Executes post script from {@param filePathInput} file and writes result to {@param filePathOutput}
     *
     * To write result use print procedure.
     * Example:
     * 1 1 add print.
     * Result of add procedure will be saved to internal memory, so to write it to {@param filePathOutput}
     * you need to use print procedure as in example.
     *
     * If error (PSO exception) happens its info is written to {@param filePathOutput}
     * // TODO TEST ERRORS THAT ARE NOT COVERED WITH PSO exception (START APP FROM CONSOLE)
     *
     * If {@param filePathOutput} is null result is written to console.
     *
     *
     * @param filePathInput path to script input file
     * @param filePathOutput path to program output file
     */
    public static void app(String filePathInput, String filePathOutput) {
        /*
            //TODO CATCH POST SCTIP EXCETION then write PSO position (line and index) info to output file
            try {
            } catch(POException ex) {
              // ex.gePSO (line and index )write to file
            }
         */
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

