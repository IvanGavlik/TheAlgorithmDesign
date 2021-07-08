package infixToPostfix;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Write a program  that converts an arithmetic
 * expression from infix to postfix.
 *
 * Infix notation is the notation commonly used in arithmetical
 * and logical formulae and statements. It is characterized by the
 * placement of operators between operands—"infixed operators"
 * —such as the plus sign in 2 + 2.
 *
 * Postfix Notation
 * This notation style is known as Reversed Polish Notation. In this notation style,
 * the operator is postfixed to the operands i.e., the operator is written after the operands.
 * For example, ab+. This is equivalent to its infix notation a + b.
 */
public class InfixToPostfix {

    /**
     * Converts an arithmetic expression from infix to postfix
     * Supported operators: +, -, /, *, (, )
     * Use whitespaces to split operators and operands
     *
     * Example A:
     * Input A + B * C
     * Output A B C * +
     *
     * Example B:
     * input (A + B) * C
     * Output A B + C *
     *
     * Algo explanation:
     * 1. Create an empty stack called operatorStack for keeping operators. Create an empty list for output.
     * 2. Convert the input infix string to a list by using the string method split.
     * 3. Scan the token list from left to right.
     *     3.1 If the token is an operand, append it to the end of the output list.
     *     3.2 If the token is a left parenthesis, push it on the operatorStack.
     *     3.3 If the token is a right parenthesis, pop the operatorStack until the corresponding left parenthesis is
     *         removed. Append each operator to the end of the output list.
     *     3.4 If the token is an operator, *, /, +, or -, push it on the operatorStack.
     *          First remove any operators already on the operatorStack that have higher or
     *          equal precedence and append them to the output list.
     *     3.5 When the input expression has been completely processed, check the operatorStack.
     *          Any operators still on the stack can be removed and appended to the end of the output list.
     *
     * For moew info @see: https://runestone.academy/runestone/books/published/pythonds/BasicDS/InfixPrefixandPostfixExpressions.html
     * @param infix
     * @return postfix
     */
    public String convert(String infix) {
        String[] ops = infix.split(" ");

        List<Token> output = new ArrayList<>();
        Stack<Token> operatorStack = new Stack<>();

        for (String infixToken : ops) {
            Token token = TokenService.createToken(infixToken);

            switch (token.getTokeType()) {
                case OPERATOR:
                    int operatorStackSize = operatorStack.size();
                    while (operatorStackSize > 0) {
                        Token peek = operatorStack.peek();
                        if (TokenService.getOperatorPrecedence(peek) >= TokenService.getOperatorPrecedence(token)) {
                            output.add(operatorStack.pop());
                        }
                        operatorStackSize -= 1;
                    }
                    operatorStack.push(token); // push current operator to stack
                    break;
                case OPERAND:
                    output.add(token);
                    break;
                case BRACKET_LEFT:
                    operatorStack.push(token);
                    break;
                case BRACKET_RIGHT:
                    int stackSize = operatorStack.size();
                    while (stackSize > 0) {
                        Token peek = operatorStack.peek();
                        if (peek.getTokeType() != TokeType.BRACKET_LEFT) {
                            output.add(operatorStack.pop());
                        } else {
                            operatorStack.pop(); // remove BRACKET_LEFT from stack
                        }
                        stackSize -= 1;
                    }
                    break;
                default: throw new IllegalArgumentException();
            }
        }

        while (operatorStack.size() > 0) {
            output.add(operatorStack.pop());
        }

        return output.stream()
                .map(el -> el.getValue())
                .collect(Collectors.joining(" "));
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
