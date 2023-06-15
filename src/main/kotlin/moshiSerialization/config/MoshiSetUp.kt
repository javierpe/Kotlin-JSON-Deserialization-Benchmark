package moshiSerialization.config

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ktSerialization.models.banner.BannerParentModel
import ktSerialization.models.base.ComponentModel
import ktSerialization.models.message.MessageParentModel
import ktSerialization.models.text.TextParentModel
import shared.RenderType

fun getMoshi(): Moshi {
    return Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(ComponentModel::class.java, "render")
                .withSubtype(BannerParentModel::class.java, RenderType.BANNER.value)
                .withSubtype(MessageParentModel::class.java, RenderType.MESSAGE.value)
                .withSubtype(TextParentModel::class.java, RenderType.TEXT.value)
        )
        .addLast(KotlinJsonAdapterFactory()).build()
}