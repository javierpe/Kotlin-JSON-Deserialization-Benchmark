package moshiSerialization.models

data class MoshiBannerParentModel(
    override val resource: MoshiBannerModel,
) : MoshiComponentModel<MoshiBannerModel>()
