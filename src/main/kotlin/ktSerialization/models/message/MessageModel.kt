package ktSerialization.models.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageModel(
    @SerialName("message") val message: String
)
