package tgo1014.timeof.domain.usecases

import tgo1014.timeof.domain.models.WhateverDomain

interface UpsertWhateverUseCase {
    suspend operator fun invoke(whatever: WhateverDomain)
}