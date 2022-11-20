package tgo1014.timeof.presentation.models

import java.time.Instant
import kotlin.time.Duration

data class WhateverPresentation(
    val name: String,
    val duration: Duration,
    val scheduleId: Long? = null,
    val created: Instant = Instant.now(),
)