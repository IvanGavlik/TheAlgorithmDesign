package fundamentals.stacksAndQueues.postScriptIntepreter;

import java.util.ArrayList;
import java.util.List;

public class PSOComplex extends PSO {
    private List<PSO> psoList = new ArrayList<>();

    public PSOComplex(String name, int lineIndex, int tokenIndex, boolean literal) {
        super(name, null, lineIndex, tokenIndex, literal);
    }

    public void addSimple(PSO pso) {
        this.psoList.add(pso);
    }

    public List<PSO> getSimple() {
        return this.psoList;
    }
}
