package tgo1014.timeof.data.models.mappers

import tgo1014.timeof.data.models.WhateverDBO
import tgo1014.timeof.data.models.WhateverData
import tgo1014.timeof.domain.models.WhateverDomain
import java.time.Instant
import kotlin.time.Duration.Companion.milliseconds

fun WhateverDomain.toData() = WhateverData(
    id = id,
    name = name,
    duration = duration.inWholeMilliseconds,
    created = created.toEpochMilli()
)

fun WhateverDomain.toDbo() = WhateverDBO(
    id = id,
    name = name,
    duration = duration.inWholeMilliseconds,
    created = created.toEpochMilli()
)

fun WhateverDBO.toDomain() = WhateverDomain(
    id = id,
    name = name,
    duration = duration.milliseconds,
    created = Instant.ofEpochMilli(created)
)