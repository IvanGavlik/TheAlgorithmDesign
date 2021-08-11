package evaluateArithmeticEx;

import infixToPostfix.InfixToPostfix;

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
 *
 */
public class EvaluateArithmeticEx {

    public Double evaluate(String expression) {

        Stack<Double> operands = new Stack<>();
        String postfixEx = new InfixToPostfix().convert(expression);

        for (String el : postfixEx.split(" ")) {

            Double operand = 0.0;
            try {
                operand = Double.parseDouble(el);
                operands.push(operand);
            } catch (NumberFormatException exception) {
                // I have operator
                Double result = applay(el, operands);
                operands.push(result);
            }

        }
        return operands.pop();
    }

    private Double applay(String el, Stack<Double> operands) {
        Double result = operands.pop();

        switch (el) {
            case "+":
                result = operands.pop() + result;
            break;

            case "-":
                result = operands.pop() - result;
                break;

            case "*":
                result = operands.pop()  * result;
                break;

            case "/":
                result = operands.pop() / result;
                break;
        }

        return result;
    }


}

