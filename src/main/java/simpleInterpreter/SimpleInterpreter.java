package simpleInterpreter;

import java.util.Stack;

/**
 * Evaluate expressions like
 * [ ] ( ) { } [ ( ) ] ( ( [ ] ( ) ) )
 * token in split using whitespaces
 */
public class SimpleInterpreter {

    public boolean isVaild(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] tokens = expression.split(" ");

        if(tokens.length < 2) {
            throw new SimpleInterpreterException();
        }

        Stack<Token> tokenStack = new Stack<>();
        for (String input : tokens) {
            Token token = Token.getToken(input);

            if (shouldAddToken(token)) {
                tokenStack.push(token);
            } else {
                Token start = tokenStack.pop();
                return isVaidToken(start, token);
            }

        }

        return false;
    }

    private boolean isVaidToken(Token start, Token end) {

        if(start == Token.LP) {
            return end == Token.RP;
        }

        if(start == Token.LP1) {
            return end == Token.RP1;
        }

        if(start == Token.LP2) {
            return end == Token.RP2;
        }

        throw new SimpleInterpreterException("Token not found");
    }

    private boolean shouldAddToken(Token token) {
        switch (token) {
            case LP, LP1, LP2: return true;
            case RP, RP1, RP2: return false;
            default:throw new IllegalArgumentException();
        }
    }
}

/**
 * L AS LEFT
 * R AS RIGHT
 * P AS PARENTHESES
 * EACH PARENTHESES HAVE PAR LEFT AND RIGHT
 */
enum Token {
    LP("("),
    RP(")"),

    LP1("["),
    RP1("["),

    LP2("{"),
    RP2("}");

    private String input;

    Token(String input) {
        this.input = input;
    }

    public static Token getToken(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        switch (input) {
            case "(": return LP;
            case ")": return RP;
            case "[": return LP1;
            case "]": return RP1;
            case "{": return LP2;
            case "}": return RP2;
            default: throw new SimpleInterpreterException("No token for " + input);
        }
    }
}

class SimpleInterpreterException extends RuntimeException {

    public SimpleInterpreterException() {
        super();
    }

    public SimpleInterpreterException(String msg) {
        super(msg);
    }
}
