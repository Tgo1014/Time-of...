package tgo1014.timeof.data.models

data class WhateverDO(
    val name: String,
    val duration: Long,
    val scheduleId: Long? = null,
    val created: Long,
)
