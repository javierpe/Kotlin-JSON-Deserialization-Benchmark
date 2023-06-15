package moshiSerialization.models

data class MoshiMessageParentModel(
    override val resource: MoshiMessageModel,
) : MoshiComponentModel()
