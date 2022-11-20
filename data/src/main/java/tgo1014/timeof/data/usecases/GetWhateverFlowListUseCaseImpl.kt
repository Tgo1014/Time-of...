package tgo1014.timeof.data.usecases

import tgo1014.timeof.domain.storage.WhateverRepository
import tgo1014.timeof.domain.usecases.GetWhateverFlowListUseCase
import javax.inject.Inject

class GetWhateverFlowListUseCaseImpl @Inject constructor(
    private val whateverRepository: WhateverRepository,
) : GetWhateverFlowListUseCase {
    override fun invoke() = whateverRepository.getAllFlow()
}