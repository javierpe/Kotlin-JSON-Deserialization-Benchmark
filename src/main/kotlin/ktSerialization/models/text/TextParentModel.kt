package ktSerialization.models.text

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ktSerialization.models.base.ComponentModel

@Serializable
@SerialName("text")
data class TextParentModel(
    override val resource: TextModel,
    override val render: String,
    override val index: Int,
) : ComponentModel()
