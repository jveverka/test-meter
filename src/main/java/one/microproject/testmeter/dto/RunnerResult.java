package one.microproject.testmeter.dto;

public class RunnerResult {

    private final Integer runnerIndex;
    private final Integer nThreads;
    private final Integer repeat;
    private final Long started;
    private final Long duration;

    public RunnerResult(Integer runnerIndex, Integer nThreads, Integer repeat, Long started, Long duration) {
        this.runnerIndex = runnerIndex;
        this.nThreads = nThreads;
        this.repeat = repeat;
        this.started = started;
        this.duration = duration;
    }

    public Integer getRunnerIndex() {
        return runnerIndex;
    }

    public Integer getnThreads() {
        return nThreads;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public Long getStarted() {
        return started;
    }

    public Long getDuration() {
        return duration;
    }

}
