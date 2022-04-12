package com.gresgo.core

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun CoroutineScope.safeLaunch(
    block: suspend CoroutineScope.() -> Unit,
    onError: (Throwable) -> Unit,
    onComplete: () -> Unit = {}
) {
    launch {
        try {
            block.invoke(this)
        } catch (exception: Exception) {
            if (exception !is CancellationException) {
                onError(exception)
            }
        } finally {
            onComplete()
        }
    }
}