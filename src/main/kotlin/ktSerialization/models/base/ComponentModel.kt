package ktSerialization.models.base

import kotlinx.serialization.Serializable
import ktSerialization.serializer.ComponentSerializer

@Serializable(with = ComponentSerializer::class)
abstract class ComponentModel {
    abstract val render: String
    abstract val index: Int
    abstract val resource: Any
}
