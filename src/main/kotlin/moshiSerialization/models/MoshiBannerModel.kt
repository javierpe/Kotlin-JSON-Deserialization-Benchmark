package moshiSerialization.models

import com.squareup.moshi.Json

data class MoshiBannerModel(
    @Json(name = "url") val url: String,
    @Json(name = "type") val type: String
)
