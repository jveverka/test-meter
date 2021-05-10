package one.microproject.testmeter.dto;

public class RunnerContext {

    private final Integer runnerIndex;
    private final Integer index;

    public RunnerContext(Integer runnerIndex, Integer index) {
        this.runnerIndex = runnerIndex;
        this.index = index;
    }

    public Integer getRunnerIndex() {
        return runnerIndex;
    }

    public Integer getIndex() {
        return index;
    }

}
