package one.microproject.testmeter.tests.impl;

import one.microproject.testmeter.TestScenario;
import one.microproject.testmeter.TestScenarioProducer;
import one.microproject.testmeter.dto.RunnerContext;
import one.microproject.testmeter.dto.ScenarioRequest;
import one.microproject.testmeter.impl.ScenarioInitException;

import java.util.concurrent.TimeUnit;

public class ExampleTestScenarioProducer implements TestScenarioProducer<TestScenarioContext, TestScenarioResponse> {

    @Override
    public ScenarioRequest<TestScenarioContext> createRequest(RunnerContext context) throws ScenarioInitException {
        return new ScenarioRequest<>(context.getIndex(), new TestScenarioContext(TimeUnit.MILLISECONDS, 100L));
    }

    @Override
    public TestScenario<TestScenarioContext, TestScenarioResponse> createScenario(RunnerContext context) throws ScenarioInitException {
        return new ExampleTestScenario();
    }

}
