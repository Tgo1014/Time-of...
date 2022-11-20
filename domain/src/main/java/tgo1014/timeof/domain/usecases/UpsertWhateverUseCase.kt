package tgo1014.timeof.domain.usecases

import tgo1014.timeof.domain.models.WhateverDomain

interface UpsertWhateverUseCase {
    operator fun invoke(whatever: WhateverDomain)
}