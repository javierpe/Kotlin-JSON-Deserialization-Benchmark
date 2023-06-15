package moshiSerialization.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoshiDataContentModel(
    @Json(name = "header") val header: List<MoshiComponentModel>,
    @Json(name = "body") val body: List<MoshiComponentModel>
)
