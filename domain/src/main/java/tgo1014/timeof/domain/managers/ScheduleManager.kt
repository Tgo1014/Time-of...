package tgo1014.timeof.domain.managers

import tgo1014.timeof.domain.models.WhateverDomain

interface ScheduleManager {
    fun schedule(whateverDomain: WhateverDomain): Long
    fun cancel(scheduleId: Long)
}