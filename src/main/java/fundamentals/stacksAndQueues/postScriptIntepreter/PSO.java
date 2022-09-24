package fundamentals.stacksAndQueues.postScriptIntepreter;

public class PSO {
    private String name;
    private String data;
    private boolean literal;

    /**
     * lineIndex and tokenIndex used to specify where error happened
     * at which line and at which world in line
     * starts from 1
     */
    // at which line in file is this object
    private int lineIndex;

    // at which word in line is this object
    private int tokenIndex;

    public static int NO_NEED_FOR_INDEX = 0;

    public PSO(String name, String data, int lineIndex, int tokenIndex, boolean literal) {
        this.name = name;
        this.data = data;
        this.literal = literal;
        this.lineIndex = lineIndex;
        this.tokenIndex = tokenIndex;
    }

    public String getName() {
        return this.name;
    }
    public boolean isLiteral() {
        return literal;
    }

    public void setLiteral(boolean literal) {
        this.literal = literal;
    }

    public String getData() {
        return data;
    }

    public int getTokenIndex() {
        return tokenIndex;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    @Override
    public String toString() {
        return this.data;
    }
}
