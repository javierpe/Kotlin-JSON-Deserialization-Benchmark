package ktSerialization.models.text

import kotlinx.serialization.Serializable
import ktSerialization.models.base.ComponentModel

@Serializable
data class TextParentModel(
    override val resource: TextModel,
    override val render: String,
    override val index: Int,
) : ComponentModel()
