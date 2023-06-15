# Kotlin JSON Deserialization Benchmark Test
The following Benchmark aims to compare the following libraries to deserialize JSON:
* [Gson](https://github.com/google/gson)
* [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization)
* [Moshi](https://github.com/square/moshi)

## Requirement
An architecture based on SDUI is being developed which has to have an optimal JSON deserialization engine

## Development goals
* Transform complex data models in such a way that application performance is not affected
* Easy to implement and understand for new developers
* Scalable and maintainable
* Application weight

## Test goals
* Performance of each library
* Development complexity
* Determine the additional weight of each library

## Tools
it uses [Kotlin Benchmark](https://github.com/Kotlin/kotlinx-benchmark) wich is based on [Java Microbenchmark Harness (JHM)](https://github.com/openjdk/jmh).

## Metrics
### Throughput
Operations per unit of time
Counting the total throughput over all worker threads. This mode is time-based, and it will run until the iteration time expires.
### Average
Average time per per operation
Counting the average time to call over all worker threads. This is the inverse of {@link Mode#Throughput}, but with different aggregation policy. This mode is time-based, and it will run until the iteration time expires.
### Sample time
Samples the time for each operation
Randomly samples the time needed for the call. This mode automatically adjusts the sampling frequency, but may omit some pauses which missed the sampling measurement. This mode is time-based, and it will run until the iteration time expires.
### Single shot time
Measures the time for a single operation
This mode is useful to estimate the "cold" performance when you don't want to hide the warmup invocations, or if you want to see the progress from call to call, or you want to record every single sample. This mode is work-based, and will run only for a single invocation of Benchmark method.
Caveats for this mode include:
* More warmup/measurement iterations are generally required.
* Timers overhead might be significant if benchmarks are small; switch to SampleTime mode if that is a problem.

## Considerations
This test is performed under the following environment:
* Hardware:
  * MacBook Pro 13" M1 2020
  * 16 GB RAM
* Software 
  * macOS 13.4 (22F66)
  * IntelliJ IDEA 2023.1.2 (Community Edition) | Build #IC-231.9011.34
