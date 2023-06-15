package gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException

import java.lang.reflect.Type
import java.util.Arrays


internal class PolymorphDeserializer<T> : JsonDeserializer<T> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, type: Type, context: JsonDeserializationContext): T {
        return try {
            val typeClass = Class.forName(type.typeName)
            val jsonType: ComponentType = typeClass.getDeclaredAnnotation(ComponentType::class.java)
            val property: String = json.asJsonObject.get(jsonType.property).asString
            val subtypes: Array<ComponentSubType> = jsonType.subtypes
            val subType = Arrays.stream(subtypes).filter { subtype -> subtype.name == property }
                .findFirst().orElseThrow { IllegalArgumentException() }.clazz
            context.deserialize(json, subType.javaObjectType)
        } catch (e: Exception) {
            e.printStackTrace()
            throw JsonParseException("Failed deserialize json", e)
        }
    }
}