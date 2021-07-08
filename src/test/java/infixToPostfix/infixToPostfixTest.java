package infixToPostfix;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TODO negative cases
public class infixToPostfixTest {
    private InfixToPostfix infixToPostfix;

    @BeforeEach()
    public void init() {
        this.infixToPostfix = new InfixToPostfix();
    }

    @Test
    public void add() {
        Assertions.assertEquals("2 3 +",
                infixToPostfix.convert("2 + 3"));
    }

    @Test()
    public void add2() {
        Assertions.assertEquals("1 2 + 3 + 4 +",
                infixToPostfix.convert("1 + 2 + 3 + 4"));
    }


    @Test
    public void addAndMultiplication() {
        Assertions.assertEquals("2 3 5 * +",
                infixToPostfix.convert("2 + 3 * 5"));
    }

    @Test()
    public void addAndMultiplication2() {
        Assertions.assertEquals("1 2 3 * + 4 +",
                infixToPostfix.convert("1 + 2 * 3 + 4"));
    }

    @Test()
    public void multiplicationAndAdd() {
        Assertions.assertEquals("1 2 * 3 4 * +",
                infixToPostfix.convert("1 * 2 + 3 * 4"));
    }

    @Test()
    public void addAndMultiplicationBrackets() {
        Assertions.assertEquals("1 2 + 3 4 + *",
                infixToPostfix.convert("( 1 + 2 ) * ( 3 + 4 )"));
    }

    @Test()
    public void allOperators() {
        Assertions.assertEquals("1 2 3 + * 4 /",
                infixToPostfix.convert("( ( 1 * ( 2 + 3 ) ) / 4 )"));
    }

    @Test()
    public void allOperators2() {
        Assertions.assertEquals("1 2 3 4 / + *",
                infixToPostfix.convert("( 1 * ( 2 + ( 3 / 4 ) ) )"));
    }

    @Test()
    public void allOperators3() {
        Assertions.assertEquals("2 3 4 + + 5 6 * *",
                infixToPostfix.convert("( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )"));
    }

    @Test()
    public void allOperators4() {
        Assertions.assertEquals("5 7 1 1 + * + 3 * 2 1 1 + * +",
                infixToPostfix.convert("( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )"));
    }

}
