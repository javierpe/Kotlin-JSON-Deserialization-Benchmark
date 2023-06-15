package moshiSerialization.models

import com.squareup.moshi.Json

data class MoshiTextModel(
    @Json(name = "text") val text: String
)
