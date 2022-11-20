package tgo1014.timeof.data.models.mappers

import tgo1014.timeof.data.models.WhateverDO
import tgo1014.timeof.domain.models.WhateverDomain

fun WhateverDomain.toDataObject() = WhateverDO(
    name = name,
    duration = duration.inWholeMilliseconds,
    scheduleId = scheduleId,
    created = created.toEpochMilli()
)