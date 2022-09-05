package evaluateArithmeticEx;

import fundamentals.stacksAndQueues.evaluateArithmeticEx.EvaluateArithmeticEx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EvaluateArithmeticExTest {

    private EvaluateArithmeticEx evaluateArithmeticEx;

    @BeforeEach()
    public void init() {
        this.evaluateArithmeticEx = new EvaluateArithmeticEx();
    }

    @Test
    public void evaluateSimpleEx() {
        String ex = "( 2 + 2 + 2 + 2 )";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void evaluateSimpleEx2() {
        String ex = "( 2 + 2 ) + ( 2 - 2 )";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void allOperators() {
        String ex = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(270, result);
    }

    // TODO add all tests from infixToPostfixTest
}
