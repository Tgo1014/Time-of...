package tgo1014.timeof.presentation.models.mappers

import tgo1014.timeof.domain.models.WhateverDomain
import tgo1014.timeof.presentation.models.WhateverPresentation

fun WhateverDomain.toPresentation() = WhateverPresentation(
    id = id,
    name = name,
    duration = duration,
    created = created
)