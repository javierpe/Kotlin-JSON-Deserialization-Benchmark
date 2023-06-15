package moshiSerialization.config

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moshiSerialization.models.*
import shared.RenderType

fun getMoshi(): Moshi {
    return Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(MoshiComponentModel::class.java, "render")
                .withSubtype(MoshiBannerParentModel::class.java, RenderType.BANNER.value)
                .withSubtype(MoshiMessageParentModel::class.java, RenderType.MESSAGE.value)
                .withSubtype(MoshiTextParentModel::class.java, RenderType.TEXT.value)
        )
        .addLast(KotlinJsonAdapterFactory()).build()
}