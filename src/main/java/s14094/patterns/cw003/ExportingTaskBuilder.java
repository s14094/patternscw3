package s14094.patterns.cw003;

/**
 * @author Paweł Łakomiec
 **/
public class ExportingTaskBuilder {

    private final ObjectPool<ExportingProcess> pool;
    private final int threadNo;
    private final int complexity;

    public ExportingTaskBuilder(ObjectPool<ExportingProcess> pool, int threadNo, int complexity) {
        this.pool = pool;
        this.threadNo = threadNo;
        this.complexity = complexity;
    }


    public ExportingTask build() {
        return new ExportingTask(pool, threadNo, complexity);
    }
}
