package moshiSerialization.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ktSerialization.models.base.ComponentModel

@JsonClass(generateAdapter = true)
data class MoshiDataContentModel(
    @Json(name = "header") val header: List<ComponentModel>,
    @Json(name = "body") val body: List<ComponentModel>
)
