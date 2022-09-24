package fundamentals.stacksAndQueues.postScriptIntepreter;

public interface ProgramData {
    void pushToOperand(PSO pso);
    PSO pullFromOperand();

    void pushToCurrentDictionary(String key, PSO pso);
    void pushToNewDictionary(String key, PSO pso);
    PSO getFromDictionary(String key);
    void emptyCurrentDictionary();
}
