package fundamentals.stacksAndQueues.postScriptIntepreter;

/**
 * Program Data has two stacks.
 * Operand stack which holds operands and dictionary stack which holds
 * stack of dictionaries.
 *
 * //TODO should I put this to impl. class
 * Operand stack holds {@link PSO} objects (only literal ones - operands).
 * Available operations are push and pull from stack.
 *
 * Dictionary stack holds stack of dictionaries where each dictionary is
 * map where key is String and value is {@link PSO} (only exe ones(not literal) - operations).
 * Used to store user defined procedures, variables  and build in operations such as addition,
 * Dictionary on top of the stack is considered as current dictionary.
 *
 * //TODO system and user dictionary (user dictionary should be on top)
 */
interface ProgramData {
    void pushToOperand(PSO pso);
    PSO pullFromOperand();

    void pushToCurrentDictionary(String key, PSO pso);
    void pushToNewDictionary(String key, PSO pso);
    PSO getFromDictionary(String key);
    void emptyCurrentDictionary();
}
