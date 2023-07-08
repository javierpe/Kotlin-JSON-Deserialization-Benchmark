package ktSerialization.models.base

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@Polymorphic
@JsonClassDiscriminator("render")
abstract class ComponentModel {
    abstract val render: String
    abstract val index: Int
    abstract val resource: Any
}
