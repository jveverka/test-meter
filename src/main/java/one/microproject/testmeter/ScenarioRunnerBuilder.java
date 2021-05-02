package one.microproject.testmeter;


import one.microproject.testmeter.impl.ScenarioRunner;

public class ScenarioRunnerBuilder<T,R> {

    private int runnerIndex = 1;
    private int nThreads = 1;
    private int repeat = 1;
    private TestScenarioProducer<T,R> scenarioProducer;

    public ScenarioRunnerBuilder<T,R> setIndex(int runnerIndex) {
        this.runnerIndex = runnerIndex;
        return this;
    }

    public ScenarioRunnerBuilder<T,R> setNumberOfThreads(int nThreads) {
        this.nThreads = nThreads;
        return this;
    }

    public ScenarioRunnerBuilder<T,R> setRepeat(int repeat) {
        this.repeat = repeat;
        return this;
    }

    public ScenarioRunnerBuilder<T,R> withScenarioProducer(TestScenarioProducer<T,R> scenarioProducer) {
        this.scenarioProducer = scenarioProducer;
        return this;
    }

    public ScenarioRunner<T,R> build() {
        return new ScenarioRunner<>(runnerIndex, nThreads, repeat, scenarioProducer);
    }

}
