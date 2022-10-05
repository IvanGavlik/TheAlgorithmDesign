package fundamentals.stacksAndQueues.postScriptIntepreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

public class InterpreterTest {
    private Interpreter interpreter;

    @BeforeEach
    private void setInterpreter() {
        this.interpreter = new Interpreter();
    }

    /**
     * ((1/2) + (1/2)*sqrt(3))²
     *
     * 1 2 div + 1 2 div 3 sqrt mul 2 exp
     */
    @Test
    public void testMathOperations() {
        this.interpreter.exe(createNumber(1));
        this.interpreter.exe(createNumber(2));
        this.interpreter.exe(createOperation("div"));
        PSO pso = this.interpreter.getCurrentOperand();
        Assertions.assertEquals("0", pso.getData());
    }

    @Test
    public void getCurrentOperandWhenNoData() {
        this.interpreter.exe(createNumber(1));
        PSO pso = this.interpreter.getCurrentOperand();
        Assertions.assertNotNull(pso);

        // when there is no data return null
        Assertions.assertThrows(EmptyStackException.class, this.interpreter::getCurrentOperand);
    }

    private PSO createNumber(Integer number) {
        return new PSO("number", number.toString(), 0, 0, true);
    }

    private PSO createOperation(String operationName) {
        return new PSO("div", operationName, 0, 0, false);
    }


}
