package moshiSerialization.models

import com.squareup.moshi.Json

data class MoshiMessageModel(
    @Json(name = "message") val message: String
)
