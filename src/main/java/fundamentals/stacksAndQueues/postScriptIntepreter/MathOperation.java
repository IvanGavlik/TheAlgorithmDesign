package fundamentals.stacksAndQueues.postScriptIntepreter;


import static fundamentals.stacksAndQueues.postScriptIntepreter.PSO.NO_NEED_FOR_INDEX;

/**
 * Math operation on {@link PSO} object.
 *
 * Used by {@link Integer} to execute standard build in operations.
 *
 * //TODO refactor
 * {@link PSO#getData()} in each operation is treated
 * if any of {@link PSO#getData()} is double then whole expression will be treated
 * as double and {@link PSO#getData()} double is returned
 * else  {@link PSO#getData()} is treated as integer
 * there are some operation that returns {@link PSO#getData()} as double regardless
 * of input type like: {@link MathOperation#sqrt(PSO)}
 *
 */
class MathOperation {
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
        if (isDouble(n1, n2)) {
            Double d1 = toDouble(n1);
            Double d2 = toDouble(n2);
            Double d = d2 / d1;
            return new PSO("real", d.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
        }
        Integer i1 = Integer.parseInt(n1.getData());
        Integer i2 = Integer.parseInt(n2.getData());
        Integer i = i2 / i1;
        return new PSO("number", i.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
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

    public static PSO exp(PSO n1, PSO n2) {
        Integer i = Integer.parseInt(n1.getData());
        Integer i2 = Integer.parseInt(n2.getData());
        Double res = Math.pow(i2, i);
        return new PSO("number", res.toString(), NO_NEED_FOR_INDEX, NO_NEED_FOR_INDEX, true);
    }

    private static boolean isDouble(PSO n, PSO n1){
        return n.getData().contains(".") || n1.getData().contains(".");
    }

    private static Double toDouble(PSO n) {
        try {
            return Double.parseDouble(n.getData());
        } catch (Exception exception) {
            throw new RuntimeException("Could not convert to double " + n.getData() + " at line " + n.getLineIndex() + " at " + n.getLineIndex());
        }
    }

}
