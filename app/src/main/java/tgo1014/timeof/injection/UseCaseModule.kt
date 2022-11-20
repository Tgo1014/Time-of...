package tgo1014.timeof.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tgo1014.timeof.data.usecases.GetWhateverFlowListUseCaseImpl
import tgo1014.timeof.data.usecases.UpsertWhateverFlowListUseCaseImpl
import tgo1014.timeof.domain.usecases.GetWhateverFlowListUseCase
import tgo1014.timeof.domain.usecases.UpsertWhateverUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetWhateverFlowListUseCase(useCase: GetWhateverFlowListUseCaseImpl): GetWhateverFlowListUseCase

    @Binds
    abstract fun bindUpsertWhateverUseCase(useCase: UpsertWhateverFlowListUseCaseImpl): UpsertWhateverUseCase

}