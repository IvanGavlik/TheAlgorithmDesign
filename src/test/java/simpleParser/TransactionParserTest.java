package simpleParser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;


public class TransactionParserTest {

    private TransactionParser transactionParser;

    @BeforeEach()
    public void init() {
        this.transactionParser = new TransactionParser(new DateParser());
    }

    @Test()
    public void passIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> transactionParser.parse(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> transactionParser.parse(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> transactionParser.parse("123 123 1234"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> transactionParser.parse("123 01-01-2001 1234"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> transactionParser.parse("test 01-01-2001 test"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> transactionParser.parse("  01-01-2001 123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> transactionParser.parse("  01-01-2001  123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> transactionParser.parse("test test 01-01-2001 123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> transactionParser.parse("test test 01-01-2001 12_3"));
    }

    @Test()
    public void testParse() {
        Transaction expectedTransaction = new Transaction("Test", new Date(01, 01, 2021), 12.34);
        Assertions.assertEquals(expectedTransaction, transactionParser.parse("Test 01-01-2021 12.34"));

        expectedTransaction = new Transaction("Test", new Date(01, 01, 2021), 12.34);
        Assertions.assertEquals(expectedTransaction, transactionParser.parse("Test 01-01-2021 12,34"));
    }
}
