package s14094.patterns.cw003;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static s14094.patterns.cw003.Service.USED_COMPLEXITY;

/**
 * @author Paweł Łakomiec
 **/
@State(Scope.Group)
public class Main {

    private final AtomicLong processNo = new AtomicLong(0);

    private ObjectPool<ExportingProcess> pool;

    private int complexityProcess = 1;

    public static void main(String[] args) throws RunnerException, IOException {
        Options options = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();


        Main op = new Main();
        op.setUp();
        op.tearDown();
        op.testObjectPool();
    }



    public void setUp() {
        pool = new ObjectPool<ExportingProcess>(4, 10, 5) {
            protected ExportingProcess createObject() {
                try {
                    if (USED_COMPLEXITY == 1) {
                        return new ExportingProcess_O1(processNo.incrementAndGet());
                    } else if (USED_COMPLEXITY == 2) {
                        return new ExportingProcess_On(processNo.incrementAndGet());
                    } else {
                        return new ExportingProcess_On2(processNo.incrementAndGet());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }

    public void tearDown() {
        pool.shutdown();
    }

    @Benchmark
    @GroupThreads(2)
    @Group("g1")
    public void testObjectPool() {
        ExecutorService executor = Executors.newFixedThreadPool(12);
        int complexId = 1;

        for (int i = 0; i < 12; i++) {
            if (complexId > 3) {
                complexId = 1;
            }
            executor.execute(new ExportingTaskBuilder(pool, i, complexId).build());
            complexId++;
        }

        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
