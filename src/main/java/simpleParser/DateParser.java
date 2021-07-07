package simpleParser;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Develop the parser.
 * Takes a single String argument to specify the initialization values,
 * Uses the format: dd-mm-yyyy
 */
public class DateParser {

    /**
     * Phases of Parsing
     * 1. Scanning is a process of converting a stream of characters into tokens.
     * 2. Syntactic Analysis analyses the structure formed as keeping tokens in order as their positions.
     * It also validates and extracts engraved data to create the preferred Data Structure.
     * @param date
     * @return
     */
    public Date parseDate(String date) {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException(date +" is not valid");
        }
        // 1. defining a regular expression
        Pattern dateMatcher = Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");
        // 2. matching a regular expression (Scanning)
        Matcher matcher = dateMatcher.matcher(date);

        // 3. if pattern matches
        if (matcher.find()) {
            // extract day (Syntactic Analysis)
            int day = Integer.parseInt(matcher.group(1));
            if (day < 0 || day > 30) {
                throw new IllegalArgumentException(day +" is not valid");
            }
            int month = Integer.parseInt(matcher.group(2));
            if (month < 0 || month > 12) {
                throw new IllegalArgumentException(month +" is not valid");
            }

            int year = Integer.parseInt(matcher.group(3));
            if (year < 0) {
                throw new IllegalArgumentException(year +" is not valid");
            }

            // 4. validate date : skipped code
            return new Date(day, month, year);
        } else {
            throw new IllegalArgumentException(date +" is not valid");
        }
    }
}
