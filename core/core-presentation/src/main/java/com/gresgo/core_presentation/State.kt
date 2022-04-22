package com.gresgo.core_presentation

sealed interface State<T>

data class Content<T>(val data: T): State<T>
data class Error<T>(val throwable: Throwable): State<T>
class Loading<T>: State<T>

class Empty<T>: State<T>