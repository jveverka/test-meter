package one.microproject.testmeter.tests.impl;

import one.microproject.testmeter.TestScenario;
import one.microproject.testmeter.impl.ScenarioExecException;

public class ExampleTestScenario implements TestScenario<TestScenarioContext, TestScenarioResponse> {

    @Override
    public TestScenarioResponse getResult(TestScenarioContext request) throws ScenarioExecException {
        try {
            Thread.sleep(request.getTimeUnit().toMillis(request.getDelay()));
            return new TestScenarioResponse(Boolean.TRUE);
        } catch (InterruptedException e) {
            return new TestScenarioResponse(Boolean.FALSE);
        }
    }

}
