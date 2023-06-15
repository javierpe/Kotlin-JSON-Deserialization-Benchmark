package gson

import kotlin.reflect.KClass


annotation class ComponentSubType(val clazz: KClass<*>, val name: String)

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ComponentType(val property: String, val subtypes: Array<ComponentSubType>)