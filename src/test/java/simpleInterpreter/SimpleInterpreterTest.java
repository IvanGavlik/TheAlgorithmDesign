package simpleInterpreter;

import fundamentals.stacksAndQueues.simpleInterpreter.SimpleInterpreter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleInterpreterTest {

    private SimpleInterpreter simpleInterpreter;

    @BeforeEach
    public void init() {
        this.simpleInterpreter = new SimpleInterpreter();
    }

    @Test
    public void test() {
        Assertions.assertTrue(this.simpleInterpreter.isVaild("[ ]"));
        Assertions.assertTrue(this.simpleInterpreter.isVaild("( )"));
        Assertions.assertTrue(this.simpleInterpreter.isVaild("( ) [ ]"));
        Assertions.assertTrue(this.simpleInterpreter.isVaild("[ ] ( ( [ ] ( ) ) )"));
        Assertions.assertTrue(this.simpleInterpreter.isVaild("[ ( ) ] { } { [ ( ) ( ) ] ( ) }"));
        Assertions.assertFalse(this.simpleInterpreter.isVaild("[ ( ] )"));
    }
}
