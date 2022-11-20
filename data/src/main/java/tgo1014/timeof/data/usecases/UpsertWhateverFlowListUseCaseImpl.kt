package tgo1014.timeof.data.usecases

import tgo1014.timeof.domain.models.WhateverDomain
import tgo1014.timeof.domain.storage.WhateverRepository
import tgo1014.timeof.domain.usecases.UpsertWhateverUseCase
import javax.inject.Inject

class UpsertWhateverFlowListUseCaseImpl @Inject constructor(
    private val whateverRepository: WhateverRepository,
) : UpsertWhateverUseCase {
    override fun invoke(whatever: WhateverDomain) {
        whateverRepository.upsert(whatever)
    }
}