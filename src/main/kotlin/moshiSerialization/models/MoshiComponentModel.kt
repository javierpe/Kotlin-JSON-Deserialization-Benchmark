package moshiSerialization.models

import com.squareup.moshi.Json

abstract class MoshiComponentModel {
    @Json(name = "render")
    var render: String = ""

    @Json(name = "index")
    var index: Int = 0

    @Json(name = "resource")
    abstract val resource: Any
}
