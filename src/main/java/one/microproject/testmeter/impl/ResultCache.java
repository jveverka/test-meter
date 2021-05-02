package one.microproject.testmeter.impl;

import one.microproject.testmeter.dto.ScenarioRequest;
import one.microproject.testmeter.dto.ScenarioResult;

public interface ResultCache<T, R> {

    void onInitFailed(int i, Throwable t);

    void onStarted(ScenarioRequest<T> request);

    void onResult(ScenarioResult<R> result);

}
