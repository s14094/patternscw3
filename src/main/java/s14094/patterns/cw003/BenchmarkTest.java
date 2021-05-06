package s14094.patterns.cw003;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author Paweł Łakomiec
 **/

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2)
public class BenchmarkTest {

    @State(Scope.Thread)
    public static class BenchmarkState {
        public int a = 100;
        public int b = 200;
    }

    @Benchmark
    public int testMethod2(BenchmarkState state){
        return state.a + state.b;
    }
//    Main main = new Main();


}
