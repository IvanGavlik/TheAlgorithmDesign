package fundamentals.stacksAndQueues.postScriptIntepreter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Executes {@link PSO} object.
 *
 * Holds build in operations such as:
 *  addition, division, multiply, def procedure, print
 *
 */
final class Interpreter {
    /**
     * In exe stack is current {@link PSO} object which is being executed.
     */
    private Stack<PSO> exe = new Stack<>();

    private ProgramData program = new ProgramDataImpl();

    /**
     * Returns (and removes) current PSO from operand stack.
     * In some situations (depends on the contest) can be considered as
     * result of operation.
     * Example
     * After executing 2 2 add {@link Interpreter#getCurrentOperand()} returns
     * (also removes from stack) result of the add operation (In this case 4)
     *
     *
     * @return current {@link PSO} from operand stack or throw {@link EmptyStackException}
     */
    public PSO getCurrentOperand() {
        return program.pullFromOperand();
    }
    /**
     * Executes {@link PSO} object.
     *
     * Execution flow
     * If {@link PSO} object is literal then it is pushed to operand stack
     * else find and execute build-in action or declared procedure form
     * current dictionary using {@link PSO#getName()} as key.
     *
     * @param pso
     */
    public void exe(PSO pso) {
        // TODO IF pso NULL AND OTHER VALIDATION
        this.exe.push(pso);
        if (pso.isLiteral()) {
            program.pushToOperand(pso);
        } else {
            // imam dva ista objekta pso jedan u dictionariju drugi from tokena
            exeUtil(program.getFromDictionary(pso.getName()));
        }
        this.exe.pop();
    }


    private void exeUtil(PSO pso) {
        if (pso instanceof PSOComplex) {
            ((PSOComplex) pso).getSimple().forEach(el -> exeUtil(el));
        }
        if (pso.isLiteral()) { // nece uvijek radit
            program.pushToOperand(pso);
            return;
        }
        if (pso.getName().equals("add")) {
            this.addition();
        }
        if (pso.getName().equals("sub")) {
            this.sub();
        }
        if (pso.getName().equals("mul")) {
            this.mul();
        }
        if (pso.getName().equals("div")) {
            this.div();
        }
        if (pso.getName().equals("mod")) {
            this.mod();
        }
        if (pso.getName().equals("abs")) {
            this.abs();
        }
        if (pso.getName().equals("neg")) {
            this.neg();
        }
        if (pso.getName().equals("neg")) {
            this.neg();
        }
        if (pso.getName().equals("sqrt")) {
            this.sqrt();
        }
        if (pso.getName().equals("exp")) {
            this.exp();
        }
        if (pso.getName().equals("def")) {
            this.def();
        }
        if (pso.getName().equals("print")) {
            this.print();
        }
    }

    private void addition() {
        program.pushToOperand(MathOperation.add(program.pullFromOperand(), program.pullFromOperand()));
    }
    private void sub() {
        program.pushToOperand(MathOperation.sub(program.pullFromOperand(), program.pullFromOperand()));
    }
    private void mul() {
        program.pushToOperand(MathOperation.mul(program.pullFromOperand(), program.pullFromOperand()));
    }
    private void div() {
        program.pushToOperand(MathOperation.div(program.pullFromOperand(), program.pullFromOperand()));
    }
    private void mod() {
        program.pushToOperand(MathOperation.mod(program.pullFromOperand(), program.pullFromOperand()));
    }
    private void abs() {
        program.pushToOperand(MathOperation.abs(program.pullFromOperand()));
    }
    private void neg() {
        program.pushToOperand(MathOperation.neg(program.pullFromOperand()));
    }
    private void exp() {
        program.pushToOperand(MathOperation.exp(program.pullFromOperand(), program.pullFromOperand()));
    }
    private void sqrt() {
        program.pushToOperand(MathOperation.sqrt(program.pullFromOperand()));
    }
    private void def() {
        PSO value = program.pullFromOperand();
        value.setLiteral(false);
        PSO key = program.pullFromOperand();

        program.pushToCurrentDictionary(key.getData(), value);
    }
    private void print() {
        final String data = program.pullFromOperand().getData();
        if (Application.OUTPUT.isEmpty()) {
            System.out.println(data);
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(Application.OUTPUT));
                writer.write(data);
                writer.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
