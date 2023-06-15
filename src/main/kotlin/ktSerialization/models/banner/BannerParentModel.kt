package ktSerialization.models.banner

import kotlinx.serialization.Serializable
import ktSerialization.models.base.ComponentModel

@Serializable
data class BannerParentModel(
    override val resource: BannerModel,
    override val render: String,
    override val index: Int,
) : ComponentModel()
