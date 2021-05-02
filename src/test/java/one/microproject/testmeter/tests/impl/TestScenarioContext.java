package one.microproject.testmeter.tests.impl;

import java.util.concurrent.TimeUnit;

public class TestScenarioContext {

    private final TimeUnit timeUnit;
    private final Long delay;

    public TestScenarioContext(TimeUnit timeUnit, Long delay) {
        this.timeUnit = timeUnit;
        this.delay = delay;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public Long getDelay() {
        return delay;
    }

}
