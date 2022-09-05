package simpleParser;

import fundamentals.dataAbstraction.simpleParser.DateParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateParserTest {

    private DateParser dateParser;

    @BeforeEach()
    public void init() {
        this.dateParser = new DateParser();
    }

    @Test
    public void passIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.dateParser.parseDate(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.dateParser.parseDate(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.dateParser.parseDate("AB"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.dateParser.parseDate("123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.dateParser.parseDate("02-JAN-1994"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.dateParser.parseDate("02-53-1994"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.dateParser.parseDate("43-11-1994"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.dateParser.parseDate("43-11-1111"));
    }

    @Test
    public void parseDate() {
        Assertions.assertEquals(new Date(01, 01, 2001),this.dateParser.parseDate("01-01-2001"));
        Assertions.assertEquals(new Date(01, 11, 2001),this.dateParser.parseDate("01-11-2001"));
        Assertions.assertEquals(new Date(14, 05, 2001),this.dateParser.parseDate("14-05-2001"));
    }
}
