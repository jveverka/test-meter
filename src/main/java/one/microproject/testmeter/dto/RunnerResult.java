package one.microproject.testmeter.dto;

public class RunnerResult {

    private final Integer id;
    private final Integer nThreads;
    private final Integer repeat;
    private final Long started;
    private final Long duration;

    public RunnerResult(Integer id, Integer nThreads, Integer repeat, Long started, Long duration) {
        this.id = id;
        this.nThreads = nThreads;
        this.repeat = repeat;
        this.started = started;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
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
