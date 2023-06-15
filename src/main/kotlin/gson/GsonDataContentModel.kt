package gson

import com.google.gson.annotations.SerializedName

data class GsonDataContentModel(
    @SerializedName("header") val header: List<GsonComponentModel>,
    @SerializedName("body") val body: List<GsonComponentModel>
)


@ComponentType(
    property = "render",
    subtypes = [
        ComponentSubType(clazz = GsonTextParentModel::class, name = "text"),
        ComponentSubType(clazz = GsonMessageParentModel::class, name = "message_text"),
        ComponentSubType(clazz = GsonBannerParentModel::class, name = "banner")
    ]
)
abstract class GsonComponentModel {
    abstract val render: String
    abstract val index: Int
    abstract val resource: Any
}


// Models
data class GsonTextModel(
    @SerializedName("text") val text: String
)

data class GsonMessageModel(
    @SerializedName("message") val message: String
)

data class GsonBannerModel(
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String
)

data class GsonBannerParentModel(
    @SerializedName("resource") override val resource: GsonBannerModel,
    @SerializedName("render")override val render: String,
    @SerializedName("index")override val index: Int,
) : GsonComponentModel()

data class GsonMessageParentModel(
    @SerializedName("resource") override val resource: GsonMessageModel,
    @SerializedName("render")override val render: String,
    @SerializedName("index")override val index: Int,
) : GsonComponentModel()

data class GsonTextParentModel(
    @SerializedName("resource") override val resource: GsonTextModel,
    @SerializedName("render")override val render: String,
    @SerializedName("index")override val index: Int,
) : GsonComponentModel()
