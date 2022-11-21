package tgo1014.timeof.data.usecases

import kotlinx.coroutines.withContext
import tgo1014.timeof.domain.models.CoroutineProvider
import tgo1014.timeof.domain.models.WhateverDomain
import tgo1014.timeof.domain.storage.WhateverRepository
import tgo1014.timeof.domain.usecases.UpsertWhateverUseCase
import javax.inject.Inject

class UpsertWhateverFlowListUseCaseImpl @Inject constructor(
    private val whateverRepository: WhateverRepository,
    private val coroutineProvider: CoroutineProvider,
) : UpsertWhateverUseCase {
    override suspend fun invoke(whatever: WhateverDomain) = withContext(coroutineProvider.io) {
        whateverRepository.upsert(whatever)
    }
}