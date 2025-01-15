package org.sample;

import org.openjdk.jmh.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(1)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class ReflectionBenchmark {

    private SampleClass sampleObject;
    private Method method;

    @Setup(Level.Iteration)
    public void setup() throws NoSuchMethodException {
        sampleObject = new SampleClass();
        method = SampleClass.class.getMethod("compute", int.class);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int directCall() {
        return sampleObject.compute(42);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public Object reflectionCall() throws Exception {
        return method.invoke(sampleObject, 42);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public Object reflectionCachedCallUnCached() throws Exception {
        Method myMethod = SampleClass.class.getMethod("compute", int.class);
        return myMethod.invoke(sampleObject, 42);
    }

    public static class SampleClass {
        public int compute(int value) {
            return value * 2;
        }
    }
}
