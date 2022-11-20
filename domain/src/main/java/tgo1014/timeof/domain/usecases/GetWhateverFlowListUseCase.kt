package tgo1014.timeof.domain.usecases

import kotlinx.coroutines.flow.Flow
import tgo1014.timeof.domain.models.WhateverDomain

interface GetWhateverFlowListUseCase {
    operator fun invoke(): Flow<List<WhateverDomain>>
}