package org.sample;

import org.openjdk.jmh.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(3)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
public class ReflectionBenchmark {

    private SampleClass sampleObject;
    private Method method;

    @Setup(Level.Iteration)
    public void setup() throws NoSuchMethodException {
        sampleObject = new SampleClass();
        method = SampleClass.class.getMethod("compute", int.class);
    }

    @Benchmark
    public Object reflectionCall() throws Exception {
        return method.invoke(sampleObject, 42);
    }

    @Benchmark
    public int directCall() {
        return sampleObject.compute(42);
    }

    public static class SampleClass {
        public int compute(int value) {
            return value * 2; // Sample computation
        }
    }
}
