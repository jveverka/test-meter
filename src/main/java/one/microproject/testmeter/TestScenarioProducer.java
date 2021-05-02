package one.microproject.testmeter;


import one.microproject.testmeter.dto.RunnerContext;
import one.microproject.testmeter.dto.ScenarioRequest;
import one.microproject.testmeter.impl.ScenarioInitException;

/**
 * Producer called by {@link ScenarioRunner}.
 * @param <T> - request type, input data into scenario execution.
 * @param <R> - response type, the result of scenario execution.
 */
public interface TestScenarioProducer<T, R> {

    /**
     * Create scenario request using context.
     * @param context - context provided by {@link ScenarioRunner}.
     * @return instance of {@link ScenarioRequest}
     * @throws ScenarioInitException - thrown in case that scenario request create fails.
     */
    ScenarioRequest<T> createRequest(RunnerContext context) throws ScenarioInitException;

    /**
     * Create test scenario based using context.
     * @param context - context provided by {@link ScenarioRunner}.
     * @return instance of {@link TestScenario}
     * @throws ScenarioInitException - thrown in case that scenario create fails.
     */
    TestScenario<T, R> createScenario(RunnerContext context) throws ScenarioInitException;

}
