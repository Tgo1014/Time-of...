package tgo1014.timeof.domain.models

import java.time.Instant
import kotlin.time.Duration

data class WhateverDomain(
    val name: String,
    val duration: Duration,
    val scheduleId: Long? = null,
    val created: Instant = Instant.now(),
)
