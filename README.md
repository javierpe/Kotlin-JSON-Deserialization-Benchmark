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
 
 ## Test JSON
 ```json

{
  "header": [
    {
      "render": "text",
      "index": 1,
      "resource": {
        "text": "This is a header"
      }
    }
  ],
  "body": [
    {
      "render": "text",
      "index": 1,
      "resource": {
        "text": "This is a body"
      }
    },
    {
      "render": "banner",
      "index": 2,
      "resource": {
        "url": "https://i.pinimg.com/474x/d6/9f/8b/d69f8b207b2a999ef6f843cc62ebbc49.jpg",
        "type": "with_text"
      }
    },
    {
      "render": "message_text",
      "index": 3,
      "resource": {
        "message": "This is a message component"
      }
    }
  ]
}

```

## Results

### Configuration
Setting | Value
--- | ---
Iterations | 2
Max Time | 1
Time unit | Seconds

### First
Simple measurement by calling each respective deserialization method

#### Execution #1
Library | Time in ms
--- | ---
Moshi | 757
Gson | 38
Kotlin | 28

#### Execution #2
Library | Time in ms
--- | ---
Moshi | 754
Gson | 38
Kotlin | 27

#### Execution #3
Library | Time in ms
--- | ---
Moshi | 765
Gson | 40
Kotlin | 28

## Throughput
![bar-graph](https://github.com/javierpe/Kotlin-JSON-Deserialization-Benchmark/assets/7097754/c5fbc154-736e-4fc5-9cc2-75268c0c77fa)

#### With warmup
 - Warmup iterations: 5

Benchmark | Score | Units
--- | --- | ---
Gson | 169.898 | ops/ms
Kotlin | 151.430 | ops/ms
Moshi | 11.316 | ops/ms

#### Without warmup
 - Warmup iterations: 0

Benchmark | Score | Units
--- | --- | ---
Gson | 111.332 | ops/ms
Kotlin | 91.164 | ops/ms
Moshi | 3.628 | ops/ms

## Average time
#### With warmup
 - Warmup iterations: 5

Benchmark | Score | Units
--- | --- | ---
Gson | 0.006 | ms/op
Kotlin | 0.005 | ms/op
Moshi | 0.087 | ms/op

#### Without warmup
 - Warmup iterations: 0

Benchmark | Score | Units
--- | --- | ---
Gson | 0.016 | ms/op
Kotlin | 0.014 | ms/op
Moshi | 0.577 | ms/op

## Single shot time
#### With warmup
 - Warmup iterations: 5

Benchmark | Score | Units
--- | --- | ---
Gson | 0.568 | ms/op
Kotlin | 0.664 | ms/op
Moshi | 5.199 | ms/op

## Single shot time
#### Without warmup
 - Warmup iterations: 0

Benchmark | Score | Units
--- | --- | ---
Gson | 35.654 | ms/op
Kotlin | 41.377 | ms/op
Moshi | 234.596 | ms/op

