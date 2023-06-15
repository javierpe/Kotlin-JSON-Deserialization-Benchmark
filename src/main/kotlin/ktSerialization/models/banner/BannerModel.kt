package ktSerialization.models.banner

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannerModel(
    @SerialName("url") val url: String,
    @SerialName("type") val type: String
)
