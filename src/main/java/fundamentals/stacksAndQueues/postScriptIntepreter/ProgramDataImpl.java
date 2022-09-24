package fundamentals.stacksAndQueues.postScriptIntepreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ProgramDataImpl implements ProgramData {
    Stack<PSO> operand = new Stack<>();
    Stack<Map<String, PSO>> dictionary = new Stack<>();

    {
        HashMap<String, PSO> system = new HashMap<>();
        system.put("add", new PSO("add", null, 0, 0, false));
        system.put("div", new PSO("div", null, 0, 0, false));
        system.put("def", new PSO("def", null, 0, 0, false));
        system.put("print", new PSO("print", null, 0, 0, false));
        dictionary.push(system);

        // create empty user dictionary TODO ALGO FOR FIND
//        HashMap<String, PSO> user = new HashMap<>();
//        dictionary.push(user);
    }

    @Override
    public void pushToOperand(PSO pso) {
        operand.push(pso);
    }

    @Override
    public PSO pullFromOperand() {
        return operand.pop();
    }

    @Override
    public void pushToCurrentDictionary(String key, PSO pso) {
        this.dictionary.peek().put(key, pso);
    }

    @Override
    public void pushToNewDictionary(String key, PSO pso) {}

    @Override
    public PSO getFromDictionary(String key) {
        return this.dictionary.peek().get(key);
    }

    @Override
    public void emptyCurrentDictionary() { }
}
