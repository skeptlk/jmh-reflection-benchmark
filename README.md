
## Benchmark results: 

```shell
# Run complete. Total time: 00:04:00

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.

Benchmark                                         Mode  Cnt   Score   Error  Units
ReflectionBenchmark.directCall                    avgt    5   0.503 ± 0.013  ns/op
ReflectionBenchmark.reflectionCachedCallUnCached  avgt    5  54.457 ± 4.098  ns/op
ReflectionBenchmark.reflectionCall                avgt    5   9.521 ± 0.349  ns/op
```

