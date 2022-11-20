package tgo1014.timeof.presentation.models.mappers

import tgo1014.timeof.domain.models.WhateverDomain
import tgo1014.timeof.presentation.models.WhateverPresentation

fun WhateverDomain.toPresentation() = WhateverPresentation(
    name = name,
    duration = duration,
    scheduleId = scheduleId,
    created = created
)