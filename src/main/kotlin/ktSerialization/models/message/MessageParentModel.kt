package ktSerialization.models.message

import kotlinx.serialization.Serializable
import ktSerialization.models.base.ComponentModel

@Serializable
data class MessageParentModel(
    override val resource: MessageModel,
    override val render: String,
    override val index: Int,
) : ComponentModel()


