package fundamentals.stacksAndQueues.postScriptIntepreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Scans post script file using post script grammar rules
 * to create list of {@link PSO} objects which are used by Interpreter to execute script.
 */
public class PSScanner {
    private final String DELIMITER = " "; // TODO delimiter can be problematic - strings, and other types of data
    public List<PSO> scan(String path) throws IOException {
        List<PSO> psoList = new ArrayList<>();

        var reader = new BufferedReader(new FileReader(path));
        String currentLine = null;
        int lineIndex = 1;
        while ((currentLine = reader.readLine()) != null) {
            if (currentLine != null || !currentLine.isEmpty()) {
                psoList.addAll(handleLine(currentLine, lineIndex));
            }
            lineIndex += 1;
        }
        return psoList;
    }

    private List<PSO> handleLine(final String line, final int lineIndex) {
        final List<PSO> psoList = new ArrayList<>();

        final String[] tokens = line.split(DELIMITER); //TODO problem i need space between each token in source file

        PSOComplex complex = null;
        StringBuilder stringBuilder = new StringBuilder();
        boolean toString = false;
        int positionIndex = 1;
        for (String token : tokens) {
            if(token.startsWith("{")) {
                complex = new PSOComplex("exe_array", lineIndex, positionIndex,true);
            } else if (token.endsWith("}")) {
                psoList.add(complex);
                complex = null;
            } else if(token.startsWith("(")) {
                stringBuilder.append(token);
                toString = true;
                if (token.endsWith(")")) {
                    psoList.add(createLSimplePSO(stringBuilder.toString(), lineIndex, positionIndex));
                    toString = false;
                    stringBuilder = new StringBuilder();
                }
            } else if (toString) {
                stringBuilder.append(token);
                if (token.endsWith(")")) {
                    psoList.add(createLSimplePSO(stringBuilder.toString(), lineIndex, positionIndex));
                    toString = false;
                    stringBuilder = new StringBuilder();
                }
            } else {
                if (complex != null) {
                    complex.addSimple(createLSimplePSO(token, lineIndex, positionIndex));
                } else {
                    psoList.add(createLSimplePSO(token, lineIndex, positionIndex));
                }
            }
            positionIndex += 1;
        }
        return psoList;
    }

    private PSO createLSimplePSO(String input, int lineIndex, int positionIndex) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("problem in line " + lineIndex + " at token " + positionIndex);
        }
        try {
            Integer.parseInt(input);
            return new PSO("number", input,  lineIndex, positionIndex, true);
        } catch (Exception ex) {
//  log file System.out.println("Input is not integer " + input);
        }

        try {
            Double.parseDouble(input);
            return new PSO("real", input, lineIndex, positionIndex, true);
        } catch (Exception ex) {
//  log file          System.out.println("Input is not real " + input);
        }

        if (input.startsWith("(") && input.endsWith(")")) {
            String value = input.replace("(", "").replace(")", "").trim();
            return new PSO("string", value, lineIndex, positionIndex, true);
        }

        if(input.startsWith("/")) {
            String value = input.substring(1, input.length());
            return new PSO("name_literal", value,   lineIndex, positionIndex, true);
        }

        if(input.startsWith("{")) {
            return new PSO("procedure_literal", null, lineIndex, positionIndex, true);
        }


        // todo "//name" -
        // TODO []
        return new PSO(input, input, lineIndex, positionIndex, false); // this is name
    }
}
