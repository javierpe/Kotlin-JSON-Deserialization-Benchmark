package ktSerialization.serializer

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import ktSerialization.models.banner.BannerParentModel
import ktSerialization.models.base.ComponentModel
import ktSerialization.models.message.MessageParentModel
import ktSerialization.models.text.TextParentModel
import shared.RenderType

object ComponentSerializer : JsonContentPolymorphicSerializer<ComponentModel>(ComponentModel::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<ComponentModel> {
        return when(
            element.jsonObject["render"].toString().removePrefix("\"").removeSuffix("\"")
        )  {
            RenderType.TEXT.value -> TextParentModel.serializer()
            RenderType.BANNER.value -> BannerParentModel.serializer()
            RenderType.MESSAGE.value -> MessageParentModel.serializer()
            else -> TextParentModel.serializer()
        }
    }
}