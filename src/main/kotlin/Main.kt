import com.google.gson.GsonBuilder
import gson.GsonComponentModel
import gson.GsonDataContentModel
import gson.PolymorphDeserializer
import ktSerialization.models.base.DataContentModel
import ktSerialization.serializer.ComponentSerializer
import moshiSerialization.config.getMoshi
import moshiSerialization.models.MoshiDataContentModel
import shared.mockData
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime
import kotlin.time.toJavaDuration


fun main() {
    testMoshiSerialization()
    testGsonSerialization()
    testKotlinSerialization()
}


@OptIn(ExperimentalTime::class)
fun testKotlinSerialization() {
    println("* Start Kotlin Serialization")

    val elapsedTime = measureTime {
        println("* Result: " + ComponentSerializer.projectJson.decodeFromString<DataContentModel>(mockData))
    }

    println("* Finished Kotlin Serialization in ${elapsedTime.toJavaDuration().toMillis()}ms")
    println("=============================================================================")
}

@OptIn(ExperimentalTime::class)
fun testMoshiSerialization() {
    println("* Start Moshi Serialization")

    val elapsedTime = measureTime {
        println("* Result: " + getMoshi().adapter(MoshiDataContentModel::class.java).fromJson(mockData))
    }

    println("* Finished Moshi Serialization in ${elapsedTime.toJavaDuration().toMillis()}ms")
    println("=============================================================================")
}

@OptIn(ExperimentalTime::class)
fun testGsonSerialization() {
    println("* Start Gson Serialization")
    val gson = GsonBuilder()
        .registerTypeAdapter(GsonComponentModel::class.java, PolymorphDeserializer<GsonComponentModel>())
        .create()

    val elapsedTime = measureTime {
        println("* Result: " + gson.fromJson(mockData, GsonDataContentModel::class.java))
    }

    println("* Finished Gson Serialization in ${elapsedTime.toJavaDuration().toMillis()}ms")
    println("=============================================================================")
}
