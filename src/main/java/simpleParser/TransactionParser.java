package simpleParser;

import java.util.Date;

/**
 * Develop the parser.
 * Takes a single String argument to specify the initialization values,
 * Uses the format: customer date amount separated by whitespaces
 * Example: Turing 5/22/1919 11.99
 */
public class TransactionParser {

    private DateParser dateParser;

    public TransactionParser(DateParser dateParser) {
        this.dateParser = dateParser;
    }

    public Transaction parse(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] splited = input.split(" ");
        if (splited.length != 3) {
            throw new IllegalArgumentException();
        }

        String customer = splited[0];
        if (customer.length() < 3 || isNumber(customer) ) {
            throw new IllegalArgumentException("Customer is not defined");
        }

        Date date = dateParser.parseDate(splited[1]);
        Double amount = Double.parseDouble(splited[2].replace(',', '.'));

        return new Transaction(customer, date, amount);
    }

    private boolean isNumber(String input) {
        if( input == null || input.isEmpty() ) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
