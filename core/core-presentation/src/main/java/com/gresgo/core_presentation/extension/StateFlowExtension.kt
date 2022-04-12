package com.gresgo.core_presentation.extension

import kotlinx.coroutines.flow.MutableStateFlow

fun <T> MutableStateFlow<T>.requireValue(
    errorMessage: String = "required value was null or not set"
): T {
    return this.value ?: error(errorMessage)
}

inline fun <reified T: Any> MutableStateFlow<T>.update(action: T.() -> T) {
    value = action.invoke(requireValue())
}