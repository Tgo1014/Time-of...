package tgo1014.timeof.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tgo1014.timeof.data.storage.WhateverRepositoryImpl
import tgo1014.timeof.domain.storage.WhateverRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    @Singleton
    abstract fun bind(repo: WhateverRepositoryImpl): WhateverRepository

}