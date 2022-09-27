package fundamentals.stacksAndQueues.postScriptIntepreter;

import static fundamentals.stacksAndQueues.postScriptIntepreter.PSO.NO_NEED_FOR_INDEX;

public class MathOperation {
    public static PSO add(PSO n1, PSO n2) {
        Integer i = Integer.parseInt(n1.getData());
        Integer i2 = Integer.parseInt(n2.getData());
        Integer res = i + i2;
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }

    public static PSO sub(PSO n1, PSO n2) {
        Integer i = Integer.parseInt(n1.getData());
        Integer i2 = Integer.parseInt(n2.getData());
        Integer res = i2 - i;
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }

    public static PSO mul(PSO n1, PSO n2) {
        Integer i = Integer.parseInt(n1.getData());
        Integer i2 = Integer.parseInt(n2.getData());
        Integer res = i2 * i;
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }

    public static PSO div(PSO n1, PSO n2) {
        Integer i = Integer.parseInt(n1.getData());
        Integer i2 = Integer.parseInt(n2.getData());
        Integer res = i2 / i;
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }

    public static PSO mod(PSO n1, PSO n2) {
        Integer i = Integer.parseInt(n1.getData());
        Integer i2 = Integer.parseInt(n2.getData());
        Integer res = i2 % i;
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }
    public static PSO abs(PSO n1) {
        Integer i = Integer.parseInt(n1.getData());
        Integer res = Math.abs(i);
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }
    public static PSO neg(PSO n1) {
        Integer i = Integer.parseInt(n1.getData());
        if (i < 0) {
            Integer res = i * ( - 1 );
            return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
        }
        return new PSO("number", i.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }
    public static PSO sqrt(PSO n1) {
        Double i = Double.parseDouble(n1.getData());
        Double res = Math.sqrt(i);
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }

}
