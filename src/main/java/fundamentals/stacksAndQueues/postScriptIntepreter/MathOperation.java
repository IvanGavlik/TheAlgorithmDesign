package fundamentals.stacksAndQueues.postScriptIntepreter;

import static fundamentals.stacksAndQueues.postScriptIntepreter.PSO.NO_NEED_FOR_INDEX;

public class MathOperation {
    public static PSO add(PSO n1, PSO n2) {
        Integer i = Integer.parseInt(n1.getData());
        Integer i2 = Integer.parseInt(n2.getData());
        Integer res = i + i2;
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }

    public static PSO div(PSO n1, PSO n2) {
        Integer i = Integer.parseInt(n1.getData());
        Integer i2 = Integer.parseInt(n2.getData());
        Integer res = i2 / i;
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }
}
