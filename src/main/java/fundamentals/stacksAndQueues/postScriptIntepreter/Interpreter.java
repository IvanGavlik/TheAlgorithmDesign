package fundamentals.stacksAndQueues.postScriptIntepreter;

import java.util.Stack;

public class Interpreter {
    Stack<PSO> exe = new Stack<>();
    ProgramData program = new ProgramDataImpl();
    public void exe(PSO pso) {
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
        if (pso.getName().equals("div")) {
            this.div();
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

    private void div() {
        program.pushToOperand(MathOperation.div(program.pullFromOperand(), program.pullFromOperand()));
    }
    private void def() {
        PSO value = program.pullFromOperand();
        value.setLiteral(false);
        PSO key = program.pullFromOperand();

        program.pushToCurrentDictionary(key.getData(), value);
    }
    private void print() {
        System.out.println(program.pullFromOperand().getData());
    }
    public PSO getResult() {
        return program.pullFromOperand();
    }
}
