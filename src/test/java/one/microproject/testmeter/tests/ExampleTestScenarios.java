package one.microproject.testmeter.tests;

import one.microproject.testmeter.ScenarioRunnerBuilder;
import one.microproject.testmeter.dto.RunnerResult;
import one.microproject.testmeter.dto.ScenarioContext;
import one.microproject.testmeter.dto.ScenarioRequest;
import one.microproject.testmeter.dto.ScenarioResult;
import one.microproject.testmeter.impl.ScenarioRunner;
import one.microproject.testmeter.tests.impl.ExampleTestScenarioProducer;
import one.microproject.testmeter.tests.impl.TestScenarioContext;
import one.microproject.testmeter.tests.impl.TestScenarioResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.stream.Stream;

import static one.microproject.testmeter.ITTestUtils.scenariosPerSecond;
import static one.microproject.testmeter.ITTestUtils.successRatePercent;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExampleTestScenarios {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleTestScenarios.class);

    private static ScenarioRunner<TestScenarioContext, TestScenarioResponse> scenarioRunner;

    private static int nThreads = 4;
    private static int repeat = 8;

    @BeforeAll
    static void init() {
        ExampleTestScenarioProducer producer = new ExampleTestScenarioProducer();
        scenarioRunner = new ScenarioRunnerBuilder<TestScenarioContext, TestScenarioResponse>()
                .setIndex(1)
                .setNumberOfThreads(nThreads)
                .setRepeat(repeat)
                .withScenarioProducer(producer)
                .build();
    }

    public static Stream<Arguments> provideParameters() {
        return scenarioRunner.getParameters();
    }

    @Order(1)
    @Test
    void submitScenarios() {
        assertDoesNotThrow(() -> scenarioRunner.execTests());
    }

    @Order(2)
    @ParameterizedTest
    @MethodSource("provideParameters")
    void parametrizedScenarioTest(ScenarioRequest<TestScenarioContext> request, ScenarioResult<TestScenarioResponse> result) {
        assertNotNull(request.getId());
        assertTrue(result.getSuccess());
        assertTrue(result.getResult().isPresent());
        assertTrue(result.getResult().get().getSuccess());
    }

    @Order(3)
    @Test
    void evaluateTests() {
        Collection<ScenarioContext<TestScenarioContext, TestScenarioResponse>> results = scenarioRunner.getResults();
        assertNotNull(results);
        assertEquals(nThreads*repeat, results.size());
        RunnerResult runnerResult = scenarioRunner.getRunnerResult();
        assertNotNull(runnerResult);
        long passed = results.stream().filter(c->c.getScenarioResult().getSuccess()).count();
        LOG.info("Scenarios/sec: {}", scenariosPerSecond(results.size(), runnerResult.getDuration()));
        LOG.info("Success/sec  : {}", scenariosPerSecond(passed, runnerResult.getDuration()));
        LOG.info("Success rate : {}%", successRatePercent(results.size(), passed));
    }

}
