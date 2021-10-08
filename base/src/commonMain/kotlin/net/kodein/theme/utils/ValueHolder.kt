package net.kodein.theme.utils

import kotlin.reflect.KProperty

public abstract class ValueHolder<Self : ValueHolder<Self, Value>, Value> {
    private val byName = HashMap<String, Value>()
    private val byValue = HashMap<Value, String>()

    protected operator fun Value.provideDelegate(self: Self, property: KProperty<*>): Value {
        byName[property.name] = this
        byValue[this] = property.name
        return this
    }
    protected operator fun Value.getValue(self: Self, property: KProperty<*>): Value = this

    public operator fun get(name: String): Value = byName.getValue(name)

    public fun nameOf(value: Value): String = byValue.getValue(value)
    @Suppress("UNCHECKED_CAST")
    public inline fun nameOf(value: Self.() -> Value): String = nameOf(value.invoke(this as Self))

}
