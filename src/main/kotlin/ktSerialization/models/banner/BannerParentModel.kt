package ktSerialization.models.banner

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ktSerialization.models.base.ComponentModel

@Serializable
@SerialName("banner")
data class BannerParentModel(
    override val resource: BannerModel,
    override val render: String,
    override val index: Int,
) : ComponentModel()
