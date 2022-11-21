package tgo1014.timeof.presentation.models

import java.time.Instant
import kotlin.time.Duration

data class WhateverPresentation(
    val id: Int = 0,
    val name: String,
    val duration: Duration,
    val created: Instant = Instant.now(),
)