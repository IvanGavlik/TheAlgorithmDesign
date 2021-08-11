package evaluateArithmeticEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Arithmetic expression evaluation. Evaluate.java is a stack client that evaluates fully
 * parenthesized arithmetic expressions. It uses Dijkstra's 2-stack algorithm:
 *
 *     Push operands onto the operand stack.
 *     Push operators onto the operator stack.
 *     Ignore left parentheses.
 *     On encountering a right parenthesis, pop an operator,
 *     pop the requisite number of operands, and push onto the operand stack
 *     the result of applying that operator to those operands.
 *
 * This code is a simple example of an interpreter.
 *
 */
public class EvaluateArithmeticEx {

    public int evaluate(String expression) {
        List<Token> operans = new ArrayList<>();
        Stack<Token> operatorStack = new Stack<>();

        for (String ex : expression.split(" ")) {
            Token token = TokenService.createToken(ex);

            switch (token.getTokeType()) {

                case OPERAND:

            }

        }

        return 0;
    }

}

class TokenService {
    public static Token createToken(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new Token(input, TokeType.getType(input));
    }

    public static int getOperatorPrecedence(Token token) {
        if (token.getTokeType() != TokeType.OPERATOR) {
            return -1;
        }

        return switch (token.getValue()) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> throw new IllegalArgumentException();
        };
    }
}

final class Token {
    private final String value;
    private final TokeType tokeType;

    public Token(String value, TokeType tokeType) {
        this.value = value;
        this.tokeType = tokeType;
    }

    public String getValue() {
        return value;
    }

    public TokeType getTokeType() {
        return tokeType;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value=" + value +
                ", tokeType=" + tokeType +
                '}';
    }
}

enum TokeType {
    OPERAND,
    OPERATOR,
    BRACKET_LEFT,
    BRACKET_RIGHT;

    public static TokeType getType(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return switch (input) {
            case "+", "-", "*", "/" -> OPERATOR;
            case "(" -> BRACKET_LEFT;
            case ")" -> BRACKET_RIGHT;
            default -> OPERAND;
        };
    }
}
