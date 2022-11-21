package tgo1014.timeof.domain.models

import kotlin.coroutines.CoroutineContext

interface CoroutineProvider {
    val main: CoroutineContext
    val io: CoroutineContext
}