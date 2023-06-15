package ktSerialization.models.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataContentModel(
    @SerialName("header") val header: List<ComponentModel>,
    @SerialName("body") val body: List<ComponentModel>
)
