package benchmarks

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import gson.GsonComponentModel
import gson.GsonDataContentModel
import gson.PolymorphDeserializer
import kotlinx.benchmark.Mode
import kotlinx.benchmark.State
import kotlinx.benchmark.Warmup
import kotlinx.serialization.json.Json
import ktSerialization.models.base.DataContentModel
import moshiSerialization.config.getMoshi
import moshiSerialization.models.MoshiDataContentModel
import org.openjdk.jmh.annotations.*
import shared.mockData
import java.util.concurrent.TimeUnit

/**
 * To run this test execute the following on the command line: ./gradlew jmh
 */
@State(Scope.Benchmark)
@Fork(0)
@Warmup(iterations = 0)
@Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.SingleShotTime)
class BenchmarkTest {

    private lateinit var gson: Gson

    @Setup
    fun setUp() {
        gson = GsonBuilder()
            .registerTypeAdapter(GsonComponentModel::class.java, PolymorphDeserializer<GsonComponentModel>())
            .create()
    }

    @Benchmark
    fun benchmarkKotlinSerialization(): DataContentModel {
        return Json.decodeFromString<DataContentModel>(mockData)
    }

    @Benchmark
    fun benchmarkMoshiSerialization(): MoshiDataContentModel {
        return getMoshi().adapter(MoshiDataContentModel::class.java).fromJson(mockData)!!
    }

    @Benchmark
    fun benchmarkGsonSerialization(): GsonDataContentModel {
        return gson.fromJson(mockData, GsonDataContentModel::class.java)
    }
}