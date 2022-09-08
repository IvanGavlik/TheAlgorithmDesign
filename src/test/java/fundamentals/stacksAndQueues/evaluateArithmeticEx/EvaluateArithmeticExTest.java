package fundamentals.stacksAndQueues.evaluateArithmeticEx;

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

    @Test
    public void noParenthesis1() {
        String ex = "10 + 2 * 6";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(22, result);
    }

    @Test
    public void noParenthesis2() {
        String ex = "100 * 2 + 12";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(212, result);
    }
    @Test
    public void evaluateComplexExpression() {
        String ex = "100 * ( 2 + 12 )";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(1400, result);
    }
    @Test
    public void evaluateComplexExpression2() {
        String ex = "100 * ( 2 + 12 ) / 14";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(100, result);
    }
    @Test
    public void evaluateComplexExpression3() {
        String ex = "( ( 20 - 10 ) * ( 30 - 20 ) + 10 ) * 2";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(220, result);
    }
    @Test
    public void evaluateComplexExpression4() {
        String ex = "( ( 20 - 10 ) * ( 30 - 20 ) / 10 + 10 ) * 2";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(40, result);
    }
    @Test
    public void evaluateComplexExpression5() {
        String ex = "7 * ( 5 + 15 ) / ( 2 * 5 ) - 3";
        Double result = this.evaluateArithmeticEx.evaluate(ex);
        Assertions.assertEquals(11, result);
    }
}
