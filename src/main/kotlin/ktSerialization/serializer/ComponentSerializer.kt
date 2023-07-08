package ktSerialization.serializer

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ktSerialization.models.banner.BannerParentModel
import ktSerialization.models.base.ComponentModel
import ktSerialization.models.message.MessageParentModel
import ktSerialization.models.text.TextParentModel

object ComponentSerializer {
    val projectJson = Json {
        serializersModule = SerializersModule {
            polymorphic(ComponentModel::class) {
                subclass(TextParentModel::class)
                subclass(BannerParentModel::class)
                subclass(MessageParentModel::class)
            }
        }
    }
}