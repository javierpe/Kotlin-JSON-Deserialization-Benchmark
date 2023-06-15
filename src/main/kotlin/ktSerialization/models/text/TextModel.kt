package ktSerialization.models.text

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TextModel(
    @SerialName("text") val text: String
)
