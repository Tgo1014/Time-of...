package tgo1014.timeof.domain.usecases

import tgo1014.timeof.domain.models.WhateverDomain

interface DeleteWhateverUseCase {
    operator fun invoke(whatever: WhateverDomain)
}